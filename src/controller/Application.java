package controller;

import java.util.Scanner;

import View.MenuAdmin;

public class Application {
	private String _choice;
	
	public Application() {
		
	}
	
	public void lancementApplication() {
		/*
		_choice = travailSur();
		
		switch(_choice) {
			case "livre":
				choixCRUD(_choice);
				break;
			case "CD":
				choixCRUD(_choice);
				break;
			case "DVD":
				choixCRUD(_choice);
				break;
			default:
				System.out.println("Je n'ai pas compris");
				break;
			
		}*/
		MenuAdmin menu=new MenuAdmin();
		menu.setVisible(true);
	}
	
	public void choixCRUD(String typeTravail) {
		int choice;
		String nomDocument,auteurDocument;
		int dureeDocument;
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Que voulez vous faire ?");
		System.out.println("1 - Ajouter un "+typeTravail);
		System.out.println("2 - Supprimer un "+typeTravail);
		System.out.println("3 - Modifier un "+typeTravail);
		choice = sc.nextInt();
		switch(choice) {
			case 1:
				 System.out.println("Quel est le nom de votre "+typeTravail);
				 nomDocument = sc.next();
				 System.out.println("Qui est l'auteur de votre "+typeTravail);
				 auteurDocument = sc.next();
				 System.out.println("Quel est la durée de votre "+typeTravail);
				 dureeDocument = sc.nextInt();
				 break;
			case 2:
				 System.out.println("Quel est le "+typeTravail+"que vous souhaitez supprimer?");
				 break;
			case 3:
				System.out.println("Quel est le "+typeTravail+" que vous voulez modifier");
				break;
		 
		}
				
		
	}
	
	public String travailSur() {
		int choice;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bonjour bienvenue dans le logiciel de gestion de bibliothèque. Sur quoi souhaitez vous travailler?");
		System.out.println("1 - Livres");
		System.out.println("2 - CD's");
		System.out.println("3 - DVD's");
		choice = sc.nextInt();
		switch(choice) {
			case 1:
				return "livre";
			case 2:
				return "CD";
			case 3:
				return "DVD";
			default:
				return "";
				
		}
	}

}
