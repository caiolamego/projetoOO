package negocio;

public class UsuarioConsumidor extends Usuario{
	
	private String cpf;
	private String dataNascimento;
	private char genero;
	private String celular;
	
	public UsuarioConsumidor(String nome, String endereco, String email, String senha, String cpf,
			String dataNascimento, char genero, String celular) {
		super(nome, endereco, email, senha);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.celular = celular;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
	
	
	
}
