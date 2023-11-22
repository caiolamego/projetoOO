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
				} 
				else {
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
					op2 = -1;
					while (op2 != 0) {
						System.out.println(imprimirOpcoesEmpresa());
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
									+ "1 - Respondidas \n" + "2 - Pendentes");
							int filtro = sc.nextInt();
							if (filtro == 1) {
								System.out.println(empresa.filtrarReclamacoesResp());
							} else if (filtro == 2) {
								System.out.println(empresa.filtrarReclamacoesNResp());
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
								break;
							}

						case 2:
							System.out.println(conta.listarReclamacoesDaEmpresa(empresa.getNome()));
							System.out.println("Deseja retornar ao menu de opcoes? (y/n)");
							if (sc.next().charAt(0) == 'y') {
								break;
							} else {
								op = 0;
								op2 = 0;
								System.out.println("O sistema sera encerrado!");
							}
							break;

						case 3:
							System.out.println("Escreva o titulo da Reclamacao:");
							sc.nextLine();
							String titulo = sc.nextLine();
							System.out.println("Escreva a resposta para a Reclamacao:");
							String resposta = sc.nextLine();
							System.out.println(empresa.responderReclamacao(titulo, resposta));
							System.out.println("Deseja retornar ao menu de opcoes? (y/n)");
							if (sc.next().charAt(0) == 'y') {
								break;
							} else {
								op = 0;
								op2 = 0;
								System.out.println("O sistema sera encerrado!");
								break;
							}
						case 4:
							System.out.println(conta.listarReclamacoesDaEmpresa(empresa.getNome()));
							System.out.println(mostrarReclamacao(empresa));
							System.out.println();
							System.out.println("Deseja retornar ao menu de opcoes? (y/n)");
							if (sc.next().charAt(0) == 'y') {
								break;
							} else {
								op = 0;
								op2 = 0;
								System.out.println("O sistema sera encerrado!");
								break;
							}

						case 5:
							boolean edicao = mudarDadoEmpresa(empresa);
							System.out.println(empresa.editarDados(edicao));
							System.out.println();
							System.out.println("Deseja retornar ao menu de opcoes? (y/n)");
							if (sc.next().charAt(0) == 'y') {
								break;
							} else {
								op = 0;
								op2 = 0;
								System.out.println("O sistema sera encerrado!");
								break;
							}
						default:
							System.out.println("Opcao invalida!");
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

			case 4: // Login do Consumidor
				UsuarioConsumidor consumidor = loginConsumidor();
				if (consumidor != null) {
					int opConsumidor = -1;

					while (opConsumidor != 0) {
						System.out.println(imprimirOpcoesConsumidor());
						opConsumidor = sc.nextInt();

						switch (opConsumidor) {
						case 0:
							System.out.println("Obrigado, " + consumidor.getNome() + "! Deseja voltar ao menu incial?");
							if (sc.next().charAt(0) == 'y') {
								break;
							} else {
								op = 0;
								System.out.println("O sistema sera encerrado!");
								break;
							}
						case 1:
							System.out.println(consumidor.exibirDados());
							System.out.println();
							System.out.println("Deseja retornar ao menu de opcoes? (y/n)");
							if (sc.next().charAt(0) == 'y') {
								break;
							} else {
								op = 0;
								opConsumidor = 0;
								System.out.println("O sistema sera encerrado!");
								break;
							}
						case 2:
							boolean edicao = mudarDadoConsumidor(consumidor);
							System.out.println();
							System.out.println(consumidor.editarDados(edicao));
							System.out.println("Deseja retornar ao menu de opcoes? (y/n)");
							if (sc.next().charAt(0) == 'y') {
								break;
							} else {
								op = 0;
								opConsumidor = 0;
								System.out.println("O sistema sera encerrado!");
								break;
							}
						case 3:
							String resultado = conta.listarReclamacoesDoUsuario(consumidor.getNome());
							System.out.println(resultado);
							// Se o usúario tiver reclamações ele pode mostrar postar por completo uma delas
							if (resultado != "Este usuario nao possui reclamacoes"
									&& resultado != "Usuario: " + consumidor.getNome() + "não encontrado ") {
								System.out.println(mostrarReclamacaoComsumidor(consumidor));
							}
							System.out.println();
							System.out.println("Deseja retornar ao menu de opcoes? (y/n)");
							if (sc.next().charAt(0) == 'y') {
								break;
							} else {
								op = 0;
								opConsumidor = 0;
								System.out.println("O sistema sera encerrado!");
								break;
							}
						case 4:
							boolean novaReclamacao = criarReclamação(consumidor);
							if (novaReclamacao == true) {
								System.out.println("Reclamacao criada com sucesso!");
							} else {
								System.out.println("Falha ao criar a reclamacao!");
							}
							System.out.println();
							System.out.println("Deseja retornar ao menu de opcoes? (y/n)");
							if (sc.next().charAt(0) == 'y') {
								break;
							} else {
								op = 0;
								opConsumidor = 0;
								System.out.println("O sistema sera encerrado!");
								break;
							}
						case 5:
							System.out.println("Digite o titulo da reclamacao:");
							sc.nextLine();
							String titulo = sc.nextLine();
							Reclamacao reclamacaop = conta.pesquisaReclamacao(titulo);
							if (reclamacaop != null) {
								System.out.println(reclamacaop.exibirReclamacao());
							} else {
								System.out.println("Reclamação não encontrada!");
							}
							System.out.println();
							System.out.println("Deseja retornar ao menu de opcoes? (y/n)");
							if (sc.next().charAt(0) == 'y') {
								break;
							} else {
								op = 0;
								opConsumidor = 0;
								System.out.println("O sistema sera encerrado!");
								break;
							}
						case 6:
							System.out.println("Digite o numero correspondente a sua escolha para filtragem: \n"
									+ "1 - Respondidas \n" + "2 - Pendentes");
							int filtro = sc.nextInt();
							if (filtro == 1) {
								System.out.println(consumidor.filtrarReclamacoesResp());
							} else if (filtro == 2) {
								System.out.println(consumidor.filtrarReclamacoesNResp());
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
								break;
							}

						case 7:
							String listaRec = conta.listarReclamacoesDoUsuario(consumidor.getNome());
							System.out.println(listaRec);
							System.out.println("Digite o titulo da Reclamacao que deseja alterar:");
							sc.nextLine();
							String tituloRec = sc.nextLine();
							Reclamacao reclamacaoEd = verificarExistenciaRec(tituloRec, consumidor);
							if(reclamacaoEd != null) {
								boolean recEditada = mudarReclamacao(reclamacaoEd);
								System.out.println(reclamacaoEd.editarReclamacao(recEditada));
							} else {
								System.out.println("Reclamacao nao encontrada ou ja resondida!");
							}
							
							System.out.println();
							System.out.println("Deseja retornar ao menu de opcoes? (y/n)");
							if (sc.next().charAt(0) == 'y') {
								break;
							} else {
								op = 0;
								opConsumidor = 0;
								System.out.println("O sistema sera encerrado!");
								break;
							}
							
							

						case 8:
							System.out.println("Digite sua senha");
							String senha = sc.next();
							if (senha.equals(consumidor.getSenha())) {
								boolean excluir = conta.excluirConta(consumidor);
								if (excluir) {
									System.out.println("Elemento removido com sucesso.\n");
								} else {
									System.out.println("Elemento não encontrado na lista.\n");
								}
							} else {
								System.out.println("Senha incorreta\n");
							}
							System.out.println();
							System.out.println("Deseja retornar ao menu de opcoes? (y/n)");
							if (sc.next().charAt(0) == 'y') {
								break;
							} else {
								op = 0;
								opConsumidor = 0;
								System.out.println("O sistema sera encerrado!");
								break;
							}
						default:
							System.out.println("Opcao invalida no Menu do Consumidor.");
							System.out.println();
							System.out.println("Deseja retornar ao menu de opcoes? (y/n)");
							if (sc.next().charAt(0) == 'y') {
								break;
							} else {
								op = 0;
								opConsumidor = 0;
								System.out.println("O sistema sera encerrado!");
								break;
							}
						}
					}
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
				break;

			default:
				System.out.println("Opcao Invalida!");

			}

		}
	}

