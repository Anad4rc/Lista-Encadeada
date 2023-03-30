package ListaEncadeada;

public class Node {

	//atributos
	  private int content;
	  private Node next;

	  //objeto aponta para null
	  public Node(){
	    this.next = null;
	  }
	  
	 //metodos getters and setters

	  //armazena/pega valor contido no no
	public int getContent() {
		return content;
	}

	  //atribui conteudo ao no
	public void setContent(int content) {
		this.content = content;
	}

	  //Ponta para o proximo no
	public Node getNext() {
		return next;
	}

	  //escoolhe para qual nó apontar
	public void setNext(Node next) {
		this.next = next;
	}
	
}
