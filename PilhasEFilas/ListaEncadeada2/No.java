package ListaEncadeada2;

public class No<T> {
    private T valor;
    private No<T> proximo;

    public No(T novoValor) {
        this.valor = novoValor;
    }

    public T getValor() {
        return this.valor;
    }

    public void setValor(T novoValor) {
        this.valor = novoValor;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    
}