// Menu inicial
	public static String imprimirMenuLogin() {
		String opcoesIniciais = new String("Digite o valor correspondente para a opcao que deseja realizar: \n");
		opcoesIniciais = opcoesIniciais + "0 - Sair do sistema \n";
		opcoesIniciais = opcoesIniciais + "1 - Cadastrar Empresa \n";
		opcoesIniciais = opcoesIniciais + "2 - Cadastrar Consumidor \n";
		opcoesIniciais = opcoesIniciais + "3 - Login Empresa \n";
		opcoesIniciais = opcoesIniciais + "4 - Login consumidor";
		return opcoesIniciais;
	}

// Leitura de dados
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
		UsuarioEmpresa empresa = new UsuarioEmpresa(nome, endereco, email, senha, new ArrayList<Reclamacao>(),
				nomeComercial, cnpj, site, nomeResponsavel, emailResponsavel);
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
		System.out.println("Data de nascimento (dd/mm/yyyy):");
		dataNascimento = sc.nextLine();
		System.out.println("Genero (m/f/o):");
		genero = sc.nextLine().charAt(0);
		System.out.println("Endereco:");
		endereco = sc.nextLine();
		System.out.println("Celular:");
		celular = sc.nextLine();
		System.out.println("Crie uma senha de 8 digitos:");
		senha = sc.nextLine();
		UsuarioConsumidor consumidor = new UsuarioConsumidor(nome, endereco, email, senha, new ArrayList<Reclamacao>(),
				cpf, dataNascimento, genero, celular);
		return consumidor;
	}

