package ListaCircularOrdenada;
public class ListaCircularOrdenada<T extends Comparable<T>> implements Cloneable {
    private No primeiro;
    private No ultimo;
    private int tamanho;

    private class No implements Cloneable {
        private int valor;
        private No proximo;

        public No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }

        @Override
        public String toString() {
            return Integer.toString(this.valor);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }

            if (obj == null) {
                return false;
            }

            if (obj.getClass() != this.getClass()) {
                return false;
            }

            if (((No) obj).valor != this.valor) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            int ret = 13;

            ret = ret * 7 + new Integer(this.valor).hashCode();

            if (ret < 0) {
                ret = -ret;
            }

            return ret;
        }

        public No(No modelo) {
            if (modelo == null) {
                throw new IllegalArgumentException("Modelo ausente");
            }

            this.valor = modelo.valor;
            this.proximo = modelo.proximo;
        }

        public Object clone (){
            No ret = null;

            try {
                ret = new No(this);
            } catch (Exception erro) {}

            return ret;
        }
    }

    public ListaCircularOrdenada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void Guardar(int valor) {
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

    public boolean Tem (int valor) {
        if (this.tamanho == 0) {
            return false;
        }

        No atual = this.primeiro;

        while (atual != this.ultimo) {
            if (atual.valor == valor) {
                return true;
            }

            atual = atual.proximo;
        }

        return atual.valor == valor;
    }

    public void Remover(int valor) {
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

    @Override
    public String toString() {
        if (this.tamanho == 0) {
            return "[]";
        }

        String ret = "[";

        No atual = this.primeiro;

        while (atual != this.ultimo) {
            ret += atual.valor + ", ";
            atual = atual.proximo;
        }

        return ret + atual.valor + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        ListaCircularOrdenada<T> lista = (ListaCircularOrdenada<T>) obj;

        if (this.tamanho != lista.tamanho) {
            return false;
        }

        No atualThis = this.primeiro;
        No atualLista = lista.primeiro;

        while (atualThis != this.ultimo) {
            if (!atualThis.equals(atualLista)) {
                return false;
            }

            atualThis = atualThis.proximo;
            atualLista = atualLista.proximo;
        }

        return atualThis.equals(atualLista);
    }

    @Override
    public int hashCode() {
        int ret = 13;

        No atual = this.primeiro;

        while (atual != this.ultimo) {
            ret = ret * 7 + atual.hashCode();
            atual = atual.proximo;
        }

        ret = ret * 7 + atual.hashCode();

        if (ret < 0) {
            ret = -ret;
        }

        return ret;
    }

    public ListaCircularOrdenada(ListaCircularOrdenada<T> modelo) throws Exception{
        if (modelo == null) {
            throw new IllegalArgumentException("Modelo ausente");
        }

        this.primeiro = modelo.primeiro;
        this.ultimo = modelo.ultimo;
        this.tamanho = modelo.tamanho;
    }

    public Object clone() {
        ListaCircularOrdenada<T> ret = null;

        try {
            ret = new ListaCircularOrdenada<T>(this);
        } catch (Exception erro) {}

        return ret;
    }

    
}
