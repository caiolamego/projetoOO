package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dados.Conta;
import negocio.Reclamacao;
import negocio.Usuario;
import negocio.UsuarioConsumidor;
import negocio.UsuarioEmpresa;

public class Program {

	private static Conta conta = new Conta();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		//teste 
		Reclamacao reclamacao = new Reclamacao("Nome9", "TITULO", null, null, null, null, "Pendente", 0);
		conta.preencherDados();
		int op = -1;
		int op2 = -1;
		while (op != 0) {
			System.out.println(imprimirMenuLogin());
			op = sc.nextInt();
			switch (op) {
			case 0:
				System.out.println("O sistema sera encerrado!");
				break;

			case 1:
				cadastrarEmpresa();
				System.out.println("Deseja retornar ao menu inicial? (y/n)");
				if (sc.next().charAt(0) == 'y') {
					break;
				} else {
					op = 0;
					System.out.println("O sistema sera encerrado!");
				}
				break;

			case 2:
				cadastrarConsumidor();
				System.out.println("Deseja retornar ao menu inicial? (y/n)");
				if (sc.next().charAt(0) == 'y') {
					break;
				} else {
					op = 0;
					System.out.println("O sistema sera encerrado!");
					break;
				}

			case 3:
				UsuarioEmpresa empresa = loginEmpresa();
				if (empresa == null) {
					System.out.println("CNPJ e/ou Senha incorreto(s)!");
					System.out.println("Deseja retornar ao menu (y/n)?");
					if (sc.next().charAt(0) == 'y') {
						break;
					} else {
						op = 0;
						System.out.println("O sistema sera encerrado!");
						break;
					}
				} else {
					while (op2 != 0) {
						System.out.println(imprimirOpcoesEmpresa());
						//teste 
						empresa.getReclamacao().add(reclamacao);
						op2 = sc.nextInt();
						switch (op2) {
						case 0:
							System.out.println("Obrigado, " + empresa.getNome() + "! Deseja voltar ao menu incial?");
							if (sc.next().charAt(0) == 'y') {
								break;
							} else {
								op = 0;
								System.out.println("O sistema sera encerrado!");
								break;
							}
							
						case 1:
							System.out.println("Digite o numero corrspondente a sua escolha para filtragem: \n"
									+ "1 - Respondidas \n"
									+ "2 - Pendentes");
							int filtro = sc.nextInt();
							if(filtro == 1) {
								empresa.filtrarReclamacoesResp();
							} else if (filtro == 2) {
								empresa.filtrarReclamacoesNResp();
							} else {
								System.out.println("Opcao invalida!");
							}
							System.out.println("Deseja retornar ao menu de opcoes? (y/n)");
							if (sc.next().charAt(0) == 'y') {
								break;
							} else {
								op = 0;
								op2 = 0;
								System.out.println("O sistema sera encerrado!");
							}
							
						case 2:
							listarReclamacoesDaEmpresa(empresa.getNome());
							sc.next();
							break;
							
						case 3:
							System.out.println("Escreva o titulo da Reclamacao:");
							String titulo = sc.next();
							System.out.println();
							System.out.println("Escreva a resposta para a Reclamacao:");
							String resposta = sc.next();
							System.out.println();
							empresa.responderReclamacao(titulo, resposta);
							System.out.println("Deseja retornar ao menu de opcoes? (y/n)");
							if (sc.next().charAt(0) == 'y') {
								break;
							} else {
								op = 0;
								op2 = 0;
								System.out.println("O sistema sera encerrado!");
							}
						}
					}
					break;
				}

			case 4:
				boolean loginCon = loginConsumidor();
				if (loginCon == true) {
					op = 0;
					break;
				} else {
					System.out.println("CPF e/ou Senha incorreto(s)!");
					System.out.println("Deseja retornar ao menu (y/n)?");
					if (sc.next().charAt(0) == 'y') {
						break;
					} else {
						op = 0;
						System.out.println("O sistema sera encerrado!");
						break;
					}
				}
			}

		}

		for (int i = 0; i < conta.getConsumidoresExistentes().size(); i++) {
			System.out.println(conta.getConsumidoresExistentes().get(i).toString());
		}

