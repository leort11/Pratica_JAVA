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
}