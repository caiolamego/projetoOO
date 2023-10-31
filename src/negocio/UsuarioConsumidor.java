package negocio;

import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioConsumidor extends Usuario{
	
	Scanner sc = new Scanner(System.in);
	private String cpf;
	private String dataNascimento;
	private char genero;
	private String celular;
	
	
	// O método criarConta pode ser implementado no próprio construtor
	public UsuarioConsumidor(String nome, String endereco, String email, String senha, String cpf,
			String dataNascimento, int i, String celular) {
		System.out.print("Nome completo:");
		this.nome = sc.nextLine();
		System.out.print("Endereco: ");
		this.endereco = sc.nextLine();
		System.out.print("CPF: ");
		this.cpf = sc.nextLine();
		System.out.print("Data de Nascimento (dd/mm/aaaa): ");
		this.dataNascimento = sc.nextLine();
		System.out.print("Genero (m/f) :");
		this.genero = sc.nextLine().charAt(0);
		System.out.println("Celular: ");
		this.celular = sc.nextLine();
		System.out.println("Email: ");
		this.email = sc.nextLine();
		System.out.println("Senha: ");
		this.senha = sc.nextLine();
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

	@Override
	public String exibirDados() {
		return "NOME: " + nome + "\n" + "CPF: " + cpf + "\n" + "ENDERECO: " + endereco 
				+ "\n" + "EMAIL: " + email + "\n" + "CELULAR: " + celular + "\n" + "DATA DE NASCIMENTO: " + dataNascimento 
				+ "\n" + "GENERO: " + genero;
	}
	
}
