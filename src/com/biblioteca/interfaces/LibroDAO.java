package com.biblioteca.interfaces;

import java.util.ArrayList;

import com.biblioteca.entidad.Libro;

public interface LibroDAO {
	public int save(Libro bean);
	public int update(Libro bean);
	public int deleteByID(int cod);
	public ArrayList<Libro> findAll();
}
