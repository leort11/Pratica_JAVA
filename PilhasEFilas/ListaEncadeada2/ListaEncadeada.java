package ListaEncadeada2;

public class ListaEncadeada<T> {
    private No<T> primeiro;
    private No<T> ultimo;
    private int tamanho;

    public No<T> getPrimeiro() {
        return primeiro;
    }
    public void setPrimeiro(No<T> primeiro) {
        this.primeiro = primeiro;
    }
    public No<T> getUltimo() {
        return ultimo;
    }
    public void setUltimo(No<T> ultimo) {
        this.ultimo = ultimo;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
   
   
    public ListaEncadeada() {
        this.tamanho = 0;
    }

    public void adicionar(T novoValor) {
        No<T> novoNo = new No<T>(novoValor);

        if (this.primeiro == null && this.ultimo == null) {
            this.primeiro = novoNo;
            this.ultimo = novoNo;
        } else {
            this.ultimo.setProximo(novoNo);
            this.ultimo = novoNo;
        }
        
        this.tamanho++;
    }

    public void remover(T valor) {
        No<T> anterior = null;
        No<T> atual = this.primeiro;
        
        for (int i=0; i < this.getTamanho(); i++) {
            if (atual.getValor().equals(valor)) {

                if (atual == this.primeiro && atual == this.ultimo) {
                    this.primeiro = null;
                    this.ultimo = null;
                } else if (atual == this.primeiro) {
                    this.primeiro = atual.getProximo();
                    atual.setProximo(null);

                } else if (atual == this.ultimo) {
                    this.ultimo = anterior;
                    anterior.setProximo(null);

                } else {
                    anterior.setProximo(atual.getProximo());
                    atual = null;

                }

                this.tamanho--;
                break;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
    }

    public No<T> get(int posicao) {
        No<T> atual = this.primeiro;

        for(int i=0; i < posicao; i++) {
            if (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
        }

        return atual;
    }
    


}
