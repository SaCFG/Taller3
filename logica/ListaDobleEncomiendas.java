package logica;

import dominio.Encomienda;

public class ListaDobleEncomiendas {
	
	private NodoEncomienda first;
	private NodoEncomienda last; 
	
	public ListaDobleEncomiendas(){
		last = null; 
	} 
	
	public boolean isEmpty(){ //Checks if the list is empty
		return first==null;
	}
	
	public void insertarPrimer(Encomienda e) { //insert the node on "first row"
		NodoEncomienda nuevoNodoEncomienda = new NodoEncomienda(e);
		
		if( isEmpty() ){
			last = nuevoNodoEncomienda;
		}
	
		else{
			first.setPrevio(nuevoNodoEncomienda);
		}
	
		nuevoNodoEncomienda.setNext(first);
		first = nuevoNodoEncomienda;
	}
	
	public void insertarUltimo(Encomienda e) { //insert the node on "last row"
		NodoEncomienda nuevoNodoEncomienda = new NodoEncomienda(e);
		
		if( isEmpty() ) {
			first = nuevoNodoEncomienda;
		}
		
		else {
			last.setNext(nuevoNodoEncomienda);
			nuevoNodoEncomienda.setPrevio(last);
		} 
		
		last = nuevoNodoEncomienda;
	}

	public boolean eliminarPrimer(){ //Delete first node 		
		if (!this.isEmpty()) {
			
			if(first.getNext() == null) { //Only has one element
				last = null; 
			}
			
			else{
				first.getNext().setPrevio(null);
			}
			
			first = first.getNext();
			return true;
		}
		
		else{
			return false;
		}
	}
	
	public boolean eliminarUltimo (){ //delete last node		
		if (!this.isEmpty()) { 
			
			if(first.getNext() == null) { //Only has one element		 
				first = null; 
			}
		
			else{
				last.getPrevio().setNext(null);
			}
		
			last= last.getPrevio();
			return true; 
		}
		
		else {
			return false;
		}
	}
		
		
	public boolean insertarDespues (int codigo, Encomienda e) { // insert the node after the node with the code		
		NodoEncomienda current = first;
		
		while(current != null && current.getDato().getCodigo() != codigo){
			current = current.getNext();
		}
		
		if (current != null) {
			NodoEncomienda nuevoNodoEncomienda = new NodoEncomienda(e);
			
			if(current == last) { 
				nuevoNodoEncomienda.setNext(null);
				last = nuevoNodoEncomienda; 
			}
			
			else {
				nuevoNodoEncomienda.setNext(current.getNext());
				current.getNext().setPrevio(nuevoNodoEncomienda);
			}
		
			nuevoNodoEncomienda.setPrevio(current);
			current.setNext(nuevoNodoEncomienda);
		
			return true;
		}
		
		else {
			return false;
		}
		
	}
	
	public boolean eliminarClave(int codigo) { //delete the node with the right code
			
		NodoEncomienda current = first; 
		while(current != null && current.getDato().getCodigo() != codigo){
			current = current.getNext();
			}
		
		if (current == null) { //Not found
			return false;
			}
			
		if(current==first) {
			first = current.getNext();
			}
		
		else {
			current.getPrevio().setNext(current.getNext());
			}
		
		if(current==last) {
			last = current.getPrevio();
			}
			
		else {
		current.getNext().setPrevio(current.getPrevio());
		}
		
		return true;
	}
		
	public NodoEncomienda getFirst() {
		return first;
		}
	
	
	@Override
	public String toString(){ 				//Req 6 implement of toString
		String salida = "";
		NodoEncomienda actual = first;
		
		while(actual != null) {
			Encomienda fechaP= actual.getDato();
			salida = salida + "Codigo: " +
			fechaP.getCodigo()+", Cant: "+ "\n";
			actual = actual.getNext();
			}
		
		return salida;
		}
	
	public Encomienda getEncomienda(int code){
		NodoEncomienda actual = this.first;
		int codigo = actual.getDato().getCodigo();

		while(actual != null || codigo != code){
			actual = actual.getNext();
			}
		
		if(actual != null) {    //Recordatorio: El aviso es de not used 
			return actual.getDato();
		}
		
		else{
			return null;
		}
		
		}
	
	public int getCantidadEncomienda(){
		NodoEncomienda actual = this.first;
		int cantidad = 0;
		
		while(actual != null){
			cantidad++;
			actual = actual.getNext();
			}
		
		return cantidad;
	}
}
