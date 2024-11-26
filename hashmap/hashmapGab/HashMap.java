import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> implements Cloneable, Serializable
{
    private static final long serialVersionUID = 1L;

    private class Elemento implements Serializable {
        private static final long serialVersionUID = 1L;
        private K chave;
        private V valor;

        Elemento(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }

        K getChave() {
            return chave;
        }

        V getValor() {
            return valor;
        }

        void setValor(V valor) {
            this.valor = valor;
        }

        @Override
        public int hashCode() {
            return chave.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Elemento elemento = (Elemento) obj;
            return chave.equals(elemento.chave);
        }
    }

    private ListaEncadeadaSimplesDesordenada<Elemento>[] vetor;
    private int qtdElems = 0;
    private int capacidadeInicial = 20;
    private float txMinDesperdicio;
    private float txMaxDesperdicio;

    // Construtor com capacidade inicial e taxas de desperdício definidas
    public HashMap(int capacidadeInicial, float txMinDesperdicio, float txMaxDesperdicio) {
        this.capacidadeInicial = capacidadeInicial;
        this.txMinDesperdicio = txMinDesperdicio;
        this.txMaxDesperdicio = txMaxDesperdicio;
        this.vetor = new ListaEncadeadaSimplesDesordenada[capacidadeInicial];
    }

    // Construtor com valores padrão para as taxas de desperdício
    public HashMap(int capacidadeInicial) {
        this(capacidadeInicial, 0.7f, 0.9f);
    }

    // Método para guardar um item no HashMap
    public void guardeUmItem(K chave, V valor) throws Exception {
        if (recupereUmItem(chave) != null)
            throw new Exception("Chave já existente!");

        int index = calculaPosicao(chave);
        if (vetor[index] == null) {
            vetor[index] = new ListaEncadeadaSimplesDesordenada<>();
        }
        vetor[index].guardeNoFinal(new Elemento(chave, valor));
        qtdElems++;

        verificarRedimensionamento();
    }
    
    // Método para atualizar valor de um item
    public void atualizeValor(K chave, V novoValor) throws Exception {
        int index = calculaPosicao(chave);

        if (vetor[index] != null) {
            var no = vetor[index].getPrimeiroNo();
            while (no != null) {
                Elemento elem = no.getInfo();

                if (elem.getChave().equals(chave)) {
                    elem.setValor(novoValor); // Atualiza o valor do item
                    return;
                }

                no = no.getProx();
            }
        }
        throw new Exception("Chave não encontrada!"); // Lança exceção se a chave não existir
    }

    // Método para remover um item do HashMap
    public void removaUmItem(K chave) throws Exception {
        int index = calculaPosicao(chave);

        if (vetor[index] != null) {
            Elemento paraRemover = null;

            var no = vetor[index].getPrimeiroNo();
            while (no != null) {
                Elemento elem = no.getInfo();

                if (elem.getChave().equals(chave)) {
                    paraRemover = elem;
                    break;
                }

                no = no.getProx();
            }

            if (paraRemover != null) {
                vetor[index].remova(paraRemover);
                qtdElems--;
                verificarRedimensionamento();
            } else {
                throw new Exception("Chave não encontrada!");
            }
        } else {
            throw new Exception("Chave não encontrada!");
        }
    }

    // Método para recuperar um item do HashMap
    public V recupereUmItem(K chave) throws Exception {
        int index = calculaPosicao(chave);

        if (vetor[index] != null) {
            var no = vetor[index].getPrimeiroNo();
            while (no != null) {
                Elemento elem = no.getInfo();

                if (elem.getChave().equals(chave)) {
                    return elem.getValor();
                }

                no = no.getProx();
            }
        }
        return null;  // Chave não encontrada
    }

    // Método para calcular a posição no vetor com base no hashCode e no tamanho do vetor
    private int calculaPosicao(K chave) {
        int hash = chave.hashCode();
        return Math.abs(hash % vetor.length);
    }

    // Método para verificar se é necessário redimensionar o vetor
    private void verificarRedimensionamento() throws Exception {
        float txDesperdicio = (float) qtdElems / vetor.length;

        if (txDesperdicio > txMaxDesperdicio) {
            redimensionar(vetor.length * 2); // Aumenta o tamanho do vetor
        } else if (txDesperdicio < txMinDesperdicio && vetor.length / 2 >= capacidadeInicial) {
            redimensionar(vetor.length / 2); // Diminui o tamanho do vetor
        }
    }

    // Método para redimensionar o vetor e recalcular as posições
    private void redimensionar(int novaCapacidade) throws Exception {
        ListaEncadeadaSimplesDesordenada<Elemento>[] novoVetor = new ListaEncadeadaSimplesDesordenada[novaCapacidade];

        for (ListaEncadeadaSimplesDesordenada<Elemento> lista : vetor) {
            if (lista != null) {
                var no = lista.getPrimeiroNo();

                while (no != null)
                {
                    Elemento elem = no.getInfo();

                    int novoIndex = Math.abs(elem.hashCode() % novaCapacidade);
                    if (novoVetor[novoIndex] == null) {
                        novoVetor[novoIndex] = new ListaEncadeadaSimplesDesordenada<>();
                    }
                    novoVetor[novoIndex].guardeNoFinal(elem);

                    no = no.getProx();
                }
            }
        }
        
        vetor = novoVetor;
    }

    // construtores e overrides
    // Método para clonar o HashMap
    @Override
    public HashMap<K, V> clone() throws CloneNotSupportedException {
        HashMap<K, V> clone = (HashMap<K, V>) super.clone();
        clone.vetor = new ListaEncadeadaSimplesDesordenada[vetor.length];

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != null) {
                try {
                    clone.vetor[i] = new ListaEncadeadaSimplesDesordenada<>(vetor[i]);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return clone;
    }

    // Função para converter o hashmap em uma lista sequencial
    public ListaEncadeadaSimplesDesordenada<ListaEncadeadaSimplesDesordenada<Object>> paraLista() throws Exception {
        ListaEncadeadaSimplesDesordenada<ListaEncadeadaSimplesDesordenada<Object>> lista = new ListaEncadeadaSimplesDesordenada<>();
    
        for (ListaEncadeadaSimplesDesordenada<Elemento> listaEncadeada : vetor) {
            if (listaEncadeada != null) {
                var no = listaEncadeada.getPrimeiroNo();
                while (no != null) {
                    Elemento elem = no.getInfo();
                    
                    // Cria uma nova lista com a chave e o valor
                    ListaEncadeadaSimplesDesordenada<Object> parChaveValor = new ListaEncadeadaSimplesDesordenada<Object>();
                    parChaveValor.guardeNoFinal(elem.getChave());  // Adiciona a chave
                    parChaveValor.guardeNoFinal(elem.getValor());  // Adiciona o valor
                    
                    // Adiciona a lista de chave e valor na lista principal
                    lista.guardeNoFinal(parChaveValor);
                    
                    no = no.getProx();
                }
            }
        }
    
        return lista;
    }

    // public ListaEncadeadaSimplesDesordenada<Object> paraLista() throws Exception {
    //     ListaEncadeadaSimplesDesordenada<Object> lista = new ListaEncadeadaSimplesDesordenada<>();

    //     for (ListaEncadeadaSimplesDesordenada<Elemento> listaEncadeada : vetor) {
    //         if (listaEncadeada != null) {
    //             var no = listaEncadeada.getPrimeiroNo();
    //             while (no != null) {
    //                 Elemento elem = no.getInfo();
    //                 lista.guardeNoFinal(elem.getChave());  // Adiciona a chave
    //                 lista.guardeNoFinal(elem.getValor());  // Adiciona o valor
    //                 no = no.getProx();
    //             }
    //         }
    //     }

    //     return lista;
    // }

    // Métodos para retornar o tamanho atual e a capacidade do HashMap
    public int getTamanho() {
        return qtdElems;
    }

    public int getCapacidade() {
        return vetor.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        boolean primeiroElemento = true;
        for (ListaEncadeadaSimplesDesordenada<Elemento> lista : vetor) {
            if (lista != null) {
                ListaEncadeadaSimplesDesordenada<HashMap<K, V>.Elemento>.No no = null;

                try {
                    no = lista.getPrimeiroNo();
                } catch (Exception e) {
                    //e.printStackTrace();
                }

                while (no != null) {
                    var elem = no.getInfo();

                    if (!primeiroElemento) {
                        sb.append(", ");
                    }
                    sb.append(elem.getChave()).append("=").append(elem.getValor());
                    primeiroElemento = false;

                    no = no.getProx();
                }
            }
        }

        sb.append("}");
        return sb.toString();
    }
}