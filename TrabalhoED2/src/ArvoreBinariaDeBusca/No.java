package ArvoreBinariaDeBusca;

public class No {
	//Atributos da árvore
	private Elemento ele;
	private No noDireito;
	private No noEsquerdo;
	
	//----------------------------------------------------------------------------	
	//Gets e sets
	public Elemento getEle() {
		return this.ele;
	}

	public void setEle(Elemento ele) {
		this.ele = ele;
	}

	public No getNoDireito() {
		return this.noDireito;
	}

	public void setNoDireito(No noDireito) {
		this.noDireito = noDireito;
	}

	public No getNoEsquerdo() {
		return this.noEsquerdo;
	}

	public void setNoEsquerdo(No noEsquerdo) {
		this.noEsquerdo = noEsquerdo;
	}	
	//----------------------------------------------------------------------------
	
	//Posso iniciar a árvore usando um dos dois construtores a seguir (sobrecarga de construtores)
	//Construtor da árvore - padrão
	public No(){
		this.ele = null;
		this.noEsquerdo = null;
		this.noDireito = null;
	}
	
	//Contrutor da árvore - passando um parâmetro
	public No(Elemento elem){
		this.ele = elem;
		this.noDireito = null;
		this.noEsquerdo = null;
		System.out.println("Tentando inserir um novo nó com o elemento " + elem.getValor());
	}
	
	//Métodos de controle:
	//Verificando se árvore está vazia:
	public boolean isEmpty(){
		return this.ele == null;
	}
	
	//----------------------------------------------------------------------------
	//Inserção dos elementos
	public void inserir(Elemento novo){
		//verifica se a ávore é vazia
		if(isEmpty()){//se a árvore estiver vazia, insere o elemento.
			System.out.println("A árvore está vazia; então inseri o elemento " + novo.getValor() + ". Este será o elemento raiz da árvore.\n");
			this.ele = novo;
		}
		else{//a árvore não está vazia
			//chamamos o construtor com parâmetro para criar o novo nó
			No novoNo = new No(novo);
			if(novo.getValor() < this.ele.getValor()){//vou inserir na descendência esquerda
				if(this.noEsquerdo == null){//sou um nó folha
					this.noEsquerdo = novoNo;
					System.out.println("O elemento " + novo.getValor() + " foi inserido à esquerda do " + this.ele.getValor()+"\n");
					
				}
				else{//e se eu já tenho elemento à esquerda?
					//repasso a responsabilidade de inserção para esse elemento
					this.noEsquerdo.inserir(novo);
				}
			}
			else if(novo.getValor() > this.ele.getValor()){//vou inserir na descendência direita
				if(this.noDireito == null){//se a direita estiver vazia, insiro o nó
					this.noDireito = novoNo;
					System.out.println("O elemento " + novo.getValor() + " foi inserido à direita do " + this.ele.getValor()+"\n");
				}
				else{//e se eu já tenho elemento à direita?
					//repasso a responsabilidade de inserção para esse elemento
					this.noDireito.inserir(novo);
				}				
			}
		}
	}	
	//----------------------------------------------------------------------------
	
	//Busca elemento na árvore
	public boolean busca(int valor){
		if(isEmpty()){
			return false;
		}
		if(this.ele.getValor() == valor){
			return true;
		}
		else{
			if(valor < this.ele.getValor()){
				if(this.noEsquerdo == null){
					return false;
				}
				else{
					//Chama a busca passando o nó esquerdo.
					return this.noEsquerdo.busca(valor);
				}
			}
			else if(valor > this.ele.getValor()){
				if(this.noDireito == null){
					return false;
				}
				else{
					return this.noDireito.busca(valor);
				}
			}
			return false;
		}
	}
	//----------------------------------------------------------------------------
	
	//Percursos na árvore
	//Percorrendo a árvore em Pré-ordem - (Imprime a raiz; depois toda descedência esquerda, começando pela raiz; depois toda a descedência direita, sempre começando pela raiz)
	public void imprimirPreOrdem(){
		if(!isEmpty()){
			System.out.print(this.ele.getValor() + " - ");
			if(this.noEsquerdo != null){
				this.noEsquerdo.imprimirPreOrdem();
			}
			if(this.noDireito != null){
				this.noDireito.imprimirPreOrdem();
			}
		}
	}
	//----------------------------------------------------------------------------
	
	//Percorrendo a árvore Em ordem - (Imprime todos os elementos da esquerda; depois todo mundo da raiz; depois todo mundo da direita)
	public void imprimirEmOrdem(){
		if(!isEmpty()){
			if(this.noEsquerdo != null){
				this.noEsquerdo.imprimirEmOrdem();
			}
			System.out.print(this.ele.getValor() + " - ");
			if(this.noDireito != null){
				this.noDireito.imprimirEmOrdem();
			}
		}
	}
	//----------------------------------------------------------------------------
	
