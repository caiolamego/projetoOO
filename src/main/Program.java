package main;

import java.util.Scanner;

import negocio.Conta;
import negocio.UsuarioConsumidor;
import negocio.UsuarioEmpresa;

public class Program {

	private static Conta conta = new Conta();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		conta.preencherDados();
		int op = -1;

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
				boolean loginEmp = loginEmpresa();
				if (loginEmp == true) {
					op = 0;
					break;
				} else {
					System.out.println("CNPJ e/ou Senha incorreto(s)!");
					System.out.println("Deseja retornar ao menu (y/n)?");
					if (sc.next().charAt(0) == 'y') {
						break;
					} else {
						op = 0;
						System.out.println("O sistema sera encerrado!");
						break;
					}
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
		UsuarioEmpresa empresa = new UsuarioEmpresa(nome, endereco, email, senha, null, nomeComercial, cnpj, site,
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

	public static boolean loginEmpresa() {
		Scanner sc = new Scanner(System.in);

		System.out.print("CNPJ (apenas os 14 digitos): ");
		String cnpjLogin = sc.nextLine();

		System.out.print("Senha: ");
		String senhaLogin = sc.nextLine();

		for (UsuarioEmpresa empresa : conta.getEmpresasExistentes()) {
			if (cnpjLogin.equals(empresa.getCnpj()) && senhaLogin.equals(empresa.getSenha())) {

				return true;
			}
		}
		return false;
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

}
