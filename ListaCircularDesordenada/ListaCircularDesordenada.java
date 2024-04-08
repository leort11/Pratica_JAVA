package ListaCircularDesordenadaJAVA;
public class ListaCircularDesordenada<T> {
    private No<T> primeiro;

    private static class No<T> {
        T dado;
        No<T> proximo;

        public No(T dado) {
            this.dado = dado;
            this.proximo = null;
        }
    }

    public ListaCircularDesordenada() {
        this.primeiro = null;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public void inserir(T dado) {
        No<T> novoNo = new No<>(dado);

        if (estaVazia()) {
            novoNo.proximo = novoNo;
            primeiro = novoNo;
        } else {
            No<T> ultimo = primeiro;
            while (ultimo.proximo != primeiro) {
                ultimo = ultimo.proximo;
            }
            novoNo.proximo = primeiro;
            ultimo.proximo = novoNo;
        }
    }

    public void exibir() {
        if (estaVazia()) {
            System.out.println("A lista está vazia.");
            return;
        }

        No<T> atual = primeiro;
        do {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        } while (atual != primeiro);
        System.out.println();
    }
}