package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Propietario;

public interface IPropietarioRepository {
	public Propietario seleccionar(Integer id);
	public void insetar (Propietario propietario);
	public void actualizar (Propietario propietario);
	public void elimnar (Integer id);
}
