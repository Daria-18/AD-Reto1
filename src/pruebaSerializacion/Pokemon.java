package pruebaSerializacion;

import java.io.Serializable;

public class Pokemon implements Serializable {
	private String nombre;
	private int numPokedex;
	private String tipoPrincipal;

	public Pokemon(String nombre, int numPokedex, String tipoPrincipal) {
		super();
		this.nombre = nombre;
		this.numPokedex = numPokedex;
		this.tipoPrincipal = tipoPrincipal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumPokedex() {
		return numPokedex;
	}

	public void setNumPokedex(int unidades) {
		this.numPokedex = unidades;
	}

	public String getTipoPrincipal() {
		return tipoPrincipal;
	}

	public void setTipoPrincipal(String nombre) {
		this.nombre = tipoPrincipal;
	}

	@Override
	public String toString() {
		return "Pokemon [nombre=" + nombre + ", numPokedex=" + numPokedex + ", tipoPrincipal=" + tipoPrincipal + "]";
	}

}
