package controller;
import java.util.ArrayList;
import java.util.*;


import model.Livre;
import model.*;

public class GestionBibliotheque {
	private ArrayList<Document> _documents;
	int idLivre = 0;
	boolean quitter = false;
	
	public GestionBibliotheque() {
		_documents = new ArrayList<Document>();
		
		
	}
	
	public void gestionBibliotheque() {
		
		while(quitter == false) {
			
			_documents.add(new Livre("Nom","Auteur",1));
			//if(_documents.get(0) instanceof Livre) {
			//	System.out.println("Coucou je suis un livre");
			//}
				
			for(int i = 0; i<_documents.size();i++) {
				System.out.println("On affire le livre n°"+(i+1));
				System.out.println(_documents.get(i).getNomDocument());
				System.out.println(_documents.get(i).getCreateurDocument());
				System.out.println();
			}
			
		}
	}
	
	public void ajouterDoc(ArrayList<Document> doc, String typeDoc) {
		String nom,auteur;
		int duree;
		Scanner sc = new Scanner(System.in);
		switch(typeDoc) {
			case "Livre":
				System.out.println("Quel est le nom de votre livre:");
				nom = sc.next();
				System.out.println("Qui est l'auteur de votre livre:");
				auteur = sc.next();
				System.out.println("Combien de page fait votre livre:");
				duree = sc.nextInt();
				doc.add(new Livre(nom,auteur,duree));
				break;
			case "CD":
				System.out.println("Quel est le nom de l'album:");
				nom = sc.next();
				System.out.println("Qui est le chanteur :");
				auteur = sc.next();
				doc.add(new CD(nom,auteur));
				break;
				
			case "DVD":
				System.out.println("Quel est le nom du film:");
				nom = sc.next();
				System.out.println("Qui est le réalisateur de votre film:");
				auteur = sc.next();
				doc.add(new DVD(nom,auteur));
				break;
			
		}
				
	}
}
// Supprimer un document Modifier un document Emprunt d'un document Terminer le fait d'ajouter un document 
// interface graphique 
// ID qui se fait automatiquement
	
		
	

