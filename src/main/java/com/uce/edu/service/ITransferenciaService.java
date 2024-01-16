package com.uce.edu.service;

import java.math.BigDecimal;

import com.uce.edu.repository.modelo.Transferencia;

public interface ITransferenciaService {
	public void guardar (Transferencia transferencia);
	public void realizarTransferencia(String numOrigen, String numDestino, BigDecimal monto);

}
