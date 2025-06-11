public class ArvoreRubroNegra {
    private NoRubroNegro raiz;

    public void inserir(String valor) {
        NoRubroNegro novo = new NoRubroNegro(valor);
        raiz = inserirBST(raiz, novo);
        corrigir(novo);
    }

    private NoRubroNegro inserirBST(NoRubroNegro atual, NoRubroNegro novo) {
        if (atual == null) return novo;

        if (novo.conteudo.compareTo(atual.conteudo) < 0) {
            atual.filhoEsquerdo = inserirBST(atual.filhoEsquerdo, novo);
            atual.filhoEsquerdo.pai = atual;
        } else {
            atual.filhoDireito = inserirBST(atual.filhoDireito, novo);
            atual.filhoDireito.pai = atual;
        }

        return atual;
    }

    private void corrigir(NoRubroNegro no) {
        while (no != raiz && no.pai.cor) {
            NoRubroNegro avo = no.pai.pai;

            if (no.pai == avo.filhoEsquerdo) {
                NoRubroNegro tio = avo.filhoDireito;

                if (tio != null && tio.cor) {
                    no.pai.cor = false;
                    tio.cor = false;
                    avo.cor = true;
                    no = avo;
                } else {
                    if (no == no.pai.filhoDireito) {
                        no = no.pai;
                        rotacaoEsquerda(no);
                    }
                    no.pai.cor = false;
                    avo.cor = true;
                    rotacaoDireita(avo);
                }
            } else {
                NoRubroNegro tio = avo.filhoEsquerdo;

                if (tio != null && tio.cor) {
                    no.pai.cor = false;
                    tio.cor = false;
                    avo.cor = true;
                    no = avo;
                } else {
                    if (no == no.pai.filhoEsquerdo) {
                        no = no.pai;
                        rotacaoDireita(no);
                    }
                    no.pai.cor = false;
                    avo.cor = true;
                    rotacaoEsquerda(avo);
                }
            }
        }
        raiz.cor = false;
    }

    private void rotacaoEsquerda(NoRubroNegro no) {
        NoRubroNegro filho = no.filhoDireito;
        no.filhoDireito = filho.filhoEsquerdo;

        if (filho.filhoEsquerdo != null) filho.filhoEsquerdo.pai = no;

        filho.pai = no.pai;

        if (no.pai == null) raiz = filho;
        else if (no == no.pai.filhoEsquerdo) no.pai.filhoEsquerdo = filho;
        else no.pai.filhoDireito = filho;

        filho.filhoEsquerdo = no;
        no.pai = filho;
    }

    private void rotacaoDireita(NoRubroNegro no) {
        NoRubroNegro filho = no.filhoEsquerdo;
        no.filhoEsquerdo = filho.filhoDireito;

        if (filho.filhoDireito != null) filho.filhoDireito.pai = no;

        filho.pai = no.pai;

        if (no.pai == null) raiz = filho;
        else if (no == no.pai.filhoDireito) no.pai.filhoDireito = filho;
        else no.pai.filhoEsquerdo = filho;

        filho.filhoDireito = no;
        no.pai = filho;
    }
}
