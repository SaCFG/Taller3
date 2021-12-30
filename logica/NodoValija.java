package logica;

import dominio.Valija;

public class NodoValija {
	private Valija valija; 
	private NodoValija next; 
	private NodoValija previo; 
	
	
	public NodoValija(Valija v) { 
		this.valija = v;
		next = null;
		previo = null;
	}
	
	public Valija getDato() {
		return valija;
	}
	
	public NodoValija getNext() {
		return next;
	}
	
	public NodoValija getPrevio() {
		return previo;
	}
	
	public void setNext(NodoValija nodo) {
		next = nodo;
	}
	
	public void setPrevio(NodoValija nodo) {
		previo = nodo;
	}
	
}
