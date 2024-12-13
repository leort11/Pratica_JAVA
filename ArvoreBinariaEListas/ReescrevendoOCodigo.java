public class ReescrevendoOCodigo<X> implements Comparable<ReescrevendoOCodigo<X>> {
    private No<X> raiz;
    private int tamanho;

    public ReescrevendoOCodigo() {
        this.raiz = null;
        this.tamanho = 0;
    }

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

    public void inserir(X novoNo) {
        No<X> novo = new No<>(novoNo);
        if (this.raiz == null) {
            this.raiz = novo;
        } else {
            inserirRecursivo(this.raiz, novo);
        }
    }

    public boolean verificaIgual(No<X> arvore) {
        return verificaIgualRec(this.raiz, arvore);
    }

    // (1):
    private boolean verificaIgualRec(No<X> arvore1, No<X> arvore2) {
        if (arvore1 == null && arvore2 == null) {
            return true;
        } else if (arvore1 == null || arvore2 == null) {
            return false;
        } else {
            return arvore1.getValor().equals(arvore2.getValor) &&
            verificaIgualRec(arvore1.getEsquerda(), arvore2.getEsquerda()) &&
            verificaIgualRec(arvore1.getDireita(), arvore2.getDireita());
        }
    }

    // (2):
    public boolean verificaEstruturaIgual(No<X> arvore) {
        return verificaEstruturaIgualRec(this.raiz, arvore);
    }

    private boolean verificaEstruturaIgualRec(No<X> arvore1, No<X> arvore2) {
        if (arvore1 == null && arvore2 == null) {
            return true;
        } else if (arvore1 == null || arvore2 == null) {
            return false;
        } else {
            return verificaEstruturaIgualRec(arvore1.getEsquerda(), arvore2.getEsquerda()) &&
            verificaEstruturaIgualRec(arvore1.getDireita(), arvore2.getDireita());
        }
    }

    // (3):
    public boolean verificaEspelhada(No<X> arvore) {
        return verificaEspelhadaRec(this.raiz, arvore);
    }

    private boolean verificaEspelhadaRec(No<X> arvore1, No<X> arvore2) {
        if (arvore1 == null && arvore2 == null) {
            return true;
        } else if (arvore1 == null || arvore2 == null) {
            return false;
        } else {
            return arvore1.getValor().equals(arvore2.getValor()) &&
            verificaEspelhadaRec(arvore1.getEsquerda(), arvore2.getDireita()) &&
            verificaEspelhadaRec(arvore1.getDireita(), arvore2.getEsquerda());
        }
    }

    // (4):
    public String preOrdem(No<X> arvore) {
        if (arvore == null) {
            return "";
        } else {
            return arvore.getValor().toString() + " " + preOrdem(arvore.getEsquerda()) + preOrdem(arvore.getDireita());
        }
    }

    // (5):
    public String inOrdem(No<X> arvore) {
        if (arvore == null) {
            return "";
        } else {
            return inOrdem(arvore.getEsquerda()) + arvore.getValor().toString() + " " + inOrdem(arvore.getDireita());
        }
    }

    // (6):
    public String posOrdem(No<X> arvore) {
        if (arvore == null) {
            return "";
        } else {
            return posOrdem(arvore.getEsquerda()) + posOrdem(arvore.getDireita()) + arvore.getValor().toString() + "";
        }
    }

    // (7):
    public String notacaoCebola(No<X> arvore) {
        if (arvore == null) {
            return "()";
        } else {
            return "(" + notacaoCebola(arvore.getEsquerda()) + arvore.getValor().toString() + notacaoCebola(arvore.getDireita()) + ")";
        }
    }
}