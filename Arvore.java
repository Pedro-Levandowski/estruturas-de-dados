public class Arvore {
    No raiz;

    public Arvore(No raiz) {
        this.raiz = raiz;
    }

    public int contarNos(No no) {
        if (no == null) return 0;
        return 1 + contarNos(no.filhoEsquerdo) + contarNos(no.filhoDireito);
    }

    public void percorrerPreOrdem(No no){
        if (no != null){
            System.out.print(no.conteudo + " ");
            percorrerPreOrdem(no.filhoEsquerdo);
            percorrerPreOrdem(no.filhoDireito);
        }
    }

    public void percorrerEmOrdem(No no){
        if (no != null){
            percorrerEmOrdem(no.filhoEsquerdo);
            System.out.print(no.conteudo + " ");
            percorrerEmOrdem(no.filhoDireito);
        }
    }

    public void percorrerPosOrdem(No no){
        if (no != null){
            percorrerPosOrdem(no.filhoEsquerdo);
            percorrerPosOrdem(no.filhoDireito);
            System.out.print(no.conteudo + " ");
        }
    }

}
