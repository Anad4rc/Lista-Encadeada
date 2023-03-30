package ListaEncadeada;

public class ListaEncadeada extends Node implements InterfaceListaEncadeada {

	//atributos
	  private Node head;
	  private int size;

	//cabe;a da lista aponta para null e o seu tamanho e 0
	  
	  public ListaEncadeada(){
	    head = null;
	    size = 0;
	  }

	  //verificar se a lista esta vazia
	  
	  @Override
	  public boolean empty(){
	    if(this.size == 0){
	      return true;
	    } else{
	      return false;
	    }
	  }

	  //tamanho da lista
	  @Override
	  public int size(){
	    return this.size;
	  }


	  //obtem o e-nesimo elemento da lista e retorna o valor encontrado
	  
	  @Override
	  public int element(int pos){
	    Node aux = this.head;
	    int count = 1;
	    
	    if(empty()) {return -1;} //retorn -1 caso falhe

	    if(pos < 1 || pos > this.size){return -1;} //retorna -1 caso a posicao seja invalida
	    

	    //Percorre a lista do primeiro elemento ate pos
	    while(count < pos){
	      aux = aux.getNext();
	      count++;
	    }
	    return aux.getContent();
	  }

	  //Retorna a posicao do elemento pesquisado, caso não seja encontrado retorna -1
	  
	  @Override
	  public int position(int data){
	    int count = 1;
	    Node aux;

	    if(empty()) return 0; 
	    aux = head;
	    
	    while(aux != null){
	    		if(aux.getContent() == data) return count;
	    		aux = aux.getNext();
	    		count++;
	      }
	    return -1;
	  } 

	  //Insere um elemento em determinada posição da lista, retorna true se conseguir inserir e false caso contrario
	  
	  @Override
	  public boolean insert(int pos,int data){
	    if(empty() && pos != 1) return false;
	    
	    if(pos == 1){
	    	return insertBeginList(data);//Insere elemento no inicio da lista              
	    }else if(pos == size){
		  
	    	return insertEndList(data);  //Insere elemento no final da lista
	  
	  }else{
		  	return insertMiddleList(pos,data);
		  } //Inserção de elemento no meio da lista
	  }
	


	  //Inserir nó no inicio da lista vazia
	private boolean insertBeginList(int value){
	  
	  Node newNode = new Node(); //alocação de memoria para um novo nó
	  
	 //Insere novo elemento na cabeça da lista
	  newNode.setContent(value);
	  newNode.setNext(head);
	  size++;
	  return true;
	} 


	  //Inserir nó no meio da lista
	  private boolean insertMiddleList(int pos, int data){
	    int count = 1;
	    //alocação de memória para novo nó
	    Node newNode = new Node();
	    newNode.setContent(data);

	    //localização da posição onde será inserido o novo nó
	    Node aux = this.head;
	    
	    while(count < pos-1 && aux != null){
	      aux = aux.getNext();
	      count++;
	    }

	    if(aux == null){return false;}

	    newNode.setNext(aux.getNext());
	    aux.setNext(newNode);
	    size++;
	    return true;
	  }

	//Inseção de nó no final da lista 

	  private boolean insertEndList(int data){
	    //alocação de memória para novo nó
	    Node newNode = new Node();
	    newNode.setContent(data);

	    //Procurar final da lista
	    Node aux = head;

	    while(aux.getNext() != null){
	      aux = aux.getNext();
	    }

	    newNode.setNext(null);
	    aux.setNext(newNode);
	    this.size++;
	    return true;
	  }

	  //Remove elemento do inicio da lista 

	private int removeBeginList(){
	   Node p = this.head;
	  int data = p.getContent();

	  //Retira o primeiro elemento da lista(p)
	  this.head = p.getNext();
	  this.size++;

	  //Sugere ao Garbage collector que libere a memoria da regiao apontada por p
	  p = null;
	  return data;
	}
	
	private int removeInList(int pos) {
		Node atual = null;
		Node antecessor = null;
		int data = -1;
		int count = 1;
		
		atual = this.head;
		
		while(count < pos && atual != null) {
			
			antecessor = atual;
			atual = atual.getNext();
			count++;
		}
		
		if(atual == null) return -1;
		
		data = atual.getContent();
		antecessor.setNext(atual.getNext());this.size++;
		
		atual = null;
		return data;
		
	}


	//Remover elemento de uma determinada posição da lista
	
	@Override
	  public int remove(int pos){
	    if(empty()){
	    	return -1;}//Lista vazia

	    //remove elemento da cabeça da lista
	    if(pos == 1){
	      return removeBeginList(); 
	    }else{ //remoção em outro lugar da lista
	      return removeInList(pos);
	    }
	  }

	  }

