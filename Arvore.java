public class Arvore {
   No raiz;

   Arvore(){
       No noA = new No("A");
       No noB = new No("B");
       No noC = new No("C");
       No noD = new No("D");
       No noE = new No("E");
       No noF = new No("F");

       No raiz = noA;

       noA.filhoEsquerdo = noB;
       noA.filhoDireito = noC;
       noB.filhoEsquerdo = noD;
       noB.filhoDireito = noE;
       noC.filhoDireito = noF;
   }


}
