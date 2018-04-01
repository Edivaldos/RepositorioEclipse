package ArvoreBinariaDeBusca;

public class Principal {
	public static void main(String args[]){
		
		Elemento elem = new Elemento();
		
		No noArvore = new No();
		System.out.println("------------------------>> INÍCIO DAS INSERÇÕES <<------------------------\n");
		noArvore.inserir(new Elemento(10));
		noArvore.inserir(new Elemento(14));
		noArvore.inserir(new Elemento(8));
		noArvore.inserir(new Elemento(15));
		noArvore.inserir(new Elemento(12));
		noArvore.inserir(new Elemento(18));
		noArvore.inserir(new Elemento(20));
		noArvore.inserir(new Elemento(28));
		noArvore.inserir(new Elemento(3));
		noArvore.inserir(new Elemento(19));
		noArvore.inserir(new Elemento(13));
		noArvore.inserir(new Elemento(5));
		noArvore.inserir(new Elemento(7));
		noArvore.inserir(new Elemento(6));
		noArvore.inserir(new Elemento(1));
		System.out.println("------------------------>> Fim das inserções <<------------------------");
		
		System.out.println("\n------------------------>> Início das buscas - Antes de remover <<---------------------------");
		System.out.println("--> O elemento  15 " + (noArvore.busca(15) ? "existe na árvore." : "não existe na árvore."));
		System.out.println("--> O elemento  19 " + (noArvore.busca(19) ? "existe na árvore." : "não existe na árvore."));
		System.out.println("--> O elemento  25 " + (noArvore.busca(25) ? "existe na árvore." : "não existe na árvore."));
		System.out.println("--> O elemento  7 " + (noArvore.busca(7) ? "existe na árvore." : "não existe na árvore."));
		System.out.println("--> O elemento  38 " + (noArvore.busca(38) ? "existe na árvore." : "não existe na árvore."));
		System.out.println("--> O elemento  10 " + (noArvore.busca(10) ? "existe na árvore." : "não existe na árvore."));
		System.out.println("\n--------------------------->> Fim das buscas - Antes de remover <<---------------------------");
		
		System.out.println("\n-------------------------->> Início das Impressões <<---------------------------");
		System.out.print("\n** Impressão em Pré-Ordem:\n--> ");
		noArvore.imprimirPreOrdem();
		
		System.out.print("\n\n** Impressão Em Ordem:\n--> ");
		noArvore.imprimirEmOrdem();
		
		System.out.print("\n\n** Impressão em Pós-Ordem:\n--> ");
		noArvore.imprimirPosOrdem();
		
		System.out.print("\n\n** Impressão em Ordem Inversa:\n--> ");
		noArvore.imprimirEmOrdemInversa();
		
		System.out.println("\n--------------------------->> Fim das Impressões <<----------------------------");
		

		System.out.println("\n\n--------------------------->> INÍCIO DAS REMOÇÕES <<----------------------------");
		System.out.println("--> --> --> Removendo...");
		elem.setValor(20);
		noArvore = noArvore.remover(elem);
				
		//1º Caso - Removendo um nó folha:
		elem.setValor(1);
		noArvore = noArvore.remover(elem);
		
		//2º Caso - Removendo um nó que tem filho somente à esquerda:
		elem.setValor(7);
		noArvore = noArvore.remover(elem);
		
		//3º Caso - Removendo um nó que tem filho somente à direita:
		elem.setValor(12);
		noArvore = noArvore.remover(elem);
		
		//4º Caso (passando para o 2º) - Removendo um nó que tem filho à esquerda e filho à direita:
		elem.setValor(10);
		noArvore = noArvore.remover(elem);
		
		//4º Caso (passando para o 1º) - Removendo um nó que tem filho à esquerda e filho à direita:
		elem.setValor(14);
		noArvore = noArvore.remover(elem);
		
		//Caso Excepcional - Removendo um nó que não existe na árvore, mas, se existisse estaria à esquerda de seu antecessor.
		elem.setValor(16);
		noArvore = noArvore.remover(elem);
		
		//Caso Excepcional 2 - Removendo um nó que não existe na árvore, mas, se existisse estaria à direita de seu antecessor.
		elem.setValor(29);
		noArvore = noArvore.remover(elem);
		
		System.out.println("\n----------------------------->> FIM DAS REMOÇÕES <<----------------------------");
		
		System.out.println("\n----------------------------->> Início das impressões - PÓS REMOÇÕES <<-----------------------------");
		System.out.print("\n** Impressão em Pré-Ordem:\n--> ");
		noArvore.imprimirPreOrdem();
		
		System.out.print("\n\n** Impressão Em Ordem:\n--> ");
		noArvore.imprimirEmOrdem();
		
		System.out.print("\n\n** Impressão em Pós-Ordem:\n--> ");
		noArvore.imprimirPosOrdem();
		
		System.out.print("\n\n** Impressão em Ordem Inversa:\n--> ");
		noArvore.imprimirEmOrdemInversa();
		
		System.out.println("\n\n--------------------------->> Fim das Impressões - PÓS REMOÇÕES <<----------------------------\n");
		
		System.out.println("*** Teste de Busca na árvore após remoções ***");
		System.out.println("--> O elemento  20 (removido!), " + (noArvore.busca(20) ? "existe na árvore." : "não existe na árvore."));
		System.out.println("--> O elemento  1 (removido!), " + (noArvore.busca(1) ? "existe na árvore." : "não existe na árvore."));
		System.out.println("--> O elemento  7 (removido!), " + (noArvore.busca(7) ? "existe na árvore." : "não existe na árvore."));
		System.out.println("--> O elemento  12 (removido!), " + (noArvore.busca(12) ? "existe na árvore." : "não existe na árvore."));
		System.out.println("--> O elemento  10 (removido!), " + (noArvore.busca(10) ? "existe na árvore." : "não existe na árvore."));
		System.out.println("--> O elemento  14 (removido!), " + (noArvore.busca(14) ? "existe na árvore." : "não existe na árvore."));
		System.out.println("--> O elemento  28 (não removido) " + (noArvore.busca(28) ? "existe na árvore." : "não existe na árvore."));
		System.out.println("--> O elemento  29 (procurado!), " + (noArvore.busca(29) ? "existe na árvore." : "não existe na árvore."));
		System.out.println("\n---------------------------->> Fim do Programa! <<----------------------------");
	}
}
