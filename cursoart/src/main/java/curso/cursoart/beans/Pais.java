package curso.cursoart.beans;

import java.util.List;

import javax.annotation.Resource;

public class Pais {
	
	private String nombre;
	
	@Resource
	private List<Ciudad> ciudades;
	
	public Pais(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + ", ciudades=" + ciudades + "]";
	}
}
