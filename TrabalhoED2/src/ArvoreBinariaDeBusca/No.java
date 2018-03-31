package ArvoreBinariaDeBusca;

public class No {
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
}
