package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Comment;
import entities.Post;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		//Instancia um SimpleDateFormat para ter informação do horário dos posts
		//Scanner para ler informações do usuário
		//Os posts são armazenados em uma lista
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Scanner sc = new Scanner(System.in);
		List<Post> posts = new ArrayList<>();
		
		//Dois posts e dois comentários em cada post instanciados manualmente para o programa não começar vazio
		
		Post p1 = new Post(sdf.parse("27/06/2023 13:15:45"), "Prova amanhã", "Tenho uma prova amanhã cedo", 5, 1);
		
		Comment c1 = new Comment("Faça uma boa prova!");
		Comment c2 = new Comment("Boa sorte!");
		
		p1.addComment(c1);
		p1.addComment(c2);
		
		Post p2 = new Post(sdf.parse("28/06/2023 22:30:26"), "Boa noite galera", "Vejo vocês no laboratório amanhã cedo", 3, 2);
		
		Comment c3 = new Comment("Boa noite");
		Comment c4 = new Comment("Até amanhã");
		
		p2.addComment(c3);
		p2.addComment(c4);
		
		posts.add(p1);
		posts.add(p2);
		
		int x;
		int n = 3;
		System.out.println("Seja bem vindo(a)");
		System.out.println("Selecione o que deseja fazer:\n"
						  + "1 - Ver posts (apenas os títulos)\n"
						  + "2 - Acessar post por índice\n"
						  + "3 - Criar um post\n"
						  + "0 - Finalizar o programa\n");
		System.out.print("Digite sua resposta: ");
		x = sc.nextInt();
		
		while(x != 0) {
			
			switch(x) {
			//Ver posts:
			case 1:
				System.out.println("\nLista de posts:");
				for(Post p : posts) {
					System.out.println(p.getIndex() + " - " + p.getTitle());
				}
				System.out.println();
				break;
			//Acessar um post específico:
			case 2:
				System.out.println("Acessar post por índice\n");
				System.out.print("Qual post quer acessar: ");
				int verificador = 0;
				int i = sc.nextInt();
				for(Post p : posts) {
					if(p.getIndex() == i) {
						System.out.println(p);
						verificador = 1;
					}
				}
				if(verificador == 0) {
					System.out.println("Post não encontrado\n");
				}else {
					System.out.println("Selecione o que deseja fazer:\n"
							  + "1 - Curtir post\n"
							  + "2 - Comentar post\n"
							  + "0 - Sair do post\n");
					System.out.print("Digite sua resposta: ");
					int c = sc.nextInt();
					if(c == 1) {
						for(Post p : posts) {
							if(p.getIndex() == i) {
								p.like();
								System.out.println("Você curtiu esse post\n");
							}
						}
					}else if(c == 2) {
						for(Post p : posts) {
							if(p.getIndex() == i) {
								System.out.print("Comentário: ");
								sc.nextLine();
								String cmtr = sc.nextLine();
								Comment coment = new Comment(cmtr);
								p.addComment(coment);
								System.out.println("Seu comentário foi adicionado ao post\n");
							}
						}
					}else if(c != 1 && c != 2 && c!= 0) {
						System.out.println("Comando inválido\n");
					}else {
						System.out.println();
					}
				}
				break;
			//Criar um post:
			case 3:
				
				Instant data = Instant.now();
				Date instante = Date.from(data);
				String titulo;
				String conteudo;
				
				sc.nextLine();
				System.out.print("Título: ");
				titulo = sc.nextLine();
				System.out.print("Conteudo: ");
				conteudo = sc.nextLine();
				
				
				Post p = new Post(instante, titulo, conteudo, 0, n);
				System.out.println(p);
				posts.add(p);
				n++;
				break;
			//Finalizar o programa:
			case 0:
				break;
			//Usuário digita outra opção:
			default:
				System.out.println("Comando inválido\n");
				break;
			}
			
			System.out.println("Selecione o que deseja fazer:\n"
							  + "1 - Ver posts\n"
							  + "2 - Acessar post por índice\n"
							  + "3 - Criar um post\n"
							  + "0 - Finalizar o programa\n");
			System.out.print("Digite sua resposta: ");
			x = sc.nextInt();
		}
		
		System.out.println("Programa finalizado\n");
	
		sc.close();
	}
}