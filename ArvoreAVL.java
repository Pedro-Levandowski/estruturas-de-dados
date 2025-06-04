public class ArvoreAVL {
    NoAVL raiz;

    public ArvoreAVL() {
        this.raiz = null;
    }

    public ArvoreAVL(NoAVL raiz) {
        this.raiz = raiz;
    }

    public void inserir(String conteudo) {
        raiz = inserirNo(raiz, conteudo);
    }

    private NoAVL inserirNo(NoAVL no, String conteudo) {
        if (no == null) {
            return new NoAVL(conteudo);
        }

        if (conteudo.compareTo(no.conteudo) < 0) {
            no.filhoEsquerdo = inserirNo(no.filhoEsquerdo, conteudo);
        } else if (conteudo.compareTo(no.conteudo) > 0) {
            no.filhoDireito = inserirNo(no.filhoDireito, conteudo);
        } else {
            return no;
        }

        no.atualizarAltura();

        int fb = no.getFatorBalanceamento();

        if (fb > 1 && conteudo.compareTo(no.filhoEsquerdo.conteudo) < 0) {
            return rotacaoDireita(no);
        }
        if (fb < -1 && conteudo.compareTo(no.filhoDireito.conteudo) > 0) {
            return rotacaoEsquerda(no);
        }
        if (fb > 1 && conteudo.compareTo(no.filhoEsquerdo.conteudo) > 0) {
            no.filhoEsquerdo = rotacaoEsquerda(no.filhoEsquerdo);
            return rotacaoDireita(no);
        }
        if (fb < -1 && conteudo.compareTo(no.filhoDireito.conteudo) < 0) {
            no.filhoDireito = rotacaoDireita(no.filhoDireito);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void excluir(String conteudo) {
        raiz = excluirNo(raiz, conteudo);
    }

    private NoAVL excluirNo(NoAVL no, String conteudo) {
        if (no == null) {
            return no;
        }

        if (conteudo.compareTo(no.conteudo) < 0) {
            no.filhoEsquerdo = excluirNo(no.filhoEsquerdo, conteudo);
        } else if (conteudo.compareTo(no.conteudo) > 0) {
            no.filhoDireito = excluirNo(no.filhoDireito, conteudo);
        } else {
            if (no.filhoEsquerdo == null || no.filhoDireito == null) {
                NoAVL temp = null;
                if (temp == no.filhoEsquerdo) {
                    temp = no.filhoDireito;
                } else {
                    temp = no.filhoEsquerdo;
                }

                if (temp == null) {
                    temp = no;
                    no = null;
                } else {
                    no = temp;
                }
            } else {
                NoAVL temp = menorValor(no.filhoDireito);
                no.conteudo = temp.conteudo;
                no.filhoDireito = excluirNo(no.filhoDireito, temp.conteudo);
            }
        }

        if (no == null) {
            return no;
        }

        no.atualizarAltura();

        int fb = no.getFatorBalanceamento();

        if (fb > 1 && no.filhoEsquerdo.getFatorBalanceamento() >= 0) {
            return rotacaoDireita(no);
        }
        if (fb > 1 && no.filhoEsquerdo.getFatorBalanceamento() < 0) {
            no.filhoEsquerdo = rotacaoEsquerda(no.filhoEsquerdo);
            return rotacaoDireita(no);
        }
        if (fb < -1 && no.filhoDireito.getFatorBalanceamento() <= 0) {
            return rotacaoEsquerda(no);
        }
        if (fb < -1 && no.filhoDireito.getFatorBalanceamento() > 0) {
            no.filhoDireito = rotacaoDireita(no.filhoDireito);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    private NoAVL menorValor(NoAVL no) {
        while (no.filhoEsquerdo != null) {
            no = no.filhoEsquerdo;
        }
        return no;
    }

    public void buscaPreOrdem() {
        preOrdem(raiz);
    }

    private void preOrdem(NoAVL no) {
        if (no != null) {
            System.out.print(no.conteudo + " ");
            preOrdem(no.filhoEsquerdo);
            preOrdem(no.filhoDireito);
        }
    }

    private NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.filhoEsquerdo;
        NoAVL T2 = x.filhoDireito;

        x.filhoDireito = y;
        y.filhoEsquerdo = T2;

        y.atualizarAltura();
        x.atualizarAltura();

        return x;
    }

    private NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.filhoDireito;
        NoAVL T2 = y.filhoEsquerdo;

        y.filhoEsquerdo = x;
        x.filhoDireito = T2;

        x.atualizarAltura();
        y.atualizarAltura();

        return y;
    }

    private NoAVL rotacaoEsquerdaDireita(NoAVL no) {
        no.filhoEsquerdo = rotacaoEsquerda(no.filhoEsquerdo);
        return rotacaoDireita(no);
    }

    private NoAVL rotacaoDireitaEsquerda(NoAVL no) {
        no.filhoDireito = rotacaoDireita(no.filhoDireito);
        return rotacaoEsquerda(no);
    }
}

