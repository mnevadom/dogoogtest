package curso.cursoart.beans;

public class Ciudad {
	private String nombre;

	public Ciudad(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Ciudad [nombre=" + nombre + "]";
	}
	
}
