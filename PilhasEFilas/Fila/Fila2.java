package Fila;

public class Fila2<T> {
    private ListaEncadeada<T> lista;

    public Fila2() {
        this.lista = new ListaEncadeada<T>();
    }

    public void adicionar(T valor) {
        this.lista.add(valor);
    }

    public void remover() {
        this.lista.remove(this.get());
    }

    public T get() {
        return this.lista.getFirst().getValue();
    }
}
