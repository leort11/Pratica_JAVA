package ListaEncadeada;

public class No {
    private String value;
    private No next;


    // CONSTRUCTOR:
    public No(String newValue) {
        this.value = newValue;
    }

    
    // GETTERS and SETTERS:
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public No getNext() {
        return this.next;
    }

    public void setNext(No next) {
        this.next = next;
    }
}
