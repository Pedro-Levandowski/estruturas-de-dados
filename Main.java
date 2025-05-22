public class Main {
    public static void main(String[] args) {

        No noA = new No("A");
        No noB = new No("B");
        No noC = new No("C");
        No noD = new No("D");
        No noE = new No("E");
        No noF = new No("F");

        noA.filhoEsquerdo = noB;
        noA.filhoDireito = noC;
        noB.filhoEsquerdo = noD;
        noB.filhoDireito = noE;
        noC.filhoDireito = noF;

        Arvore arvore1 = new Arvore(noA);

        System.out.println("Contagem de nós: " + arvore1.contarNos(noA));

        System.out.println("=== Travessia Pré-Ordem ===");
        arvore1.percorrerPreOrdem(noA);
        System.out.println(" ");

        System.out.println("=== Travessia Pré-Ordem Sem Recursividade ===");
        arvore1.percorrerPreOrdemSemRecursividade();
        System.out.println(" ");

        System.out.println("=== Travessia Em-Ordem ===");
        arvore1.percorrerEmOrdem(noA);
        System.out.println(" ");

        System.out.println("=== Travessia Em-Ordem Sem Recursividade ===");
        arvore1.percorrerEmOrdemSemRecursividade();
        System.out.println(" ");

        System.out.println("=== Travessia Pós-Ordem ===");
        arvore1.percorrerPosOrdem(noA);
        System.out.println(" ");

        System.out.println("=== Travessia Pós-Ordem Sem Recursividade ===");
        arvore1.percorrerPosOrdemSemRecursividade();
        System.out.println(" ");

        System.out.println("=== Travessia Em Nível ===");
        arvore1.percorrerEmNivel();
        System.out.println(" ");


    }
}
