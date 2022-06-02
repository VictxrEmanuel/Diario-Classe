package NotasClasse;

import java.util.Scanner;

public class DiarioIndidual {
	
	static Scanner console = new Scanner(System.in);
	
	static byte opcao = 0;
	static final int Total_Avaliacoes = 3;
	static final String[] Nomes_av = {"A1","A2","A3"};
	static final double[] Nota_Max = {30,30,40};
	
	static double[] notas = new double[Total_Avaliacoes];
	static double lerNota(String mensagem, double notaMaxima) {
		
		double nota = 0.0;
		
		do {
			
			System.out.printf("%s = ", mensagem);
			nota = console.nextDouble();
			
		} while (nota< 0.00 || nota> notaMaxima);
		return nota;
	}
	static void atualizarNota(int indiceNota) {
		
		System.out.println();
		notas[indiceNota] = lerNota(Nomes_av[indiceNota],Nota_Max[indiceNota]);
	}
	/*
	static void avaliarSituacao(double notaFinal) {
		if (notaFinal< 30) {
			System.out.println("Reprovado");;
		}else {
			if (notaFinal< 70) {
				System.out.println("Em recuperação");
				
				
			}else {
				System.out.println("Aprovado");
			}
			
		}
	}
	*/
	static String avaliarSituação(double notaFinal) {
		if(notaFinal < 30) {
			return "Reprovado";
		}else {
			if (notaFinal< 70) {
				return "Em recuperação";
				
				
			}else {
				return "Aprovado";
			}
			
		}
	}
	
	static void mostrarNotas() {
		double notaFinal = 0.0;
		
		System.out.println("\n\t\tNotas");
		System.out.println();
		
		for (int i = 0; i < Total_Avaliacoes; i++) {
			
			System.out.printf("Avaliação %s = %.2f pts", Nomes_av[i], notas[i]);
			System.out.println();
			notaFinal += notas[i];
			
		}
		
		System.out.printf("\n Nota Final = %.2f pts", notaFinal);
		System.out.printf("\n   Situação = %s",avaliarSituação(notaFinal));
		calcularMedia();
		System.out.printf("\n Sua média é: %.2f pts", media);
		if (media <24) {
			avaliacaoRec();
		}
		System.out.println();
		
		
			
		
	}
	
	static void cadastroNota() {
		for (int i = 0; i < Total_Avaliacoes; i++) {
			
		

		System.out.println("Qual prova você quer cadastrar?");
		System.out.println("[1] A1");
		System.out.println("[2] A2");
		System.out.println("[3] A3");
		System.out.println("[4] Voltar pro Menu");
		System.out.println("[5] Sair do programa");
		System.out.print("Opção: ");
		opcao = console.nextByte();
		
		switch (opcao) {
			case 1:
				atualizarNota(0);
				break;
			case 2:
				atualizarNota(1);
				break;
			case 3:
				atualizarNota(2);
				break;
			case 4:
				mostrarMenu();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println();
				System.err.println("Errou");
				cadastroNota();
				break;
		 }
		}
			
	}
	static double media = 0;
	static void calcularMedia() {
		
		for (int i = 0; i < Total_Avaliacoes; i++) {
			media = media + notas[i]; 
			
		}
		media = media/3;
	}
	
	static void maiorNota() {
		if (notas[0]>notas[1]&&notas[0]>notas[2]) {
			System.out.printf("Sua Maior Nota foi na A1! e foi %.2f pts", notas[0]);
		}else {
			if (notas[1]>notas[2]&&notas[1]>notas[0]) {
				System.out.printf("Sua Maior Nota foi na A2! e foi %.2f pts", notas[1]);
			}else {
				if (notas[2]>notas[0]&&notas[2]>notas[1]){
					System.out.printf("Sua Maior Nota foi na A3! e foi %.2f pts", notas[2]);
				}else {
					if (notas[0]==notas[1]&&notas[0]>notas[2]) {
						System.out.printf("Suas notas da A1 e da A2 foram iguais e são as maiores! e foram %.2f",notas[0]);
					}else {
						if (notas[1]==notas[2]&&notas[1]>notas[0]) {
							System.out.printf("Suas notas da A2 e da A3 foram iguais e são as maiores! e foram %.2f", notas[1]);
						}else {
							if (notas[2]==notas[0]&&notas[2]>notas[1]) {
								System.out.printf("Suas notas da A3 e da A1 foram iguais e são as maiores! e foram %.2f", notas[2]);
							}
						}
					}
				}
			}
		}
	}
	static double menorNota = Double.MAX_VALUE;
	static double ai = 0.0;
	static void indiceMenorNota() {
		
		
		for (int i = 0; i < notas.length; i++) {
			if (notas[i]< menorNota) {
				
				menorNota = notas[i];
			}
		}
	}
	
	static void avaliacaoRec() {
		System.out.println();
		System.out.println("Sua menor nota foi: "+ menorNota);
		System.out.println("Nota da sua AI: ");
		ai = console.nextDouble();
		if (ai > notas[0]&& ai <= notas[1]&& ai < notas[2]) {
			notas[0]=ai;	
		}else {
			if (ai > notas[1]&& ai < notas[0]&& ai < notas[2]) {
				notas[1]=ai;	
			}
		}
		System.out.println("Suas notas ficaram assim: ");
		mostrarNotas();
		
		
		
	}
	static void mostrarMenu() {
		
		
		System.out.println();
		System.out.println("\t   Menu");
		System.out.println("[1] Cadastrar Notas");
		System.out.println("[2] Mostrar Notas");
		System.out.println("[3] Calcular média");
		System.out.println("[4] Maior nota");
		System.out.println("[5] Sair do programa");
		System.out.print("Opção:");
		opcao = console.nextByte();
		
		switch (opcao) {
		case 1:
			cadastroNota();
			break;
		case 2:
			mostrarNotas();
			break;
		case 3:
			calcularMedia();
			System.out.printf("Sua média é: %.2f", media);
			break;
		case 4:
			maiorNota();
			break;
		case 5:
			System.exit(0);
			System.err.println("Fim do programa!");
			break;
		default:
			mostrarMenu();
			break;
		}
		mostrarMenu();
	}
	
	public static void main(String[] args) {
		
		mostrarMenu();
	}

}
