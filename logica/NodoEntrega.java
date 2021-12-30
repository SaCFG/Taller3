package logica;

import dominio.Entrega;

public class NodoEntrega {
	private Entrega entrega; 
	private NodoEntrega next; 
	private NodoEntrega previo; 
	
	
	public NodoEntrega(Entrega e) { 
		this.entrega = e;
		next = null;
		previo = null;
	}
	
	public Entrega getDato() {
		return entrega;
	}
	
	public NodoEntrega getNext() {
		return next;
	}
	
	public NodoEntrega getPrevio() {
		return previo;
	}
	
	public void setNext(NodoEntrega nodo) {
		next = nodo;
	}
	
	public void setPrevio(NodoEntrega nodo) {
		previo = nodo;
	}
	
}
