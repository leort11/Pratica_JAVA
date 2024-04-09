package ListaCircularOrdenada;
public class Main {
public static void main(String[] args) {
        ListaCircularOrdenada<Integer> lista = new ListaCircularOrdenada<Integer>();

        lista.Guardar(10);
        lista.Guardar(20);
        lista.Guardar(30);
        System.out.println(lista.toString());

        lista.Remover(10);
        lista.Guardar(11);
        System.out.println(lista.toString());
    }
}