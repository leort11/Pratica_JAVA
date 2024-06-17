package Pilha;

public class Main {
    public static void main(String[] args) {
        Pilha<String> pilha = new Pilha<String>();

        pilha.adicionar("E");
        pilha.adicionar("B");
        pilha.adicionar("Z");
        pilha.adicionar("D");
        pilha.adicionar("C");

        System.out.println("Topo " + pilha.get());
        pilha.remover();
        System.out.println("Topo " + pilha.get());
        pilha.remover();
        System.out.println("Topo " + pilha.get());
    }
}
