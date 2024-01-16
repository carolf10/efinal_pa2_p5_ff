package com.uce.edu.repository;

import com.uce.edu.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {
	public CuentaBancaria seleccionar(Integer id);
	public void insetar (CuentaBancaria bancaria);
	public void actualizar (CuentaBancaria bancaria);
	public void eliminar (Integer id);
	public CuentaBancaria seleccionarPorNumero(String numero);
}
