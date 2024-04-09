package ListaCircularDesordenada;
import java.lang.Cloneable;
public class ListaCircularDesordenada<T> implements Cloneable{
    private No<T> primeiro;

    private static class No<T> implements Cloneable{
        T dado;
        No<T> proximo;

        public No(T dado) {
            this.dado = dado;
            this.proximo = null;
        }

        @Override
        public String toString() {
            return dado.toString();
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

            if (!((No) obj).dado.equals(this.dado)) {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode() {
            int ret = 13;

            ret = ret * 7 + dado.hashCode();

            if (ret < 0) {
                ret = -ret;
            }

            return ret;
        }

        public Object clone() {
            No<T> ret = null;

            try {
                ret = new No<>(this);
            } catch (Exception e) {
            }

            return ret;
        }
        public No(No<T> modelo) throws Exception {
            if (modelo == null) {
                throw new Exception("Modelo Ausente");
            }
            if (modelo.dado instanceof Cloneable) {
                this.dado = (T) modelo.dado.getClass().getMethod("clone").invoke(modelo.dado);
            } else {
                this.dado = modelo.dado;
            }
        }
        
    }

    public ListaCircularDesordenada() {
        this.primeiro = null;
    }

    public boolean EstaVazia() {
        return primeiro == null;
    }

    public void GuardeNoInicio(T dado) throws Exception {
        if (dado == null) {
            throw new Exception("Dado ausente");
        }

        No<T> novo = new No<>(dado);
        if (EstaVazia()) {
            novo.proximo = novo;
        } else {
            No<T> ultimo = primeiro;
            while (ultimo.proximo != primeiro) {
                ultimo = ultimo.proximo;
            }
            novo.proximo = primeiro;
            ultimo.proximo = novo;
        }
        primeiro = novo;
    }

    public void GuardeNoFinal(T dado) throws Exception {
        if (dado == null) {
            throw new Exception("Dado ausente");
        }

        No<T> novo = new No<>(dado);
        if (EstaVazia()) {
            novo.proximo = novo;
            primeiro = novo;
        } else {
            No<T> ultimo = primeiro;
            while (ultimo.proximo != primeiro) {
                ultimo = ultimo.proximo;
            }
            novo.proximo = primeiro;
            ultimo.proximo = novo;
        }
    }

    public boolean Tem(T dado) {
        if (EstaVazia()) {
            return false;
        }

        No<T> atual = primeiro;
        do {
            if (atual.dado.equals(dado)) {
                return true;
            }
            atual = atual.proximo;
        } while (atual != primeiro);
        return false;
    }

    public T GetPrimeiro() throws Exception {
        if (EstaVazia()) {
            throw new Exception("Lista vazia");
        }

        return primeiro.dado;
    }

    public T GetUltimo() throws Exception {
        if (EstaVazia()) {
            throw new Exception("Lista vazia");
        }

        No<T> ultimo = primeiro;
        while (ultimo.proximo != primeiro) {
            ultimo = ultimo.proximo;
        }
        return ultimo.dado;
    }

    public T Get(int posicao) throws Exception {
        if (posicao < 0) {
            throw new Exception("Posição inválida");
        }

        if (EstaVazia()) {
            throw new Exception("Lista vazia");
        }

        No<T> atual = primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
            if (atual == primeiro) {
                throw new Exception("Posição inválida");
            }
        }
        return atual.dado;
    }

    public void RemovaPrimeiro() throws Exception {
        if (EstaVazia()) {
            throw new Exception("Lista vazia");
        }

        if (primeiro.proximo == primeiro) {
            primeiro = null;
        } else {
            No<T> ultimo = primeiro;
            while (ultimo.proximo != primeiro) {
                ultimo = ultimo.proximo;
            }
            primeiro = primeiro.proximo;
            ultimo.proximo = primeiro;
        }
    }

