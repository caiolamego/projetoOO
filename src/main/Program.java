package main;

import java.util.ArrayList;

import negocio.Conta;
import negocio.Reclamacao;
import negocio.UsuarioConsumidor;
import negocio.UsuarioEmpresa;

public class Program {

	public static void main(String[] args) {
		Reclamacao reclamacao = new Reclamacao();
		UsuarioConsumidor consumidor = new UsuarioConsumidor(null, null, null, null, null, null, 0, null);
		System.out.println();
		UsuarioEmpresa empresa= new UsuarioEmpresa(null, null, null, null, null, null, null, null, null);
		
		Conta.getContasExistentes().add(consumidor);
		
		System.out.println(consumidor.exibirDados());
		System.out.println();
		System.out.println(empresa.exibirDados());
		
	}

}