// Cadastro
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
		} else if (consumidor.getCpf().length() != 11) {
			System.out.println("A empresa nao pode ser cadastrada, pois o CPF nao possui 8 digitos");
			return false;
		} else {
			System.out.println("Consumidor cadastrado com sucesso!");
			conta.getConsumidoresExistentes().add(consumidor);
			return true;
		}
	}

// login
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

	public static UsuarioConsumidor loginConsumidor() {
		Scanner sc = new Scanner(System.in);

		System.out.print("CPF (apenas os 11 digitos): ");
		String cpfLogin = sc.nextLine();

		System.out.print("Senha: ");
		String senhaLogin = sc.nextLine();

		for (UsuarioConsumidor consumidor : conta.getConsumidoresExistentes()) {
			if (cpfLogin.equals(consumidor.getCpf()) && senhaLogin.equals(consumidor.getSenha())) {
				return consumidor;
			}
		}
		return null;
	}

// Menu de cada usuario
	public static String imprimirOpcoesEmpresa() {
		String opcoesEmpresa = new String("Digite o valor correspondente para a opcao que deseja realizar: \n");
		opcoesEmpresa = opcoesEmpresa + "0 - Sair da conta \n";
		opcoesEmpresa = opcoesEmpresa + "1 - Filtrar Reclamacao \n";
		opcoesEmpresa = opcoesEmpresa + "2 - Listar Reclamacoes \n";
		opcoesEmpresa = opcoesEmpresa + "3 - Responder Reclamacao \n";
		opcoesEmpresa = opcoesEmpresa + "4 - Ver Reclamacao\n";
		opcoesEmpresa = opcoesEmpresa + "5 - Ver e Editar dados";
		return opcoesEmpresa;
	}

	public static String imprimirOpcoesConsumidor() {
		String opcoesConsumidor = new String("Digite o valor correspondente para a opcao que deseja realizar: \n");
		opcoesConsumidor = opcoesConsumidor + "0 - Sair da conta \n";
		opcoesConsumidor = opcoesConsumidor + "1 - Exibir Dados \n";
		opcoesConsumidor = opcoesConsumidor + "2 - Editar dados \n";
		opcoesConsumidor = opcoesConsumidor + "3 - Listar Suas Reclamacoes \n";
		opcoesConsumidor = opcoesConsumidor + "4 - Criar Reclamacao \n";
		opcoesConsumidor = opcoesConsumidor + "5 - Pesquisar Qualquer Reclamacao\n";
		opcoesConsumidor = opcoesConsumidor + "6 - Filtrar Reclamacao\n";
		opcoesConsumidor = opcoesConsumidor + "7 - Editar Reclamacao\n";
		opcoesConsumidor = opcoesConsumidor + "8 - excluir conta";
		return opcoesConsumidor;
	}

// listagem
	private static String mostrarReclamacao(UsuarioEmpresa empresa) {
		System.out.println("Escreva o titulo da reclamacao que deseja ver: ");
		sc.nextLine();
		String titulo = sc.nextLine();
		for (int i = 0; i < empresa.getReclamacao().size(); i++) {
			if (empresa.getReclamacao().get(i).getTitulo().equals(titulo)) {
				return empresa.getReclamacao().get(i).exibirReclamacao();
			}
		}
		return "Reclamacao nao encontrada!";
	}

	private static String mostrarReclamacaoComsumidor(UsuarioConsumidor consumidor) {
		System.out.println("Escreva o titulo da reclamacao que deseja ver: ");
		sc.nextLine();
		String titulo = sc.nextLine();

		for (int i = 0; i < consumidor.getReclamacao().size(); i++) {
			if (consumidor.getReclamacao().get(i).getTitulo().equals(titulo)) {//
				return consumidor.getReclamacao().get(i).exibirReclamacao();
			}
		}
		return "Reclamacao nao encontrada!";
	}

