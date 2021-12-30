package dominio;

public class Documento extends Entrega  {
	private int grosor;
	
	public Documento(int codigo, String rut_remitente, String rut_destino, int peso, int grosor) {
		super(codigo, rut_remitente, rut_destino, peso);
		this.grosor = grosor;		
	}

	public int getGrosor() {
		return grosor;
	}

	public void setGrosor(int grosor) {
		this.grosor = grosor;
	}

}
