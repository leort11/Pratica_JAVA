public class ListaCircularOrdenada<T extends Comparable<T>> {
    private No primeiro;
    private No ultimo;
    private int tamanho;

    private class No {
        private int valor;
        private No proximo;

        public No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    public ListaCircularOrdenada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void inserir(int valor) {
        No novoNo = new No(valor);

        if (this.tamanho == 0) {
            this.primeiro = novoNo;
            this.ultimo = novoNo;
            novoNo.proximo = novoNo;
        } else if (valor <= this.primeiro.valor) {
            novoNo.proximo = this.primeiro;
            this.primeiro = novoNo;
            this.ultimo.proximo = this.primeiro;
        } else if (valor >= this.ultimo.valor) {
            this.ultimo.proximo = novoNo;
            this.ultimo = novoNo;
            this.ultimo.proximo = this.primeiro;
        } else {
            No atual = this.primeiro;

            while (atual.proximo.valor < valor) {
                atual = atual.proximo;
            }

            novoNo.proximo = atual.proximo;
            atual.proximo = novoNo;
        }

        this.tamanho++;
    }

    public void remover(int valor) {
        if (this.tamanho == 0) {
            return;
        }

        if (this.primeiro.valor == valor) {
            this.primeiro = this.primeiro.proximo;
            this.ultimo.proximo = this.primeiro;
            this.tamanho--;
            return;
        }

        No atual = this.primeiro;

        while (atual.proximo != this.primeiro) {
            if (atual.proximo.valor == valor) {
                atual.proximo = atual.proximo.proximo;
                this.tamanho--;
                return;
            }

            atual = atual.proximo;
        }
    }

    public void imprimir() {
        if (this.tamanho == 0) {
            System.out.println("A lista está vazia.");
            return;
        }

        No atual = this.primeiro;

        while (atual != this.ultimo) {
            System.out.print(atual.valor + " -> ");
            atual = atual.proximo;
        }

        System.out.println(atual.valor);
    }
}
