package com.biblioteca.entidad;

public class Libro {
	private int codigo,cantidad,codigoEditorial;
	private String titulo;
	private double precio;
	//atributo para select
	private int codEdi;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCodigoEditorial() {
		return codigoEditorial;
	}
	public void setCodigoEditorial(int codigoEditorial) {
		this.codigoEditorial = codigoEditorial;
	}
	public int getCodEdi() {
		return codEdi;
	}
	public void setCodEdi(int codEdi) {
		this.codEdi = codEdi;
	}
	
	
	
}
