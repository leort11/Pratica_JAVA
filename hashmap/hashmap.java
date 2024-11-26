public class hashmap {
    private class Elemento {
        private K chave; // Chave genérica
        private V valor; // Valor associado à chave

        // Construtor
        Elemento(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }

        K getChave() { return chave; }
        V getValor() { return valor; }
        void setValor(V valor) { this.valor = valor; }

        @Override
        public int hashCode() { return chave.hashCode(); }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Elemento elemento = (Elemento) obj;
            return chave.equals(elemento.chave);
        }
    }

    public void guardeUmItem(K cahve, V valor) throws Exception {
        if (recupereUmItem(chave) != null)
            throw new Exception("chave já existente!");

        int index = calculaPosicao(chave);
        if (vetor[index] == null) {
            vetor[index] = new ListaEncadeadaSimplesDesordenada<>();
        }
        vetor[index].guardeNofinal(new Elemento(chave, valor));
        qtdElems++;

        verificarRedimensionamento();
    }
}