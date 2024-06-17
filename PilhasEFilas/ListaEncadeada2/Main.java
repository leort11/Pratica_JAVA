package ListaEncadeada2;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada<String> lista = new ListaEncadeada<String>();

        lista.adicionar("AC");
        lista.adicionar("BH");
        lista.adicionar("CE");
        lista.adicionar("DF");
        System.out.println("Tamanho: " + lista.getTamanho());
        System.out.println("Primeiro: " + lista.getPrimeiro().getValor());
        System.out.println("Ultimo: " + lista.getUltimo().getValor());

        for(int i=0; i < lista.getTamanho(); i++) {
            System.out.println(lista.get(i).getValor());
        }

        lista.remover("CE");

        System.out.println("\n");
        for(int i=0; i < lista.getTamanho(); i++) {
            System.out.println(lista.get(i).getValor());
        }
    }
}
