package bean;

public class BChasis {
	
	private int largoPlaca;
	private int anchoPlaca;
	private int ranuras;
	private boolean adminCables;
	private int ancho;
	private int alto;
	private int profundidad;
	
	public BChasis() {
		largoPlaca = 0;
		anchoPlaca = 0;
		ranuras = 0;
		adminCables = true;
		ancho = 0;
		alto = 0;
		profundidad = 0;
	}

	public int getLargoPlaca() {
		return largoPlaca;
	}

	public void setLargoPlaca(int largoPlaca) {
		this.largoPlaca = largoPlaca;
	}

	public int getAnchoPlaca() {
		return anchoPlaca;
	}

	public void setAnchoPlaca(int anchoPlaca) {
		this.anchoPlaca = anchoPlaca;
	}

	public int getRanuras() {
		return ranuras;
	}

	public void setRanuras(int ranuras) {
		this.ranuras = ranuras;
	}

	public boolean isAdminCables() {
		return adminCables;
	}

	public void setAdminCables(boolean adminCables) {
		this.adminCables = adminCables;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}

}
