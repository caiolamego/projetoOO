package negocio;

import java.util.ArrayList;

public class UsuarioEmpresa extends Usuario{
	
	
	private String nomeComercial;
	private String cnpj;
	private String site;
	private String nomeResponsavel;
	private String emailResponsavel;
	
	

	public UsuarioEmpresa(String nome, String endereco, String email, String senha, ArrayList<Reclamacao> reclamacao,
			String nomeComercial, String cnpj, String site, String nomeResponsavel, String emailResponsavel) {
		super(nome, endereco, email, senha, reclamacao);
		this.nomeComercial = nomeComercial;
		this.cnpj = cnpj;
		this.site = site;
		this.nomeResponsavel = nomeResponsavel;
		this.emailResponsavel = emailResponsavel;
	}
	
	
	
	
	public String getNomeComercial() {
		return nomeComercial;
	}




	public void setNomeComercial(String nomeComercial) {
		this.nomeComercial = nomeComercial;
	}




	public String getCnpj() {
		return cnpj;
	}




	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}




	public String getSite() {
		return site;
	}




	public void setSite(String site) {
		this.site = site;
	}




	public String getNomeResponsavel() {
		return nomeResponsavel;
	}




	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}




	public String getEmailResponsavel() {
		return emailResponsavel;
	}




	public void setEmailResponsavel(String emailResponsavel) {
		this.emailResponsavel = emailResponsavel;
	}




	@Override
	public String exibirDados() {
		return "NOME FANTASIA: " + nome
				+ "\nNOME COMERCIAL: " + nomeComercial
				+ "\nCNPJ: " + cnpj
				+ "\nENDERECO: " + endereco
				+ "\nEMAIL: " + email
				+ "\nSITE: " + senha 
				+ "\nNOME RESPONSAVEL: " + nomeResponsavel
				+ "\nEMAIL RESPONSAVEL: " + emailResponsavel;
	}
	
	public String editarDados(boolean option) {
		if(option == true) {
			return "Usuario atualizado com sucesso!";
		} else {
			return "Usuario nao atualizado!";
		}
	}



	@Override
	public String toString() {
		return "UsuarioEmpresa [Nome = " + nome + ", Endereco = " + endereco + ", Email = " + email 
				+ ", Senha = " + senha + ", NomeComercial = " + nomeComercial + ", CNPJ = " + cnpj + ", Site = " + site
				+ ", NomeResponsavel = " + nomeResponsavel + ", EmailResponsavel = " + emailResponsavel + "]";
	}




	@Override
	public String filtrarReclamacoesResp() {
		String filtro = "";
		for(int i = 0; i < reclamacao.size(); i++) {
			if(reclamacao.get(i).getStatus().equalsIgnoreCase("Respondida")) {
				filtro = filtro + " \n" + reclamacao.get(i).getTitulo();
			}
		}
		if(filtro == "") {
			return "Nao ha reclamacoes respondidas";
		} else {
			return filtro;
		}
	}




	@Override
	public String filtrarReclamacoesNResp() {
		String filtro = "";
		for(int i = 0; i < reclamacao.size(); i++) {
			if(reclamacao.get(i).getStatus().equalsIgnoreCase("Pendente")) {
				filtro = filtro + " \n" + reclamacao.get(i).getTitulo();
			}
		}
		if(filtro == "") {
			return "Nao ha reclamacoes pendentes";
		} else {
			return filtro;
		}
	}

	public String responderReclamacao(String titulo, String resposta) {
		for(int i = 0; i < reclamacao.size(); i++) {
			if(reclamacao.get(i).getTitulo().equals(titulo) && reclamacao.get(i).getStatus().equals("Pendente")) {
				reclamacao.get(i).setStatus("Repondida");
				reclamacao.get(i).setResposta(resposta);
				return "RESPOSTA: " + resposta + "\nReclamacao respondida com sucesso!";
			}
		}
		return "Reclamacao nao encontrada ou ja respondida";
	}
	
	
	
	
	
}
