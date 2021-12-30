package dominio;

public class Cliente {
	private String rut;
	private String nombre_completo;
	private int saldo;
	private String localizacion;
	
	public Cliente(String rut, String nombre_completo, int saldo, String localizacion) {
		super();
		this.rut = rut;
		this.nombre_completo = nombre_completo;
		this.saldo = saldo;
		this.localizacion = localizacion;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	

	

	
}