// mudar dados
	private static boolean mudarDadoEmpresa(UsuarioEmpresa empresa) {
		System.out.println(empresa.exibirDados());
		System.out.println("Digite o valor correspondente ao dado que deseja mudar:" + "\n0 - Nao desejo mais editar!"
				+ "\n1 - Nome Fantasia" + "\n2 - Site" + "\n3 - Nome do responsavel" + "\n4 - Email do Responsavel"
				+ "\n5 - Email" + "\n6 - Endereco" + "\n7 - Senha");
		int option = -1;
		option = sc.nextInt();
		boolean result = false;
		switch (option) {
		case 0:
			break;
		case 1:
			System.out.println("Digite o novo nome:");
			sc.nextLine();
			String novoNome = sc.nextLine();
			empresa.setNome(novoNome);
			result = true;
			break;
		case 2:
			System.out.println("Digite o novo site:");
			sc.nextLine();
			String novoSite = sc.nextLine();
			empresa.setSite(novoSite);
			result = true;
			break;
		case 3:
			System.out.println("Digite o novo nome responsavel:");
			sc.nextLine();
			String novoResponsavel = sc.nextLine();
			empresa.setNomeResponsavel(novoResponsavel);
			result = true;
			break;
		case 4:
			System.out.println("Digite o novo email responsavel");
			sc.nextLine();
			String emailResponsavel = sc.nextLine();
			empresa.setEmailResponsavel(emailResponsavel);
			result = true;
			break;
		case 5:
			System.out.println("Digite o novo email:");
			sc.nextLine();
			String novoEmail = sc.nextLine();
			empresa.setEmail(novoEmail);
			result = true;
			break;
		case 6:
			System.out.println("Digite o novo endereco:");
			sc.nextLine();
			String novoEndereco = sc.nextLine();
			empresa.setEndereco(novoEndereco);
			result = true;
			break;
		case 7:
			System.out.println("Digite a nova senha:");
			sc.nextLine();
			String novaSenha = sc.nextLine();
			if (!(novaSenha.length() < 4 )&& !(novaSenha.length() > 8)) {
				empresa.setSenha(novaSenha);
				result = true;
			} else {
				result = false;
			}
			break;
		default:
			System.out.println("Opcao Invalida!");
		}
		return result;
	}

	private static boolean mudarDadoConsumidor(UsuarioConsumidor consumidor) {
		System.out.println(consumidor.exibirDados());
		System.out.println("Digite o valor correspondente ao dado que deseja mudar:" + "\n0 - Nao desejo mais editar!"
				+ "\n1 - Nome" + "\n2 - CPF" + "\n3 - Data de Nascimento" + "\n4 - Gênero" + "\n5 - Email"
				+ "\n6 - Endereco" + "\n7 - Senha" + "\n8 - Celular");
		int option = -1;
		option = sc.nextInt();
		boolean result = false;
		switch (option) {
		case 0:
			break;
		case 1:
			System.out.println("Digite o novo nome:");
			sc.nextLine();
			String novoNome = sc.nextLine();
			consumidor.setNome(novoNome);
			result = true;
			break;
		case 2:
			System.out.println("Digite o novo CPF:");
			sc.nextLine();
			String novoCpf = sc.nextLine();
			if (novoCpf.length() != 11) {
				result = false;
			} else {
				consumidor.setCpf(novoCpf);
				result = true;
			}
			break;
		case 3:
			System.out.println("Digite a nova data de nascimento:");
			sc.nextLine();
			String novaData = sc.nextLine();
			consumidor.setDataNascimento(novaData);
			result = true;
			break;
		case 4:
			System.out.println("Digite 'f' para Feminino,'m' para Masculino ou 'o' para outro:");
			sc.nextLine();
			String genero = sc.nextLine();
			char caractere = genero.charAt(0);
			if (!(caractere != 'm') && !(caractere != 'f') && !(caractere != 'o')) {
				consumidor.setGenero(caractere);
				result = true;
			} else {
				result = false;
			}
			break;
		case 5:
			System.out.println("Digite o novo email:");
			sc.nextLine();
			String novoEmail = sc.nextLine();
			consumidor.setEmail(novoEmail);
			result = true;
			break;
		case 6:
			System.out.println("Digite o novo endereco:");
			sc.nextLine();
			String novoEndereco = sc.nextLine();
			consumidor.setEndereco(novoEndereco);
			result = true;
			break;
		case 7:
			System.out.println("Digite a nova senha:");
			sc.nextLine();
			String novaSenha = sc.nextLine();
			if (!(novaSenha.length() < 4) && !(novaSenha.length() > 8)) {
				consumidor.setSenha(novaSenha);
				result = true;
			} else {
				result = false;
			}
			break;
		case 8:
			System.out.println("Digite o novo celular:");
			sc.nextLine();
			String celular = sc.nextLine();
			consumidor.setCelular(celular);
			result = true;
			break;
		default:
			System.out.println("Opcao Invalida!");
		}
		return result;
	}

	private static boolean mudarReclamacao(Reclamacao reclamacao) {
		System.out.println(reclamacao.exibirReclamacao());
		System.out.println("Digite o valor correspondente ao dado que deseja mudar:" + "\n0 - Nao desejo mais editar!"
				+ "\n1 - Titulo" + "\n2 - Descricao" + "\n3 - Celular" + "\n4 - Classificacao"
				+ "\n5 - Produto ou Servico" + "\n6 - Nota");
		int option = -1;
		option = sc.nextInt();
		boolean result = false;
		switch (option) {
		case 0:
			break;
		case 1:
			System.out.println("Digite o novo Titulo:");
			sc.nextLine();
			String novoTitulo = sc.nextLine();
			reclamacao.setTitulo(novoTitulo);
			;
			result = true;
			break;
		case 2:
			System.out.println("Digite a nova Descricao:");
			sc.nextLine();
			String novaDesc = sc.nextLine();
			reclamacao.setDescricao(novaDesc);
			result = true;
			break;
		case 3:
			System.out.println("Digite o novo Celular:");
			sc.nextLine();
			String novoCel = sc.nextLine();
			reclamacao.setCelular(novoCel);
			result = true;
			break;
		case 4:
			System.out.println("Digite a nova Classificacao:");
			sc.nextLine();
			String classificacao = sc.nextLine();
			reclamacao.setClassificacao(classificacao);
			;
			result = true;
			break;
		case 5:
			System.out.println("Digite o novo Produto ou Servico:");
			sc.nextLine();
			String prodOuServ = sc.nextLine();
			reclamacao.setProdutoOuServico(prodOuServ);
			;
			result = true;
			break;
		case 6:
			System.out.println("Digite a nova nota:");
			sc.nextLine();
			double novaNota = sc.nextDouble();
			reclamacao.setNota(novaNota);
			;
			result = true;
			break;
		default:
			System.out.println("Opcao Invalida!");
		}
		return result;
	}

	public static Reclamacao verificarExistenciaRec(String titulo, UsuarioConsumidor consumidor) {
		for (int i = 0; i < consumidor.getReclamacao().size(); i++) {
			if (consumidor.getReclamacao().get(i).getTitulo().equals(titulo)
					&& consumidor.getReclamacao().get(i).getStatus().equals("Pendente")) {
				return consumidor.getReclamacao().get(i);
			}
		}
		return null;
	}

