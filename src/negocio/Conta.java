package negocio;

import java.util.ArrayList;
import java.util.List;

public class Conta {
	private UsuarioConsumidor[] consumidor;
	private UsuarioEmpresa[] empresa;
	private List<String> contasExistentes = new ArrayList<>();
	
	public Conta(UsuarioConsumidor[] consumidor, UsuarioEmpresa[] empresa, List<String> contasExistentes) {
		this.consumidor = consumidor;
		this.empresa = empresa;
		this.contasExistentes = contasExistentes;
	}
	
	
	
	
}
