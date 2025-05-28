import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public void percorrerEmNivel(){
        if (raiz == null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while(!fila.isEmpty()){
            No atual = fila.poll();
            System.out.print(atual.conteudo + " ");

            if (atual.filhoEsquerdo != null) fila.add(atual.filhoEsquerdo);
            if (atual.filhoDireito != null) fila.add(atual.filhoDireito);
        }
    }

    public void percorrerPreOrdemSemRecursividade(){
        if (raiz == null) return;

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        while (!pilha.isEmpty()){
            No atual = pilha.pop();
            System.out.print(atual.conteudo + " ");

            if (atual.filhoDireito != null) pilha.push(atual.filhoDireito);
            if (atual.filhoEsquerdo != null) pilha.push(atual.filhoEsquerdo);
        }
    }

    public void percorrerEmOrdemSemRecursividade(){
        if (raiz == null) return;

        Stack<No> pilha = new Stack<>();
        No atual = raiz;

        while (atual != null || !pilha.isEmpty()){
            while (atual != null){
            pilha.push(atual);
            atual = atual.filhoEsquerdo;
            }
            atual = pilha.pop();
            System.out.print(atual.conteudo + " ");
            atual = atual.filhoDireito;
        }
    }

    public void percorrerPosOrdemSemRecursividade(){
        if (raiz == null) return;

        Stack<No> pilha = new Stack<>();
        No atual = raiz;
        No ultimoVisitado = null;

        while (atual != null || !pilha.isEmpty()){
            while (atual != null){
                pilha.push(atual);
                atual = atual.filhoEsquerdo;
            }

            No topo = pilha.peek();

            if (topo.filhoDireito != null && ultimoVisitado != topo.filhoDireito) {
                atual = topo.filhoDireito;
            } else {
                pilha.pop();
                System.out.print(topo.conteudo + " ");
                ultimoVisitado = topo;
            }
        }

    }

    public int contarNosFolha(No no){
        if (no == null) return 0;
        if (no.filhoEsquerdo == null && no.filhoDireito == null) return 1;
        return contarNosFolha(no.filhoEsquerdo) + contarNosFolha(no.filhoDireito);
    }

    public int contarNosFolhaSemRecursividade(){
        int cont = 0;
        if (raiz == null) return cont;

        Stack<No> pilha = new Stack<>();
        pilha.push(raiz);

        while (!pilha.isEmpty()){
            No atual = pilha.pop();
            if (atual.filhoDireito == null && atual.filhoEsquerdo == null) {
                cont++;
            } else {
                if (atual.filhoDireito != null) pilha.push(atual.filhoDireito);
                if (atual.filhoEsquerdo != null) pilha.push(atual.filhoEsquerdo);
            }
        }
        return cont;
    }
    
}