	//Percorrendo a árvore Pós-ordem - (Imprime todos os elementos da direita; depois todo mundo à esquerda e depois a raiz.)
	public void imprimirPosOrdem(){
		if(!isEmpty()){
			if(this.noDireito != null){
				this.noDireito.imprimirPosOrdem();
			}
			if(this.noEsquerdo != null){
				this.noEsquerdo.imprimirPosOrdem();
			}
			System.out.print(this.ele.getValor() + " - ");
		}
	}
	//----------------------------------------------------------------------------
	
	//Percorrendo a árvore em Ordem Inversa - (Imprime todos os elementos da direita; depois a raiz; depois todo mundo da esquerda)
	public void imprimirEmOrdemInversa(){
		if(!isEmpty()){
			if(this.noDireito != null){
				this.noDireito.imprimirEmOrdem();
			}
			System.out.print(this.ele.getValor() + " - ");
				if(this.noEsquerdo != null){
				this.noEsquerdo.imprimirEmOrdem();
			}
		}
	}
	//----------------------------------------------------------------------------
	
	//No JAVA não tem remoção explícita de objetos. Isso é 'feito' pelo Garbarge Collector.
	//Por isso nossa remoção acontece com a 'reconstrução' da árvore, sem o elemento removido.
	//Remoções de nós da árvore
	public No remover(Elemento elem){
		//Para iniciar o processo de remoção, verificamos se o nó atual é igual ao elemento a ser removido; começamos desde a raiz da árvore:
		if(this.ele.getValor() == elem.getValor()){
			//1º CASO - O elemento não tem filhos, nem à direita, nem à esquerda, ou seja, é um nó folha. Caso mais simples.
			//verificação
			if(this.noDireito == null && this.noEsquerdo == null){
				System.out.println("1º CASO DE REMOÇÃO...");
				System.out.println("------------------------> Elemento " + elem.getValor() + " removido!");
				return null;//porque o nó é folha.
			}
			else{
				//2º Caso - O nó a ser removido tem filho à esquerda e não tem filho à direita. Caso menos complexo.
				if(this.noEsquerdo != null && this.noDireito == null){//verificação
					System.out.println("2º CASO DE REMOÇÃO...");
					System.out.println("------------------------> Elemento " + elem.getValor() + " removido!");
				return this.noEsquerdo;//Retorno a sub-arvore da esquerda; porque à direita não tem elemento. Religação
				}
				//3º Caso - O nó a ser removido tem filho à direita e não tem filho à esquerda. Caso menos complexo.
				else if(this.noDireito != null && this.noEsquerdo == null){//verificação
					System.out.println("3º CASO DE REMOÇÃO...");
					System.out.println("------------------------> Elemento " + elem.getValor() + " removido!");
				return this.noDireito;//Retorno a sub-arvore da direita; porque à esquerda não tem elemento.	
				}
				//4º Caso - O nó a ser removido tem filhos dos dois lados (esquerdo e direito). Caso complexo.
				else{//Adotando a estratégia de pegar o MAIOR dentre os Menores elementos da árvore:
					No substituto = this.noEsquerdo;
					while(substituto.noDireito != null){//enquanto houver descendência à direita...
						substituto = substituto.noDireito;
					}
					//efetuando a troca dos elementos da árvore...
					this.ele = substituto.getEle();//o nó atual recebe o elemento do substituto (o MAIOR dentre so Menores)
					substituto.setEle(elem);	//Insiro no nó folha o elemento a ser removido...
					//...Então faço a remoção:
					System.out.println("4º CASO DE REMOÇÃO...");
					System.out.println("--> Efetuando a mudança do 4º caso para o 1º ou para o 2º caso...");
					this.noEsquerdo = noEsquerdo.remover(elem);//Mudança do 4º caso para o 1º ou para o 2º caso.
				}
			}
		}
		else if(elem.getValor() < this.ele.getValor()){
			//Se o elemento a ser removido for menor que o elemento atual, então chamo o remover passando a sub-arvore da esquerda:
			//Refaz a ligação da aresta
			this.noEsquerdo = this.noEsquerdo.remover(elem);//remove o elemento e remonta a sub-arvore.
		}
		else if(elem.getValor() > this.ele.getValor()){//Se o elemento a ser removido for menor que o elemento atual;
			//Então chamo o remover passando a sub-arvore da direita:
			//Refaz a ligação da aresta
			this.noDireito = this.noDireito.remover(elem);//remove o elemento e remonta a sub-arvore.
		}
		return this;
	}
	//----------------------------------------------------------------------------
}

/*OBSERVAÇÕES PARA REMOÇÃO NO 4º CASO.
 *** Definindo a Estratégia ***
--> Quando eu tenho um elemento a ser removido e este tem descendentes em ambos os lados, tenho que definir uma estratégia. Mantendo a regra da árvore.
--> Então posso tomar uma das seguintes decisões: 
--> Posso pegar o MAIOR elemento dentre os Menores e trocar de posição com o elemento a ser removido.
--> Ou eu posso pegar o MENOR elemento dentre os Maiores e trocar de posição com o elemento a ser removido.
--> Então efetuo a remoção usando um dos três primeiros casos, dependendo da estratégia escolhida.*/