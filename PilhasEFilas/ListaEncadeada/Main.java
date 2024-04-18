package ListaEncadeada;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada<String> list = new ListaEncadeada<String>();
        System.out.println(list.getSize());

        list.add("AC");
        list.add("BH");
        list.add("CE");
        list.add("DF");
        System.out.printf("Size: %d \n", list.getSize());
        System.out.printf("First: %s \n", list.getFirst().getValue());
        System.out.printf("Last: %s \n", list.getLast().getValue());

        for(int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i).getValue());
        }

        // REMOVE CE:
        list.remove("CE");
        System.out.println("Removed CE:");
        list.add("SP");
        System.out.println("Adding SP:");
        list.remove("SP");
        list.remove("BH");
        list.remove("AC");
        list.remove("DF");

        System.out.printf("Size: %d \n", list.getSize());
        for(int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i).getValue());
        }
    }
}
