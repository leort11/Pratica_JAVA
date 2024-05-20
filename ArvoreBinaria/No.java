public class No<X> {
    private X valor;
    private No<X> esquerda;
    private No<X> direita;

    public No(X valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    public X getValor() {
        return valor;
    }

    public void setValor(X valor) {
        this.valor = valor;
    }

    public No<X> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No<X> esquerda) {
        this.esquerda = esquerda;
    }

    public No<X> getDireita() {
        return direita;
    }

    public void setDireita(No<X> direita) {
        this.direita = direita;
    }
}
