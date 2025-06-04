public class NoAVL {
    String conteudo;
    NoAVL filhoEsquerdo;
    NoAVL filhoDireito;
    int altura;

    public NoAVL(String conteudo) {
        this.conteudo = conteudo;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
        this.altura = 0;
    }

    public int getAltura() {
        return altura;
    }

    public void atualizarAltura() {
        int altEsq = (filhoEsquerdo != null) ? filhoEsquerdo.altura : -1;
        int altDir = (filhoDireito != null) ? filhoDireito.altura : -1;
        this.altura = 1 + Math.max(altEsq, altDir);
    }

    public int getFatorBalanceamento() {
        int altEsq = (filhoEsquerdo != null) ? filhoEsquerdo.altura : -1;
        int altDir = (filhoDireito != null) ? filhoDireito.altura : -1;
        return altEsq - altDir;
    }
}

