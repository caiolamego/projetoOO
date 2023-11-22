package negocio;

import java.util.ArrayList;

public class UsuarioConsumidor extends Usuario{
	
	private String cpf;
	private String dataNascimento;
	private char genero;
	private String celular;
	
	
	

	public UsuarioConsumidor(String nome, String endereco, String email, String senha, ArrayList<Reclamacao> reclamacao,
			String cpf, String dataNascimento, char genero, String celular) {
		super(nome, endereco, email, senha, reclamacao);
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


	@Override
	public String exibirDados() {
		return "NOME: " + nome
				+ "\nENDERECO: " + endereco
				+ "\nCPF: " + cpf
				+ "\nDATA DE NASCIMENTO: " + dataNascimento
				+ "\nGENERO: " + genero
				+ "\nCELULAR: " + celular
				+ "\nEMAIL: " + email;
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
		return "UsuarioConsumidor [Nome = " + nome + ", Endereco = " + endereco + ", Email = " + email
				+ ", Senha = " + senha + ", CPF = " + cpf + ", DataNascimento = " + dataNascimento + ", Genero = " + genero
				+ ", Celular = " + celular + "]";
	}

	@Override
    public String getSenha() {
        return senha;
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
	
	
	
	
	
	
	
}
