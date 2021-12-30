package dominio;

public class Entrega {
	private int codigo;
	private String rut_remitente;
	private String rut_destino;
	private int peso;
	
	public Entrega(int codigo, String rut_remitente, String rut_destino, int peso) {
		this.codigo = codigo;
		this.rut_remitente = rut_remitente;
		this.rut_destino = rut_destino;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getRut_remitente() {
		return rut_remitente;
	}

	public void setRut_remitente(String rut_remitente) {
		this.rut_remitente = rut_remitente;
	}

	public String getRut_destino() {
		return rut_destino;
	}

	public void setRut_destino(String rut_destino) {
		this.rut_destino = rut_destino;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	
}
