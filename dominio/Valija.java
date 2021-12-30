package dominio;

public class Valija extends Entrega {	
	private String material;

	public Valija(int codigo, String rut_remitente, String rut_destino, int peso, String material) {
		super(codigo, rut_remitente, rut_destino, peso);
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
		
}
