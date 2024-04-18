package ListaEncadeada;

public class ListaEncadeada<T> {
    private No<T> last;
    private No<T> first;
    private int size;

    // CONSTRUCTOR:
    public ListaEncadeada() {
        this.size = 0;

    }


    // GETTERS and SETTERS:
    public No<T> getLast() {
        return last;
    }
    public void setLast(No<T> last) {
        this.last = last;
    }
    public No<T> getFirst() {
        return first;
    }
    public void setFirst(No<T> first) {
        this.first = first;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }


    // FUNCTIONS:
    public void add(T newValue) {
        No<T> newNo = new No<T>(newValue);

        // if it is the only value:
        if(this.first == null && this.last == null) {
            this.first = newNo;
            this.last = newNo;

        } else {
            this.last.setNext(newNo);
            this.last = newNo;
        }

        this.size++;
    }

    public void remove(T removeValue) {
        No<T> before = null;
        No<T> actual = this.first;

        for(int i = 0; i < this.getSize(); i++) {
            if(actual.getValue().equals(removeValue)){
                if(actual == first && actual == last) {
                    this.first = null;
                    this.last = null;

                } else if(actual == this.first) {
                    this.first = actual.getNext();
                    actual.setNext(null);

                } else if(actual == last) {
                    this.last = before;
                    before.setNext(null);

                } else {
                    before.setNext(actual.getNext());
                    actual = null;

                }
                this.size--;
                break;
                
            }

            before = actual;
            actual = actual.getNext();
        }
    }

    public No<T> get(int position) {
        No<T> actual = this.first;

        for(int i = 0; i < position; i++) {
            if(actual.getNext() != null){
                actual = actual.getNext();
            }
        }

        return actual;
    }
}
