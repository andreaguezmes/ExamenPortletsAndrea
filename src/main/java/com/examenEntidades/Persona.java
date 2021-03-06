package com.examenEntidades;

import java.io.Serializable;

public class Persona implements  Serializable {
	
	private String nombre;
	private String direccion;
	private int telefono;
	
	
	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Persona(String nombre, String direccion, int telefono) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}
	
	

}
