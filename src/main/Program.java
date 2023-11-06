package main;

import java.util.ArrayList;

import negocio.Conta;
import negocio.Reclamacao;
import negocio.UsuarioConsumidor;
import negocio.UsuarioEmpresa;

public class Program {
	
	private static Conta conta = new Conta();

	public static void main(String[] args) {

		
		conta.preencherDados();
		
		for(int i = 0; i < conta.getEmpresasExistentes().size(); i++) {
			System.out.println(conta.getEmpresasExistentes().get(i).toString());
		}
		
		System.out.println();
		
		for(int i = 0; i < conta.getEmpresasExistentes().size(); i++) {
			System.out.println(conta.getConsumidoresExistentes().get(i).toString());
		}


		
		
		
	}

}
