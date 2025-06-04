public class MainAVL {
    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        arvore.inserir("10");
        arvore.inserir("5");
        arvore.inserir("15");
        arvore.inserir("3");
        arvore.inserir("7");
        arvore.inserir("12");
        arvore.inserir("18");

        System.out.print("Busca pré-ordem: ");
        arvore.buscaPreOrdem();
        System.out.println();

        arvore.excluir("5");

        System.out.print("Após exclusão: ");
        arvore.buscaPreOrdem();
        System.out.println();

        arvore.inserir("1");
        arvore.inserir("2");

        System.out.print("Após inserções: ");
        arvore.buscaPreOrdem();
        System.out.println();
    }
}