    public void RemovaUltimo() throws Exception {
        if (EstaVazia()) {
            throw new Exception("Lista vazia");
        }

        if (primeiro.proximo == primeiro) {
            primeiro = null;
        } else {
            No<T> penultimo = null;
            No<T> ultimo = primeiro;
            while (ultimo.proximo != primeiro) {
                penultimo = ultimo;
                ultimo = ultimo.proximo;
            }
            penultimo.proximo = primeiro;
        }
    }

    public void Remova(int posicao) throws Exception {
        if (posicao < 0) {
            throw new Exception("Posição inválida");
        }

        if (EstaVazia()) {
            throw new Exception("Lista vazia");
        }

        No<T> anterior = null;
        No<T> atual = primeiro;
        for (int i = 0; i < posicao; i++) {
            anterior = atual;
            atual = atual.proximo;
            if (atual == primeiro) {
                throw new Exception("Posição inválida");
            }
        }

        if (anterior == null) {
            if (atual.proximo == atual) {
                primeiro = null;
            } else {
                No<T> ultimo = primeiro;
                while (ultimo.proximo != primeiro) {
                    ultimo = ultimo.proximo;
                }
                primeiro = atual.proximo;
                ultimo.proximo = primeiro;
            }
        } else {
            anterior.proximo = atual.proximo;
        }
    }

    public void remover(T dado) {
        if (EstaVazia()) {
            return;
        }

        No<T> anterior = null;
        No<T> atual = primeiro;
        do {
            if (atual.dado.equals(dado)) {
                if (anterior == null) {
                    if (atual.proximo == atual) {
                        primeiro = null;
                    } else {
                        No<T> ultimo = primeiro;
                        while (ultimo.proximo != primeiro) {
                            ultimo = ultimo.proximo;
                        }
                        primeiro = atual.proximo;
                        ultimo.proximo = primeiro;
                    }
                } else {
                    anterior.proximo = atual.proximo;
                }
                return;
            }
            anterior = atual;
            atual = atual.proximo;
        } while (atual != primeiro);
    }

    
    
    @Override
    public String toString() {
        if (EstaVazia()) {
            return "[]";
        }

        String ret = "[";

        No<T> atual = primeiro;
        do {
            ret += atual.dado + ", ";
            atual = atual.proximo;
        } while (atual != primeiro);

        return ret + atual.dado + "]";
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

        ListaCircularDesordenada<T> lista = (ListaCircularDesordenada<T>) obj;

        No<T> atualThis = this.primeiro;
        No<T> atualLista = lista.primeiro;

        do {
            if (!atualThis.equals(atualLista)) {
                return false;
            }
            atualThis = atualThis.proximo;
            atualLista = atualLista.proximo;
        } while (atualThis != this.primeiro && atualLista != lista.primeiro);

        return atualThis.equals(atualLista);
    }

    @Override
    public int hashCode() {
        int ret = 11;

        No atual = this.primeiro;
        do {
            ret = ret * 7 + atual.hashCode();
            atual = atual.proximo;
        } while (atual != this.primeiro);

        if (ret < 0) {
            ret = -ret;
        }

        return ret;
    }

    public ListaCircularDesordenada(ListaCircularDesordenada<T> modelo) throws Exception {
        if (modelo == null) 
            throw new Exception("Modelo ausente");

        if (modelo.primeiro == null) {
            this.primeiro = null;
        } else {
            this.primeiro = new No<>(modelo.primeiro);
            No<T> atualDoThis = this.primeiro;
            No<T> atualDoObj = modelo.primeiro;

            while (atualDoObj.proximo != modelo.primeiro) {
                atualDoThis.proximo = new No<>(atualDoObj.proximo);
                atualDoThis = atualDoThis.proximo;
                atualDoObj = atualDoObj.proximo;
            }

            atualDoThis.proximo = this.primeiro;
        }
    }    
    

    public Object clone() {
        ListaCircularDesordenada<T> ret = null;

        try {
            ret = new ListaCircularDesordenada<>(this);
        } catch (Exception e) {
        }

        return ret;
    }
}
