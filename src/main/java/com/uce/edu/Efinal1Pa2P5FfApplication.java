package com.uce.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.CuentaBancaria;
import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.service.ICuentaBancariaService;
import com.uce.edu.service.IPropietarioService;
import com.uce.edu.service.ITransferenciaService;

@SpringBootApplication
public class Efinal1Pa2P5FfApplication implements CommandLineRunner{
	
	@Autowired
	private ITransferenciaService iTransferenciaService;
	@Autowired
	private ICuentaBancariaService bancariaService;

	public static void main(String[] args) {
		SpringApplication.run(Efinal1Pa2P5FfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Propietario propietario1 = new Propietario();
		propietario1.setApellido("Fiallos");
		propietario1.setCedula("7894");
		propietario1.setNombre("Fatima");
		
		Propietario propietario2 = new Propietario();
		propietario2.setApellido("Checa");
		propietario2.setCedula("5612");
		propietario2.setNombre("Carolina");
		
		CuentaBancaria c1 = new CuentaBancaria();
		c1.setNumero("1234");
		c1.setSaldo(new BigDecimal(300));
		c1.setTipo("Ahorros");
		c1.setPropietario(propietario1);
		
		CuentaBancaria c2 = new CuentaBancaria();
		c2.setNumero("5678");
		c2.setSaldo(new BigDecimal(250));
		c2.setTipo("Ahorros");
		c2.setPropietario(propietario2);
		
		this.bancariaService.guardar(c1);
		this.bancariaService.guardar(c2);
		
		//this.iTransferenciaService.realizarTransferencia("1234", "5678", new BigDecimal(35));
		
		//c1=this.bancariaService.buscarPorNumero("1234");
		//System.out.println(c1);
		
		//c2= this.bancariaService.buscarPorNumero("5678");
		//System.out.println(c2);
		
		
	}

}
