package negocio;

import java.util.ArrayList;
import java.util.List;

public class Conta {
	private UsuarioConsumidor[] consumidor;
	private UsuarioEmpresa[] empresa;
	private static List<Usuario> contasExistentes = new ArrayList<>();
	
	public Conta(UsuarioConsumidor[] consumidor, UsuarioEmpresa[] empresa, List<Usuario> contasExistentes) {
		this.consumidor = consumidor;
		this.empresa = empresa;
		Conta.contasExistentes = contasExistentes;
	}
	
	public Conta(List<Usuario> contasExistentes) {
		Conta.contasExistentes = contasExistentes;
	}

	public UsuarioConsumidor[] getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(UsuarioConsumidor[] consumidor) {
		this.consumidor = consumidor;
	}

	public UsuarioEmpresa[] getEmpresa() {
		return empresa;
	}

	public void setEmpresa(UsuarioEmpresa[] empresa) {
		this.empresa = empresa;
	}

	public static List<Usuario> getContasExistentes() {
		return contasExistentes;
	}

	public void setContasExistentes(List<Usuario> contasExistentes) {
		Conta.contasExistentes = contasExistentes;
	}
	
	
	
	
}
