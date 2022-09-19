import java.util.ArrayList;
import java.util.Scanner;

public class executavel {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			ArrayList<conta> listaDeContas = new ArrayList<>();

			do {
				System.out.println("MENU" 
						+ "\n1 - Criar uma conta" 
						+ "\n2 - Excluir uma conta" 
						+ "\n3 - Editar uma conta"
						+ "\n4 - Selecionar uma conta" 
						+ "\n5 - Mostrar todas as contas"
						+ "\n6 - Sair");
				int escolha = sc.nextInt();

				switch (escolha) {
				case 1:
					System.out.print("Informe o nome do correntista: ");
					String nome = sc.next();
					System.out.println("Informe o CPF:");
					String CPF = sc.next();
					System.out.println("Informe o endereço:");
					String endereço = sc.next();
					System.out.println("Informe o profissão:");
					String profi = sc.next();
					listaDeContas.add(new conta(nome));
					break;
				case 2: {
					System.out.println("Qual o número da conta que deseja remover?");
					int contaEscolhida = sc.nextInt();
					for (int i = 0; i < listaDeContas.size(); i++) {
						if (contaEscolhida == listaDeContas.get(i).getNumConta()) {
							listaDeContas.remove(i);
							break;
						}
					}
					break;
				}
				case 3: {
					System.out.println("Qual o número da conta que deseja editar?");
					int contaEscolhida = sc.nextInt();
					System.out.print("Informe o nome do novo Cliente: ");
					String novoNome = sc.next();
					for (int i = 0; i < listaDeContas.size(); i++) {
						if (contaEscolhida == listaDeContas.get(i).getNumConta()) {
							listaDeContas.get(i).setNomeCorrentista(novoNome);
							break;
						}
					}
					break;
				}
				case 4: {
					System.out.println("Qual o número da conta" 
							+ "que deseja realizar uma operação?");
					int contaEscolhida = sc.nextInt();
					for (int i = 0; i < listaDeContas.size(); i++) {
						if (contaEscolhida == listaDeContas.get(i).getNumConta()) {
							int escolhaOperacao;
							do {
								System.out.println("MENU" 
										+ "\n1 - Depositar" 
										+ "\n2 - Sacar"
										+ "\n3 - Verificar Saldo" 
										+ "\n4 - Voltar");
								escolhaOperacao = sc.nextInt();
								switch (escolhaOperacao) {
								case 1: {
									System.out.print("Quanto você irá depositar?" 
											+ "\nR$ ");
									double valor = sc.nextDouble();
									listaDeContas.get(i).deposito(valor);
									break;
								}
								case 2: {
									System.out.print("Quanto você irá sacar?" 
											+ "\nR$ ");
									double valor = sc.nextDouble();
									listaDeContas.get(i).saque(valor);
									break;
								}
								case 3:
									System.out.println(listaDeContas.get(i).getInformacoes());
								}
							} while (escolhaOperacao != 4);
						}
					}
					break;
				}
				case 5:
					for (int i = 0; i < listaDeContas.size(); i++) {
						System.out.println(listaDeContas.get(i).getInformacoes());
					}
					break;
				case 6:
					System.exit(0);
				}
			} while (true);
		}
	}
}