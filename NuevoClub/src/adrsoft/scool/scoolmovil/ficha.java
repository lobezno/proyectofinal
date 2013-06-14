package adrsoft.scool.scoolmovil;

public class ficha {

	private String nombre;
	private String apellidos;
	private int rango;
	
	public ficha(String nombre, String apellidos, int rango) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.rango = rango;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public int getRango() {
		return rango;
	}

	public void setRango(int rango) {
		this.rango = rango;
	}
}
