package ListaEncadeada;

public interface InterfaceListaEncadeada {
	public boolean empty();
	public int size();
	public int element(int pos);
	public int position(int data);
	public boolean insert(int pos,int data);
	public int remove(int pos);
	
}
