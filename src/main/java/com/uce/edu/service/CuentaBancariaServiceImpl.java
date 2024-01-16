package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ICuentaBancariaRepository;
import com.uce.edu.repository.modelo.CuentaBancaria;
@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;

	@Override
	public CuentaBancaria buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionar(id);
	}

	@Override
	public void guardar(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.insetar(bancaria);
	}

	@Override
	public void actualizar(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepository.actualizar(bancaria);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.bancariaRepository.eliminar(id);
	}

	@Override
	public CuentaBancaria buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionarPorNumero(numero);
	}

}
