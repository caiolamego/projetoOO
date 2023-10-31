package negocio;

import java.util.Scanner;

public class Reclamacao {
	
	Scanner sc = new Scanner(System.in); 
	private String nomeEmpresa;
	private String titulo;
	private String descricao;
	private String celular;
	private String classificacao;
	private String produtoOuServico;
	private String status;
	private double nota;
	
	public Reclamacao(String nomeEmpresa, String titulo, String descricao, String celular, String classificacao,
			String produtoOuServico, String status, double nota) {
		this.nomeEmpresa = nomeEmpresa;
		this.titulo = titulo;
		this.descricao = descricao;
		this.celular = celular;
		this.classificacao = classificacao;
		this.produtoOuServico = produtoOuServico;
		this.status = status;
		this.nota = nota;
	}
	
	public Reclamacao() {
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getProdutoOuServico() {
		return produtoOuServico;
	}

	public void setProdutoOuServico(String produtoOuServico) {
		this.produtoOuServico = produtoOuServico;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	public void criarReclamacao(String titulo, String descricao, String nomeEmpresa, String classificacao, String produtoOuServico, double nota) {
		System.out.print("Crie um titulo para sua reclamacao:");
		titulo = sc.nextLine();
		System.out.print("Faça uma decricao sobre sua reclamacao: ");
		descricao = sc.nextLine();
		System.out.print("Cite o nome da empresa que deseja reclamar: ");
		nomeEmpresa = sc.nextLine();
		System.out.print("Classifique sua reclamacao (Ex: produto errado, comida gelada)");
		classificacao = sc.nextLine();
		System.out.print("Cite o produto ou serviço reclamado (Ex: Malas, Suco, Atendimento, etc.)");
		produtoOuServico = sc.nextLine();
		System.out.println("De uma nota de a 0 - 10 para o serviço, podendo conter até um digito decimal!");
		nota = sc.nextDouble();
	}

	
	
	
	
}
