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
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public String toString() {
		return "UsuarioEmpresa [nomeComercial=" + nomeComercial + ", cnpj=" + cnpj + ", site=" + site
				+ ", nomeResponsavel=" + nomeResponsavel + ", emailResponsavel=" + emailResponsavel + "]";
	}
	
	
	
	
	
}
