/* Classe principal da árvore binária
 */
package ArvoreBinaria;

/**
 *
 * @author borges.esb
 */
public class Principal {
    public static void main(String[] args) {
    //Instancia a árvore:
    No node = new No();
    //insere os nós:
    System.out.println("Início das inserções!\n");
    node.inserir(10);//o primeiro será a raiz
    node.inserir(55);
    node.inserir(16);
    node.inserir(161);
    node.inserir(162);
    System.out.println("Fim das inserções!\n");
    
    System.out.println("**************************\n        IMPRESSÕES\n**************************");
    
    //Imprimindo em ordem:
    node.imprimeOrdem();
    
    //Imprimindo em pré-ordem:
    node.imprimePreOrdem();
    
    //Imprimindo em pós-ordem:
    node.imprimePosOrdem();
    
    //busca
    node.buscaNo(160);
    node.buscaNo(157);
    node.buscaNo(10);
    node.busca(160);
    }   
}
