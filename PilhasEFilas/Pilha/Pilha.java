package Pilha;

public class Pilha<T> {
    private ListaEncadeada<T> lista;

    public Pilha() {
        this.lista = new ListaEncadeada<T>();
    }

    public void adicionar(T valor) {
        this.lista.addFirst(valor);
    }

    public void remover() {
        this.lista.remove(this.get());
    }

    public T get() {
        return this.lista.getFirst().getValue();
    }
}