		sc.close();
	}

	public static String imprimirMenuLogin() {
		String opcoesIniciais = new String("Digite o valor correspondente para a opcao que deseja realizar: \n");
		opcoesIniciais = opcoesIniciais + "0 - Sair do sistema \n";
		opcoesIniciais = opcoesIniciais + "1 - Cadastrar Empresa \n";
		opcoesIniciais = opcoesIniciais + "2 - Cadastrar Consumidor \n";
		opcoesIniciais = opcoesIniciais + "3 - Login Empresa \n";
		opcoesIniciais = opcoesIniciais + "4 - Login consumidor";
		return opcoesIniciais;
	}

	public static UsuarioEmpresa lerDadosEmpresa() {
		String nome;
		String nomeComercial;
		String email;
		String endereco;
		String senha;
		String cnpj;
		String site;
		String nomeResponsavel;
		String emailResponsavel;
		sc.nextLine();
		System.out.println("Nome Fantasia: ");
		nome = sc.nextLine();
		System.out.println("Nome Comercial:");
		nomeComercial = sc.nextLine();
		System.out.println("Email da empresa:");
		email = sc.nextLine();
		System.out.println("CNPJ (apenas os 14 digitos numericos):");
		cnpj = sc.nextLine();
		System.out.println("Site da empresa:");
		site = sc.nextLine();
		System.out.println("Endereco:");
		endereco = sc.nextLine();
		System.out.println("Nome da pessoa responsavel:");
		nomeResponsavel = sc.nextLine();
		System.out.println("Email da pessoa responsavel:");
		emailResponsavel = sc.nextLine();
		System.out.println("Crie uma senha de 8 digitos:");
		senha = sc.nextLine();
		UsuarioEmpresa empresa = new UsuarioEmpresa(nome, endereco, email, senha, new ArrayList<Reclamacao>(), nomeComercial, cnpj, site,
				nomeResponsavel, emailResponsavel);
		return empresa;
	}

	public static UsuarioConsumidor lerDadosConsumidor() {
		String nome;
		String dataNascimento;
		String email;
		String endereco;
		String senha;
		String cpf;
		char genero;
		String celular;

		sc.nextLine();
		System.out.println("Nome: ");
		nome = sc.nextLine();
		System.out.println("CPF (apenas os 11 digitos numericos):");
		cpf = sc.nextLine();
		System.out.println("Email:");
		email = sc.nextLine();
		System.out.println("Data de nascimento:");
		dataNascimento = sc.nextLine();
		System.out.println("Genero (m/f/o):");
		genero = sc.nextLine().charAt(0);
		System.out.println("Endereco:");
		endereco = sc.nextLine();
		System.out.println("Celular:");
		celular = sc.nextLine();
		System.out.println("Crie uma senha de 8 digitos:");
		senha = sc.nextLine();
		UsuarioConsumidor consumidor = new UsuarioConsumidor(nome, endereco, email, senha, null, cpf, dataNascimento,
				genero, celular);
		return consumidor;
	}

	public static boolean cadastrarEmpresa() {
		UsuarioEmpresa empresa = lerDadosEmpresa();
		if ((empresa.getSenha().length() < 4) || (empresa.getSenha().length() > 8)) {
			System.out.println("A empresa nao pode ser cadastrada, pois a senha nao segue o padrao solicitado!");
			return false;
		} else if (empresa.getCnpj().length() != 14) {
			System.out.println("A empresa nao pode ser cadastrada, pois o CNPJ nao possui 14 digitos");
			return false;
		} else {
			System.out.println("Empresa cadastrada com sucesso!");
			conta.getEmpresasExistentes().add(empresa);
			return true;
		}
	}

	public static boolean cadastrarConsumidor() {
		UsuarioConsumidor consumidor = lerDadosConsumidor();
		if ((consumidor.getSenha().length() < 4) || (consumidor.getSenha().length() > 8)) {
			System.out.println("O consumidor nao pode ser cadastrado, pois a senha nao segue o padrao solicitado!");
			return false;
		} else if (consumidor.getCpf().length() != 8) {
			System.out.println("A empresa nao pode ser cadastrada, pois o CPF nao possui 8 digitos");
			return false;
		} else {
			System.out.println("Consumidor cadastrado com sucesso!");
			conta.getConsumidoresExistentes().add(consumidor);
			return true;
		}
	}

	public static UsuarioEmpresa loginEmpresa() {
		Scanner sc = new Scanner(System.in);

		System.out.print("CNPJ (apenas os 14 digitos): ");
		String cnpjLogin = sc.nextLine();

		System.out.print("Senha: ");
		String senhaLogin = sc.nextLine();

		for (UsuarioEmpresa empresa : conta.getEmpresasExistentes()) {
			if (cnpjLogin.equals(empresa.getCnpj()) && senhaLogin.equals(empresa.getSenha())) {

				return empresa;
			}
		}
		return null;
	}

	public static boolean loginConsumidor() {
		Scanner sc = new Scanner(System.in);

		System.out.print("CPF (apenas os 11 digitos): ");
		String cpfLogin = sc.nextLine();

		System.out.print("Senha: ");
		String senhaLogin = sc.nextLine();

		for (UsuarioConsumidor consumidor : conta.getConsumidoresExistentes()) {
			if (cpfLogin.equals(consumidor.getCpf()) && senhaLogin.equals(consumidor.getSenha())) {
				return true;
			}
		}
		return false;
	}

	public static String imprimirOpcoesEmpresa() {
		String opcoesEmpresa = new String("Digite o valor correspondente para a opcao que deseja realizar: \n");
		opcoesEmpresa = opcoesEmpresa + "0 - Sair da conta \n";
		opcoesEmpresa = opcoesEmpresa + "1 - Filtrar Reclamacao \n";
		opcoesEmpresa = opcoesEmpresa + "2 - Listar Reclamacoes \n";
		opcoesEmpresa = opcoesEmpresa + "3 - Responder Reclamacao \n";
		opcoesEmpresa = opcoesEmpresa + "4 - Ver Reclamacao";
		return opcoesEmpresa;
	}

	// Listagem de reclamações do usuário
    public void listarReclamacoesDoUsuario(String nomeUsuario) {
        Usuario usuario = conta.pesquisarUsuario(nomeUsuario);

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
	public static void listarReclamacoesDaEmpresa(String nomeEmpresa) {
		List<Reclamacao> reclamacoesDaEmpresa = new ArrayList<>();
	
		for (Usuario usuario : conta.getContasExistentes()) {
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
}
