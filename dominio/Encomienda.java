package dominio;

public class Encomienda extends Entrega  {	
	private int largo;
	private int ancho;
	private int profundidad;
	public Encomienda(int codigo, String rut_remitente, String rut_destino, int peso, int largo, int ancho,
			int profundidad) {
		super(codigo, rut_remitente, rut_destino, peso);
		this.largo = largo;
		this.ancho = ancho;
		this.profundidad = profundidad;
	}
	
	public int getLargo() {
		return largo;
	}
	public void setLargo(int largo) {
		this.largo = largo;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getProfundidad() {
		return profundidad;
	}
	public void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}
	
	
}
