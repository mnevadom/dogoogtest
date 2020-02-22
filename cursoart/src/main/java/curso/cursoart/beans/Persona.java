package curso.cursoart.beans;

import javax.annotation.Resource;

public class Persona {
	private String id, name, lastname;
	
	@Resource
	private Pais origen;
	
	public Persona(String id, String name, String lastname) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Pais getOrigen() {
		return origen;
	}

	public void setOrigen(Pais origen) {
		this.origen = origen;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", name=" + name + ", lastname=" + lastname + ", origen=" + origen + "]";
	}

}
