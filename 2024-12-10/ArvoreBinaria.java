public class ArvoreBinaria<X extends Comparable<X>> {
    private No<X> raiz;
    private int tamanho;
    
    public ArvoreBinaria(No<X> raiz) {
        this.raiz = raiz;
        this.tamanho = 0;
    }

    // Função para inserir um nó na árvore binária, funciona como a função inserirRecursivo
    private void inserirRecursivo(No<X> atual, No<X> novo) {
        if (novo.getValor().compareTo(atual.getValor()) < 0) {
            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novo);
            } else {
                inserirRecursivo(atual.getEsquerda(), novo);
            }
        } else {
            if (atual.getDireita() == null) {
                atual.setDireita(novo);
            } else {
                inserirRecursivo(atual.getDireita(), novo);
            }
        }
    }

    public No<X> getRaiz() {
        return raiz;
    }

    public void setRaiz(No<X> raiz) {
        this.raiz = raiz;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void inserir(No<X> no) {
        if (this.raiz == null) {
            this.raiz = no;
        } else {
            inserirRecursivo(this.raiz, no);
        }
    }

    // Questão 1:
    public boolean VerificaIgual(ArvoreBinaria<X> arvore) {
        return VerificaIgualRec(this.getRaiz(), arvore.getRaiz());
    }

    public boolean VerificaIgualRec(No<X> arvore1, No<X> arvore2) {
        if (arvore1 == null && arvore2 == null) {
            return true;
        } else if (arvore1 == null || arvore2 == null) {
            return false;
        } else {
            return arvore1.getValor().equals(arvore2.getValor()) && 
            VerificaIgualRec(arvore1.getEsquerda(), arvore2.getEsquerda()) && 
            VerificaIgualRec(arvore1.getDireita(), arvore2.getDireita());
        }
    }

    // Questão 2:
    public boolean VerificaEstruturaIgual(No<X> arvore1, No<X> arvore2) {
        if (arvore1 == null && arvore2 == null) {
            return true;
        } else if (arvore1 == null || arvore2 == null) {
            return false;
        } else {
            return VerificaEstruturaIgual(arvore1.getEsquerda(), arvore2.getEsquerda()) && 
            VerificaEstruturaIgual(arvore1.getDireita(), arvore2.getDireita());
        }
    }

    // Questão 3:
    public boolean VerificaEspelhada(No<X> arvore1, No<X> arvore2) {
        if (arvore1 == null && arvore2 == null) {
            return true;
        } else if (arvore1 == null || arvore2 == null) {
            return false;
        } else {
            return arvore1.getValor().equals(arvore2.getValor()) && 
            VerificaEspelhada(arvore1.getEsquerda(), arvore2.getDireita()) && 
            VerificaEspelhada(arvore1.getDireita(), arvore2.getEsquerda());
        }
    }

    // Questão 4:
    public String preOrdem(No<X> arvore) {
        if (arvore == null) {
            return "";
        } else { 
            return arvore.getValor().toString() + " " + preOrdem(arvore.getEsquerda()) + preOrdem(arvore.getDireita());
        }
    }

    // Questão 5:
    public String inOrdem(No<X> arvore) {
        if (arvore == null) {
            return "";
        } else {
            return inOrdem(arvore.getEsquerda()) + arvore.getValor().toString() + " " + inOrdem(arvore.getDireita());
        }
    }

    // Questão 6:
    public String posOrdem(No<X> arvore) {
        if (arvore == null) {
            return "";
        } else {
            return posOrdem(arvore.getEsquerda()) + posOrdem(arvore.getDireita()) + arvore.getValor().toString() + " ";
        }
    }

    // Questão 7:
    public String notacaoCebola(No<X> arvore) {
        if (arvore == null) {
            return "";
        } else {
            return "(" + notacaoCebola(arvore.getEsquerda()) + arvore.getValor().toString() + notacaoCebola(arvore.getDireita()) + ")";
        }
    }

}