// Criar Reclamação
	private static boolean criarReclamação(UsuarioConsumidor consumidor) {
		sc.nextLine();
		System.out.println("Digite o Nome da empresa:");
		String nomeEmpresa = sc.nextLine();
		System.out.println();
		System.out.println("Digite um titulo para a reclamacao:");
		String titulo = sc.nextLine();
		System.out.println();
		System.out.println("Digite a descricao da reclamacao:");
		String descricao = sc.nextLine();
		System.out.println();
		System.out.println("Digite um celular para contato:");
		String celular = sc.nextLine();
		System.out.println();
		System.out.println("Digite uma classificacao:");
		String classificao = sc.nextLine();
		System.out.println();
		System.out.println("Digite o produto ou servico:");
		String produtoOuServico = sc.nextLine();
		System.out.println();
		System.out.println("Digite uma nota (0-10):");
		String numero = sc.nextLine();
		System.out.println();
		double nota = Double.parseDouble(numero);
		Reclamacao reclamacao = new Reclamacao(nomeEmpresa, titulo, descricao, celular, classificao, produtoOuServico,
				"Pendente", nota, null, consumidor.getNome());
		if ((0 <= reclamacao.getNota()) && (reclamacao.getNota() <= 10)) {
			consumidor.getReclamacao().add(reclamacao);
			for (int i = 0; i < conta.getEmpresasExistentes().size(); i++) {
				if (conta.getEmpresasExistentes().get(i).getNome().equals(reclamacao.getNomeEmpresa())) {
					conta.getEmpresasExistentes().get(i).getReclamacao().add(reclamacao);
				}
			}
			return true;
		} else {
			return false;
		}
	}

}
