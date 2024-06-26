package Fila;

public class Fila <T>{
    private ListaEncadeada<T> lista;

    public Fila() {
        this.lista = new ListaEncadeada<T>();
    }

    public void adicionar(T novoValor) {
        this.lista.add(novoValor);
    }

    public void remover() {
        this.lista.remove(this.get());
    }

    public T get() {
        return this.lista.getFirst().getValue();
    }
}