public class Main {
    public static void main(String[] args) {
        // ArvoreBinaria<Integer> arvoreBinaria = new ArvoreBinaria<>(new No<>(100));

        // arvoreBinaria.inserir(new No<>(50));
        // arvoreBinaria.inserir(new No<>(150));
        // arvoreBinaria.inserir(new No<>(25));
        // arvoreBinaria.inserir(new No<>(75));
        // arvoreBinaria.inserir(new No<>(125));
        // arvoreBinaria.inserir(new No<>(175));

        // ArvoreBinaria<Integer> arvoreBinaria2 = new ArvoreBinaria<>(new No<>(100));

        // arvoreBinaria2.inserir(new No<>(50));
        // arvoreBinaria2.inserir(new No<>(150));
        // arvoreBinaria2.inserir(new No<>(25));
        // arvoreBinaria2.inserir(new No<>(75));
        // arvoreBinaria2.inserir(new No<>(125));
        // arvoreBinaria2.inserir(new No<>(175));

        // System.out.println(arvoreBinaria.VerificaIgual(arvoreBinaria2));
        // System.out.println(arvoreBinaria.VerificaEstruturaIgual(arvoreBinaria.getRaiz(), arvoreBinaria2.getRaiz()));
        // System.out.println(arvoreBinaria.VerificaEspelhada(arvoreBinaria.getRaiz(), arvoreBinaria2.getRaiz()));

        // ArvoreBinaria<Integer> arvoreBinaria3 = new ArvoreBinaria<>(new No<>(100));

        // arvoreBinaria3.inserir(new No<>(50));
        // arvoreBinaria3.inserir(new No<>(150));
        // arvoreBinaria3.inserir(new No<>(25));
        // arvoreBinaria3.inserir(new No<>(75));
        // arvoreBinaria3.inserir(new No<>(125));
        // arvoreBinaria3.inserir(new No<>(175));
        // arvoreBinaria3.inserir(new No<>(200));

        // System.out.println(arvoreBinaria.VerificaIgual(arvoreBinaria3));
        // System.out.println(arvoreBinaria.VerificaEstruturaIgual(arvoreBinaria.getRaiz(), arvoreBinaria3.getRaiz()));
        // System.out.println(arvoreBinaria.VerificaEspelhada(arvoreBinaria.getRaiz(), arvoreBinaria3.getRaiz()));

        // System.out.println(arvoreBinaria3.preOrdem(arvoreBinaria3.getRaiz()));
        // System.out.println(arvoreBinaria3.posOrdem(arvoreBinaria3.getRaiz()));
        // System.out.println(arvoreBinaria3.inOrdem(arvoreBinaria3.getRaiz()));

        // System.out.println(arvoreBinaria3.notacaoCebola(arvoreBinaria.getRaiz()));

        ReescrevendoOCodigo<Integer> arvore = new ReescrevendoOCodigo<>(10);

        arvore.inserir(5);
        arvore.inserir(15);
        arvore.inserir(2);
        arvore.inserir(7);
        arvore.inserir(12);

        System.out.println(arvore.notacaoCebola());
    }
}
