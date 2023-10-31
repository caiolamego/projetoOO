package negocio;

public abstract class Usuario {
	protected String nome;
	protected String endereco;
	protected String email;
	protected String senha;
	private Reclamacao[] reclamacao;
	
	public Usuario(String nome, String endereco, String email, String senha) {
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario() {
		
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
