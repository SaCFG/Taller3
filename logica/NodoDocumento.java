package logica;

import dominio.Documento;

public class NodoDocumento {
	private Documento documento; 
	private NodoDocumento next; 
	private NodoDocumento previo; 
	
	
	public NodoDocumento(Documento d) { 
		this.documento = d;
		next = null;
		previo = null;
	}
	
	public Documento getDato() {
		return documento;
	}
	
	public NodoDocumento getNext() {
		return next;
	}
	
	public NodoDocumento getPrevio() {
		return previo;
	}
	
	public void setNext(NodoDocumento nodo) {
		next = nodo;
	}
	
	public void setPrevio(NodoDocumento nodo) {
		previo = nodo;
	}
	
}
