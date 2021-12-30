package logica;

import dominio.Documento;

public class ListaDobleDocumentos {
	
	private NodoDocumento first;
	private NodoDocumento last; 
	
	public ListaDobleDocumentos(){
		last = null; 
	} 
	
	public boolean isEmpty(){ //Checks if the list is empty
		return first==null;
	}
	
	public void insertarPrimer(Documento d) { //insert the node on "first row"
		NodoDocumento nuevoNodoDocumento = new NodoDocumento(d);
		
		if( isEmpty() ){
			last = nuevoNodoDocumento;
		}
	
		else{
			first.setPrevio(nuevoNodoDocumento);
		}
	
		nuevoNodoDocumento.setNext(first);
		first = nuevoNodoDocumento;
	}
	
	public void insertarUltimo(Documento d) { //insert the node on "last row"
		NodoDocumento nuevoNodoDocumento = new NodoDocumento(d);
		
		if( isEmpty() ) {
			first = nuevoNodoDocumento;
		}
		
		else {
			last.setNext(nuevoNodoDocumento);
			nuevoNodoDocumento.setPrevio(last);
		} 
		
		last = nuevoNodoDocumento;
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
		
		
	public boolean insertarDespues (int codigo, Documento d) { // insert the node after the node with the code		
		NodoDocumento current = first;
		
		while(current != null && current.getDato().getCodigo() != codigo){
			current = current.getNext();
		}
		
		if (current != null) {
			NodoDocumento nuevoNodoDocumento = new NodoDocumento(d);
			
			if(current == last) { 
				nuevoNodoDocumento.setNext(null);
				last = nuevoNodoDocumento; 
			}
			
			else {
				nuevoNodoDocumento.setNext(current.getNext());
				current.getNext().setPrevio(nuevoNodoDocumento);
			}
		
			nuevoNodoDocumento.setPrevio(current);
			current.setNext(nuevoNodoDocumento);
		
			return true;
		}
		
		else {
			return false;
		}
		
	}
	
	public boolean eliminarClave(int codigo) { //delete the node with the right code
			
		NodoDocumento current = first; 
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
		
	public NodoDocumento getFirst() {
		return first;
		}
	
	
	@Override
	public String toString(){ 				//Req 6 implement of toString
		String salida = "";
		NodoDocumento actual = first;
		
		while(actual != null) {
			Documento fechaP= actual.getDato();
			salida = salida + "Codigo: " +
			fechaP.getCodigo()+", Cant: "+ "\n";
			actual = actual.getNext();
			}
		
		return salida;
		}
	
	public Documento getDocumento(int code){
		NodoDocumento actual = this.first;
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
	
	public int getCantidadDocumento(){
		NodoDocumento actual = this.first;
		int cantidad = 0;
		
		while(actual != null){
			cantidad++;
			actual = actual.getNext();
			}
		
		return cantidad;
	}
}
