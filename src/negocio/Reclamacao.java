package negocio;


public class Reclamacao {
	 
	private String nomeEmpresa;
	private String titulo;
	private String descricao;
	private String celular;
	private String classificacao;
	private String produtoOuServico;
	private String status = "Pendente";
	private double nota;
	private String resposta;

	
	public Reclamacao(String nomeEmpresa, String titulo, String descricao, String celular, String classificacao,
			String produtoOuServico, String status, double nota, String resposta) {
		this.nomeEmpresa = nomeEmpresa;
		this.titulo = titulo;
		this.descricao = descricao;
		this.celular = celular;
		this.classificacao = classificacao;
		this.produtoOuServico = produtoOuServico;
		this.status = status;
		this.nota = nota;
		this.resposta = resposta;
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
	
	
	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public String exibirReclamacao() {
		if(status == "Pendente") {
			return "TITULO: " + titulo
					+ "\nEMPRESA: " + nomeEmpresa
					+ "\nDESCRICAO: " + descricao
					+ "\nPRODUTO OU SERVICO: " + produtoOuServico
					+ "\nNOTA: " + nota
					+ "\nSTATUS: " + status;
		} else {
			return "TITULO: " + titulo
					+ "\nEMPRESA: " + nomeEmpresa
					+ "\nDESCRICAO: " + descricao
					+ "PRODUTO OU SERVICO: " + produtoOuServico
					+ "\nNOTA: " + nota
					+ "\nSTATUS: " + status
					+ "\nRESPOSTA: " + resposta;
		}
	}
	
	
	

	
	

	
	
	
	
}
