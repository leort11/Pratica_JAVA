package ListaCircularDesordenadaJAVA;
public class Main {
    public static void main(String[] args) {
        ListaCircularDesordenada<Integer> lista = new ListaCircularDesordenada<Integer>();

        // Adicionar elementos à lista
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);

        // Imprimir a lista
        lista.exibir();
    }
}