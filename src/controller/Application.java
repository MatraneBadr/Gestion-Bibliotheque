package controller;

import java.util.Scanner;


public class Application {
	private GestionBibliotheque gest;
	
	// Création automatique d'un objet Gestion bibliothèque
	public Application() {
		gest = new GestionBibliotheque();
		gest.remplirList(gest.getDocument());
		
	}
	
	public void lancementApplication() {
		
		travailSur();
			
	}
	
	public void travailSur() {
		
		operationCourante();
				
	}
	// l'USER choisi ce qu'il veut faire
	public void operationCourante() {
		int choice;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bonjour bienvenue dans le logiciel de gestion de bibliothèque. Sur quoi souhaitez vous travailler?");
		System.out.println("LISTE DES DOCUMENTS ENREGISTRE");
		gest.afficherAll(gest.getDocument());
		System.out.println("------FIN------");
		System.out.println("1 - Livres");
		System.out.println("2 - CD's");
		System.out.println("3 - DVD's");
		choice = sc.nextInt();
		switch(choice) {
			case 1:
				choixCRUD("Livre");
				break;
			case 2:
				choixCRUD("CD");
				break;
			case 3:
				choixCRUD("DVD");
				break;
			default:
				System.out.println("Commande inconnue");
				break;
		
		}
	}
	
	// Choix CRUD oriente l'utilisateur
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
				 sc.nextLine();
				 nomDocument = sc.nextLine();
				 System.out.println("Qui est l'auteur de votre "+typeTravail);
				 auteurDocument = sc.nextLine();
				 if(typeTravail == "Livre")
					 System.out.println("Quel est le nombre de page de votre "+typeTravail);
				 else
					 System.out.println("Quel est la durée de votre "+typeTravail);
				 dureeDocument = sc.nextInt();
				 gest.ajouterDoc(gest.getDocument(), typeTravail, nomDocument, auteurDocument, dureeDocument);
				 break;
			case 2:
				gest.parcourirDoc(gest.getDocument(), typeTravail);
				gest.supprimerDoc(gest.getDocument());
				 break;
			case 3:
				gest.parcourirDoc(gest.getDocument(), typeTravail);
				gest.modifierDoc(gest.getDocument(),typeTravail);
				break;
		 
		}
		gest.afficherAll(gest.getDocument());	
	}
	

}
