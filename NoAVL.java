public class NoAVL {
    String conteudo;
    No filhoEsquerdo;
    No filhoDireito;
    int fatorBalanceamento;

    public NoAVL(String conteudo) {
        this.conteudo = conteudo;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
        this.fatorBalanceamento = 0;
    }

}

