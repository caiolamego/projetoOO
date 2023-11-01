package negocio;

import java.util.ArrayList;

public abstract class Usuario {
	private String nome;
	private String endereco;
	private String email;
	private String senha;
	private ArrayList<Reclamacao> reclamacao;
	
	public Usuario(String nome, String endereco, String email, String senha, ArrayList<Reclamacao> reclamacao) {
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.senha = senha;
		this.reclamacao = reclamacao;
	}
	
	public Usuario() {
		
	}

	public ArrayList<Reclamacao> getReclamacao() {
		return reclamacao;
	}

	public void setReclamacao(ArrayList<Reclamacao> reclamacao) {
		this.reclamacao = reclamacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public abstract String exibirDados();
	
	
	
	
	
	
	
}
