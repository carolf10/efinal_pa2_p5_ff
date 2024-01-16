package com.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CuentaBancaria seleccionar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CuentaBancaria.class, id);
	}

	@Override
	public void insetar(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.entityManager.persist(bancaria);
	}

	@Override
	public void actualizar(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(bancaria);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		CuentaBancaria bancaria= this.seleccionar(id);
		this.entityManager.remove(bancaria);
	}

	@Override
	public CuentaBancaria seleccionarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<CuentaBancaria> query=this.entityManager.createQuery(
				"SELECT cb FROM CuentaBancaria cb WHERE cb.numero = :numero", CuentaBancaria.class);
		query.setParameter("numero", numero);
		return query.getSingleResult();
	}

}
