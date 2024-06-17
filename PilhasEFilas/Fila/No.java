package Fila;

public class No<T> {
    private T value;
    private No<T> next;


    // CONSTRUCTOR:
    public No(T newValue) {
        this.value = newValue;
    }

    
    // GETTERS and SETTERS:
    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public No<T> getNext() {
        return this.next;
    }

    public void setNext(No<T> next) {
        this.next = next;
    }
}
