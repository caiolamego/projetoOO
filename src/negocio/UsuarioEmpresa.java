package negocio;

import java.util.Scanner;

public class UsuarioEmpresa extends Usuario{
	
	Scanner sc = new Scanner(System.in);
	
	private String nomeComercial;
	private String cnpj;
	private String site;
	private String nomeResponsavel;
	private String emailResponsavel;
	
	public UsuarioEmpresa(String nome, String endereco, String email, String senha, String nomeComercial, String cnpj,
			String site, String nomeResponsavel, String emailResponsavel) {
		System.out.print("Nome CNPJ:");
		this.nome = sc.nextLine();
		System.out.print("Endereco: ");
		this.endereco = sc.nextLine();
		System.out.print("CNPJ: ");
		this.cnpj = sc.nextLine();
		System.out.print("Nome Comercial: ");
		this.nomeComercial = sc.nextLine();
		System.out.print("Site:");
		this.site = sc.nextLine();
		System.out.println("Nome Responavel: ");
		this.nomeResponsavel = sc.nextLine();
		System.out.println("Email Responsavel");
		this.emailResponsavel = sc.nextLine();
		System.out.println("Email do estabelecimento: ");
		this.email = sc.nextLine();
		System.out.println("Senha: ");
		this.senha = sc.nextLine();
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
		return "NOME CNPJ: " + nome + "\n" + "CNPJ: " + cnpj + "\n" + "ENDERECO: " + endereco 
				+ "\n" + "EMAIL ESTABELECIMENTO: " + email + "\n" + "NOME COMERCIAL: " + nomeComercial + "\n" + "SITE: " + site 
				+ "\n" + "EMAIL RESPONSAVEL" + emailResponsavel;
	}
	
	
	
}
