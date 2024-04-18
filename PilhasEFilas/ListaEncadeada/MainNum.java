package ListaEncadeada;

public class MainNum {
    public static void main(String[] args) {
        ListaEncadeada<Integer> numbers = new ListaEncadeada<Integer>();
        numbers.add(5);
        numbers.add(10);
        numbers.add(3);

        System.out.println("Size: " + numbers.getSize());
        for(int i = 0; i < numbers.getSize(); i++) {
            System.out.println(numbers.get(i).getValue());
        }

    }
}