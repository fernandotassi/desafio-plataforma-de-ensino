package application;

import java.util.*;
import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args)
	{
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		List<Lesson> lista = new ArrayList<>();
		int i, n;
		System.out.println();
		System.out.print("Quantas aulas tem o curso? ");
		n = scan.nextInt();
		for(i = 0; i < n; i++)
		{
			System.out.println("Dados da " + (i + 1) + "ª aula: ");
			System.out.print("Conteúdo ou tarefa(c/t): ");
			scan.nextLine();
			Character tipo = scan.nextLine().charAt(0);
			System.out.print("Titúlo: ");
			String title = scan.nextLine();
			if(tipo.equals('c'))
			{	
			    System.out.print("Url do vídeo: ");
			    String url = scan.nextLine();
			    System.out.print("Duração em segundos: ");
			    int seconds = scan.nextInt();
			    lista.add(new Video(title, url, seconds));	
			}
			else if(tipo.equals('t'))
			{	
			    System.out.print("Descrição: ");
			    String description = scan.nextLine();
			    System.out.print("Quantidade de questões: ");
			    int questionCount = scan.nextInt();
			    lista.add(new Task(title, description, questionCount));	
			}
		}
		System.out.println();
		int tempoAulas = 0;
		for(Lesson lesson: lista)
		    tempoAulas += lesson.duration();
		
		System.out.println("DURAÇÂO TOTAL DO CURSO = " + tempoAulas + " segundos");
		
		scan.close();
	}

}
