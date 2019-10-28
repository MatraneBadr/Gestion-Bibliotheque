package controller;
import java.util.ArrayList;
import java.util.*;


import model.Livre;
import model.*;

public class GestionBibliotheque {
	private ArrayList<Document> _documents;
	private int _choice;
	int idLivre = 0;
	boolean quitter = false;
	
	public GestionBibliotheque() {
		_documents = new ArrayList<Document>();
		
		
	}
	
	public void gestionBibliotheque() {
		
		while(quitter == false) {
			System.out.println("Bonjour bienvenue dans le logiciel de gestion de bibliothèque. Que voulez vous faire ?");
			System.out.println("1 - Ajouter un livre");
			System.out.println("2 - Ajouter un cd");
			System.out.println("3 - Ajouter un DVD");
			
			Scanner sc = new Scanner(System.in);
			_choice = sc.nextInt();
			
			_documents.add(new Livre(1,"Nom","Auteur",1));
			if(_documents.get(0) instanceof Livre) {
				System.out.println("Coucou je suis un livre");
			}
				
			for(int i = 0; i<_documents.size();i++) {
				System.out.println("On affire le livre n°"+(i+1));
				System.out.println(_documents.get(i).getNomDocument());
				System.out.println(_documents.get(i).getCreateurDocument());
				System.out.println();
			}
			
			System.out.println("Voulez vous quitter ?");
			_choice = sc.nextInt();
			if(_choice >= 1)
				quitter = true;
		}
	}
	
	public void ajouterDoc(ArrayList<Document> _doc, String typeDoc) {
		switch(typeDoc) {
			case "Livre":
				System.out.println("Quel est le nom de votre livre:");
				System.out.println("Qui est l'auteur de votre livre:");
				System.out.println("Combien de page fait votre livre:");
				_doc.add(new Livre(1,"Nom","Auteur",1));
				break;
			case "CD":
				System.out.println("Quel est le nom de l'album:");
				System.out.println("Qui est le chanteur :");
				_doc.add(new CD(1,"nomAlbum","nomChanteur"));
				break;
				
			case "DVD":
				System.out.println("Quel est le nom du film:");
				System.out.println("Qui est le réalisateur de votre film:");
				_doc.add(new DVD(1,"nomFilm","Realisateur"));
			
		}
				
	}
}
	
		
	

