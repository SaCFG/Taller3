package logica;

import dominio.Valija;

public class ListaDobleValijas {
	
	private NodoValija first;
	private NodoValija last; 
	
	public ListaDobleValijas(){
		last = null; 
	} 
	
	public boolean isEmpty(){ //Checks if the list is empty
		return first==null;
	}
	
	public void insertarPrimer(Valija v) { //insert the node on "first row"
		NodoValija nuevoNodoValija = new NodoValija(v);
		
		if( isEmpty() ){
			last = nuevoNodoValija;
		}
	
		else{
			first.setPrevio(nuevoNodoValija);
		}
	
		nuevoNodoValija.setNext(first);
		first = nuevoNodoValija;
	}
	
	public void insertarUltimo(Valija v) { //insert the node on "last row"
		NodoValija nuevoNodoValija = new NodoValija(v);
		
		if( isEmpty() ) {
			first = nuevoNodoValija;
		}
		
		else {
			last.setNext(nuevoNodoValija);
			nuevoNodoValija.setPrevio(last);
		} 
		
		last = nuevoNodoValija;
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
		
		
	public boolean insertarDespues (int codigo, Valija v) { // insert the node after the node with the code		
		NodoValija current = first;
		
		while(current != null && current.getDato().getCodigo() != codigo){
			current = current.getNext();
		}
		
		if (current != null) {
			NodoValija nuevoNodoValija = new NodoValija(v);
			
			if(current == last) { 
				nuevoNodoValija.setNext(null);
				last = nuevoNodoValija; 
			}
			
			else {
				nuevoNodoValija.setNext(current.getNext());
				current.getNext().setPrevio(nuevoNodoValija);
			}
		
			nuevoNodoValija.setPrevio(current);
			current.setNext(nuevoNodoValija);
		
			return true;
		}
		
		else {
			return false;
		}
		
	}
	
	public boolean eliminarClave(int codigo) { //delete the node with the right code
			
		NodoValija current = first; 
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
		
	public NodoValija getFirst() {
		return first;
		}
	
	
	@Override
	public String toString(){ 				//Req 6 implement of toString
		String salida = "";
		NodoValija actual = first;
		
		while(actual != null) {
			Valija fechaP= actual.getDato();
			salida = salida + "Codigo: " +
			fechaP.getCodigo()+", Cant: "+ "\n";
			actual = actual.getNext();
			}
		
		return salida;
		}
	
	public Valija getValija(int code){
		NodoValija actual = this.first;
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
	
	public int getCantidadValija(){
		NodoValija actual = this.first;
		int cantidad = 0;
		
		while(actual != null){
			cantidad++;
			actual = actual.getNext();
			}
		
		return cantidad;
	}
}
