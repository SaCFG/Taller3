package logica;

import dominio.Encomienda;

public class NodoEncomienda {
	private Encomienda encomienda; 
	private NodoEncomienda next; 
	private NodoEncomienda previo; 
	
	
	public NodoEncomienda(Encomienda e) { 
		this.encomienda = e;
		next = null;
		previo = null;
	}
	
	public Encomienda getDato() {
		return encomienda;
	}
	
	public NodoEncomienda getNext() {
		return next;
	}
	
	public NodoEncomienda getPrevio() {
		return previo;
	}
	
	public void setNext(NodoEncomienda nodo) {
		next = nodo;
	}
	
	public void setPrevio(NodoEncomienda nodo) {
		previo = nodo;
	}
	
}
