package negocio;

import java.util.ArrayList;

public class Conta {
	private static ArrayList<UsuarioEmpresa> empresasExistentes;
	private ArrayList<UsuarioConsumidor> consumidoresExistentes;
	private ArrayList<Usuario> contasExistentes;
	
	
	
	public Conta() {
		this.empresasExistentes = new ArrayList<UsuarioEmpresa>();
		this.consumidoresExistentes = new ArrayList<UsuarioConsumidor>();
		this.contasExistentes = new ArrayList<Usuario>();
	}

	

	public ArrayList<UsuarioEmpresa> getEmpresasExistentes() {
		return empresasExistentes;
	}



	public void setEmpresasExistentes(ArrayList<UsuarioEmpresa> empresasExistentes) {
		this.empresasExistentes = empresasExistentes;
	}



	public ArrayList<UsuarioConsumidor> getConsumidoresExistentes() {
		return consumidoresExistentes;
	}



	public void setConsumidoresExistentes(ArrayList<UsuarioConsumidor> consumidoresExistentes) {
		this.consumidoresExistentes = consumidoresExistentes;
	}



	public ArrayList<Usuario> getContasExistentes() {
		return contasExistentes;
	}



	public void setContasExistentes(ArrayList<Usuario> contasExistentes) {
		this.contasExistentes = contasExistentes;
	}



	public void preencherDados() {
		for(int i = 0; i < 10; i++) {
			String s = String.valueOf(i);
			char g = 'g';
			UsuarioEmpresa empresa = new UsuarioEmpresa("Nome" + s,"Endereco" + s,"Email" + s,"Senha" + s, null,"NomeComercial" + s, 
					"CNPJ" + s,"Site" + s,"NomeResponsavel" + s,"EmailResponsavel" + s);		
			empresasExistentes.add(empresa);
			UsuarioConsumidor  consumidor = new UsuarioConsumidor("Nome" + s,"Endereco" + s,"Email" + s,"Senha" + s, null,"Cpf" + s, 
					"DataNascimento" + s, g,"Celular" + s);
			consumidoresExistentes.add(consumidor);
		}
		
	}
	
	
	
}
