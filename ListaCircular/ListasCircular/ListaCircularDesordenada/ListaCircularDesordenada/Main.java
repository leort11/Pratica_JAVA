package ListaCircularDesordenada;
public class Main {
    public static void main(String[] args) throws Exception {
        ListaCircularDesordenada<Integer> lista = new ListaCircularDesordenada<Integer>();

        lista.GuardeNoInicio(10);
        lista.GuardeNoInicio(20);
        lista.GuardeNoInicio(30);
        System.out.println(lista.toString());

        lista.RemovaUltimo();
        System.out.println(lista.toString());

        lista.GuardeNoFinal(40);
        System.out.println(lista.toString());
    }
}