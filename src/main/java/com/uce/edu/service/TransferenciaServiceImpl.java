package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.ICuentaBancariaRepository;
import com.uce.edu.repository.ITransferenciaRepository;
import com.uce.edu.repository.modelo.CuentaBancaria;
import com.uce.edu.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {
	
	@Autowired
	private ITransferenciaRepository transferenciaRepository;
	@Autowired
	private ICuentaBancariaRepository iCuentaBancariaRepository;

	@Override
	public void guardar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.transferenciaRepository.insetar(transferencia);
	}

	@Override
	public void realizarTransferencia(String numOrigen, String numDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		CuentaBancaria cuentaOrigen = this.iCuentaBancariaRepository.seleccionarPorNumero(numOrigen);
		CuentaBancaria cuentaDestino = this.iCuentaBancariaRepository.seleccionarPorNumero(numDestino);
		
		BigDecimal saldoActual= null;
		
		if(cuentaOrigen.getSaldo().compareTo(new BigDecimal(0)) > 0) {
			monto = monto.multiply(new BigDecimal(0.1));
			saldoActual= cuentaOrigen.getSaldo().subtract(monto);
			saldoActual= cuentaDestino.getSaldo().add(saldoActual);
		} else {
			System.out.println("No se pudo realizar la transferencia");
		}
		
		Transferencia transferencia = new Transferencia();
		transferencia.setFecha(LocalDateTime.now());
		transferencia.setMonto(monto);
		transferencia.setCuentaDestino(cuentaDestino);
		transferencia.setCuentaOrigen(cuentaOrigen);
		
		this.guardar(transferencia);
		
	}

}
