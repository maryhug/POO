package bean;

public class BDiscoDuro {

	private String tipoDisco;
	private String interfaz;
	private int capacidad;

	public BDiscoDuro() {
		tipoDisco = "Magnetico";
		interfaz = "SATA";
		capacidad = 100;
	}

	public String getTipoDisco() {
		return tipoDisco;
	}

	public void setTipoDisco(String tipoDisco) {
		this.tipoDisco = tipoDisco;
	}

	public String getInterfaz() {
		return interfaz;
	}

	public void setInterfaz(String interfaz) {
		this.interfaz = interfaz;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	

}
