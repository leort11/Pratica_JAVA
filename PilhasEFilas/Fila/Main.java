package Fila;

public class Main {
    public static void main(String[] args) {
        Fila2<String> fila = new Fila2<String>();

        fila.adicionar("Primeiro");
        fila.adicionar("Segundo");
        fila.adicionar("Terceiro");

        System.out.println(fila.get());
        fila.remover();
        System.out.println(fila.get());
        fila.remover();
        System.out.println(fila.get());

    }
}
