package dados;

import java.util.ArrayList;
import java.util.List;

import negocio.Reclamacao;
import negocio.Usuario;
import negocio.UsuarioConsumidor;
import negocio.UsuarioEmpresa;

public class Conta {
	private ArrayList<UsuarioEmpresa> empresasExistentes;
	private ArrayList<UsuarioConsumidor> consumidoresExistentes;
	private static ArrayList<Usuario> contasExistentes;
	
	
	
	public Conta() {
		this.empresasExistentes = new ArrayList<UsuarioEmpresa>();
		this.consumidoresExistentes = new ArrayList<UsuarioConsumidor>();
		this.contasExistentes = new ArrayList<Usuario>();
	}

	

	public ArrayList<UsuarioEmpresa> getEmpresasExistentes() {
		return empresasExistentes;
	}



	public void setEmpresasExistentes(ArrayList<UsuarioEmpresa> empresasExistentes) {
		this.empresasExistentes = empresasExistentes;
	}



	public ArrayList<UsuarioConsumidor> getConsumidoresExistentes() {
		return consumidoresExistentes;
	}



	public void setConsumidoresExistentes(ArrayList<UsuarioConsumidor> consumidoresExistentes) {
		this.consumidoresExistentes = consumidoresExistentes;
	}



	public ArrayList<Usuario> getContasExistentes() {
		return contasExistentes;
	}



	public void setContasExistentes(ArrayList<Usuario> contasExistentes) {
		this.contasExistentes = contasExistentes;
	}

	// Pesquisa de usuário
    public Usuario pesquisarUsuario(String nome) {
        for (UsuarioConsumidor consumidor : consumidoresExistentes) {
            if (consumidor.getNome().equals(nome)) {
                return consumidor;
            }
        }

        for (UsuarioEmpresa empresa : empresasExistentes) {
            if (empresa.getNome().equals(nome)) {
                return empresa;
            }
        }
        return null;
    }
    
    // Listagem de reclamações do usuário
    public void listarReclamacoesDoUsuario(String nomeUsuario) {
        Usuario usuario = pesquisarUsuario(nomeUsuario);

        if (usuario != null) {
            List<Reclamacao> reclamacoesDoUsuario = usuario.getReclamacoes();

            if (reclamacoesDoUsuario.isEmpty()) {
                System.out.println("Este usuário não possui reclamações.");
            } else {
                System.out.println("Reclamações do usuário " + nomeUsuario + ":");
                for (Reclamacao reclamacao : reclamacoesDoUsuario) {
                    System.out.println(reclamacao.toString());
                }
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
	
    // Listagem de reclamações associadas a cada empresa
	public String listarReclamacoesDaEmpresa(String nomeEmpresa) {
		List<Reclamacao> reclamacoesDaEmpresa = new ArrayList<>();
	
		for (Usuario usuario : contasExistentes) {
			List<Reclamacao> reclamacoes = new ArrayList<>(usuario.getReclamacoes());
	
			for (Reclamacao reclamacao : reclamacoes) {
				if (reclamacao.getNomeEmpresa().equalsIgnoreCase(nomeEmpresa)) {
					reclamacoesDaEmpresa.add(reclamacao);
				}
			}
		}
	
		if (!reclamacoesDaEmpresa.isEmpty()) {
			String recEmpresa = "Reclamacoes da empresa " + nomeEmpresa + ":\n";
			String textoRec = "";
			for (Reclamacao reclamacao : reclamacoesDaEmpresa) {
				textoRec = textoRec + reclamacao.getTitulo() + "\n";
				System.out.println(reclamacoesDaEmpresa.size());
			}
			return recEmpresa + textoRec + "\n";
		} else {
			return "Nenhuma reclamação encontrada para a empresa " + nomeEmpresa;
		}
	}
	/* 
	A listagem caso a "ArrayList<Usuario> contasExistentes" for excluida, pois ela só é usada na listagem das reclamações da empresa

	 public void listarReclamacoesDaEmpresa(String nomeEmpresa) {
		List<Reclamacao> reclamacoesDaEmpresa = new ArrayList<>();

		// Percorre consumidores
		for (Usuario usuario : consumidoresExistentes) {
			List<Reclamacao> reclamacoes = new ArrayList<>(usuario.getReclamacoes());

			for (Reclamacao reclamacao : reclamacoes) {
				if (reclamacao.getNomeEmpresa().equalsIgnoreCase(nomeEmpresa)) {
					reclamacoesDaEmpresa.add(reclamacao);
				}
			}
		}

		// Percorre empresas
		for (Usuario usuario : empresasExistentes) {
			List<Reclamacao> reclamacoes = new ArrayList<>(usuario.getReclamacoes());

			for (Reclamacao reclamacao : reclamacoes) {
				if (reclamacao.getNomeEmpresa().equalsIgnoreCase(nomeEmpresa)) {
					reclamacoesDaEmpresa.add(reclamacao);
				}
			}
		}

		if (!reclamacoesDaEmpresa.isEmpty()) {
			System.out.println("Reclamações da empresa " + nomeEmpresa + ":");
			for (Reclamacao reclamacao : reclamacoesDaEmpresa) {
				System.out.println(reclamacao.toString());
			}
		} else {
			System.out.println("Nenhuma reclamação encontrada para a empresa " + nomeEmpresa);
		}
	}
	 */
        
	// Simulação do banco de dados
	public void preencherDados() {
		for(int i = 0; i < 10; i++) {
			String s = String.valueOf(i);
			char g = 'g';
			UsuarioEmpresa empresa = new UsuarioEmpresa("Nome" + s,"Endereco" + s,"Email" + s,"Senha" + s, new ArrayList<Reclamacao>(),"NomeComercial" + s, 
					"CNPJ" + s,"Site" + s,"NomeResponsavel" + s,"EmailResponsavel" + s);		
			empresasExistentes.add(empresa);
            contasExistentes.add(empresa);
			UsuarioConsumidor  consumidor = new UsuarioConsumidor("Nome" + s,"Endereco" + s,"Email" + s,"Senha" + s, new ArrayList<Reclamacao>(),"Cpf" + s, 
					"DataNascimento" + s, g,"Celular" + s);
			consumidoresExistentes.add(consumidor);
            contasExistentes.add(consumidor);
		}
		
	}
	
	
	
}
