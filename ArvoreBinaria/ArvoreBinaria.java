public class ArvoreBinaria<X extends Comparable> {

    private No<X> raiz;

    public ArvoreBinaria() {
        this.raiz = null;

    }

    // Adiciona um valor na árvore:
    public void adicionar(X valor) {
        No<X> novoNo = new No<X>(valor);

        // Se a árvore estiver vazia, o novo nó será a raiz:
        if (raiz == null) {
            this.raiz = novoNo;

        } else { // Se a árvore não estiver vazia, percorre a árvore para encontrar a posição correta para o novo nó:
            No<X> atual = this.raiz;

            while(true) {
                if (novoNo.getValor().compareTo(atual.getValor()) == -1) {
                    if (atual.getEsquerda() != null) {
                        atual = atual.getEsquerda();

                    } else {
                        atual.setEsquerda(novoNo);
                        break;

                    }
                } else { // se for maior ou igual
                    if (atual.getDireita() != null) {
                        atual = atual.getDireita();

                    } else {
                        atual.setDireita(novoNo);
                        break;

                    }
                }
            }
        }
    } 

    public No<X> getRaiz() {
        return raiz;

    }

    // Percorre a árvore em ordem:
    public void emOrdem(No<X> atual) {
        if (atual != null) {
            emOrdem(atual.getEsquerda());
            System.out.println(atual.getValor());
            emOrdem(atual.getDireita());

        }
    }

    // Percorre a árvore em pré-ordem:
    public void preOrdem(No<X> atual) {
        if (atual != null) {
            System.out.println(atual.getValor());
            preOrdem(atual.getEsquerda());
            preOrdem(atual.getDireita());

        }
    }

    // Percorre a árvore em pós-ordem:
    public void posOrdem(No<X> atual) {
        if (atual != null) {
            posOrdem(atual.getEsquerda());
            posOrdem(atual.getDireita());
            System.out.println(atual.getValor());

        }
    }

    // Remove um valor da árvore:
    public boolean remover(X valor) {
        // buscar o elemento na arvore
        No<X> atual = this.raiz;
        No<X> paiAtual = null;

        while(atual != null) {
            if (atual.getValor().equals(valor)) { // O valor procurado é igual ao atual.
                break;

            } else if (valor.compareTo(atual.getValor()) == -1){ // O valor é menor que o atual, então ele vai para a esquerda.
                paiAtual = atual;
                atual = atual.getEsquerda();

            } else {
                paiAtual = atual; // O valor não é igual nem menor, então é maior, e anda para a direita.
                atual = atual.getDireita();

            }
        }

        // Verifica se existe o elemento.
        if (atual != null) {

            // No tem 2 filhos ou No tem somente filho a direita.
            if (atual.getDireita() != null) {
                No<X> substituto = atual.getDireita();
                No<X> paiSubstituto = atual;

                while(substituto.getEsquerda() != null) {
                    paiSubstituto = substituto;
                    substituto = substituto.getEsquerda();
                    
                }
                substituto.setEsquerda(atual.getEsquerda());
                if (paiAtual != null){

                    if (atual.getValor().compareTo(paiAtual.getValor())  == -1) { // atual < paiAtual
                        paiAtual.setEsquerda(substituto);

                    } else {
                        paiAtual.setDireita(substituto);

                    }

                } else { // Se não tem paiAtual, então é a raiz.
                    this.raiz = substituto;

                }

                // Removeu o elemento da arvore.
                if (substituto.getValor().compareTo(paiSubstituto.getValor())  == -1) { // substituto < paiSubstituto
                    paiSubstituto.setEsquerda(null);
                } else {
                    paiSubstituto.setDireita(null);
                }

            } else if (atual.getEsquerda() != null) { // Tem filho só à esquerda.
                No<X> substituto = atual.getEsquerda();
                No<X> paiSubstituto = atual;

                if (paiAtual != null) {
                    while(substituto.getDireita() != null) {
                        paiSubstituto = substituto;
                        substituto = substituto.getDireita();
                        
                    }
                } else { // Se for a raiz.
                    this.raiz = substituto;

                }

                if (atual.getValor().compareTo(paiAtual.getValor())  == -1) { // atual < paiAtual
                    paiAtual.setEsquerda(substituto);

                } else {
                    paiAtual.setDireita(substituto);

                }

                // Removeu o elemento da arvore.
                if (substituto.getValor().compareTo(paiSubstituto.getValor())  == -1) { // substituto < paiSubstituto
                    paiSubstituto.setEsquerda(null);
                } else {
                    paiSubstituto.setDireita(null);
                }

            } else { // Não tem filho.
                if (paiAtual != null) {
                    if (atual.getValor().compareTo(paiAtual.getValor())  == -1) { // atual < paiAtual
                        paiAtual.setEsquerda(null);

                    } else {
                        paiAtual.setDireita(null);

                    }
                } else { // É a raiz.
                    this.raiz = null;
                }
            }

            return true;
        } else {
            return false;
        }
    }
}