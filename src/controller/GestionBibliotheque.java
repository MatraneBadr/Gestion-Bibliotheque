package controller;
import java.util.ArrayList;
import java.util.*;


import model.Livre;
import model.*;

public class GestionBibliotheque {
	private ArrayList<Document> _documents;
	
	public GestionBibliotheque() {
		_documents = new ArrayList<Document>();
		
		
	}
	
// Méthode de gestion de bibliotheque	
	public void gestionBibliotheque() {
		
	}

	public void ajouterDoc(ArrayList<Document> doc, String typeDoc, String nomDoc, String auteurDoc, int dureeDoc) {
		String id;
		int i = doc.size()+1;
		switch(typeDoc) {
			case "Livre":
				id = "L"+i;
				_documents.add(new Livre(id,nomDoc,auteurDoc,dureeDoc));
				break;
			case "CD":
				id ="C"+i;
				_documents.add(new CD(id,nomDoc,auteurDoc,dureeDoc));
				break;
			case "DVD":
				id = "D"+i;
				_documents.add(new DVD(id,nomDoc,auteurDoc,dureeDoc));
				break;
			default:
				System.out.println("Pas compris");
				break;
		}
		
	}
	
	public void parcourirDoc(ArrayList<Document> doc, String typeDocument) {
		for(int i = 0 ; i<doc.size();i++) {
			if(doc.get(i).getTypeDocument().equals(typeDocument))
				System.out.println("ID: "+doc.get(i).getIdDocument()+ " Nom: "+doc.get(i).getNomDocument());
		}
	}
	
	public void parcourirAll(ArrayList<Document> doc) {
		for(int i = 0 ; i<doc.size();i++) {
			System.out.println("ID: "+doc.get(i).getIdDocument()+ " Nom: "+doc.get(i).getNomDocument());
		}
	}
	
	public void remplirList(ArrayList<Document> doc) {
		for(int i = 0 ; i<10 ; i++) {
			doc.add(new Livre("L"+i,"NomLivre"+i,"AuteurLivre"+i,1));
			doc.add(new CD("C"+i,"NomCd"+i,"AuteurCD"+i,1));
			doc.add(new DVD("D"+i,"NomDVD"+i,"AuteurDVD"+i,1));
			
		}
	}
	
	public void supprimerDoc(ArrayList<Document> doc) {
		String index;
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel est le document que vous souhaiter supprimer:(Taper l'ID) ");
		index = sc.nextLine();
		for(int i = 0; i<doc.size();i++) {
			if(doc.get(i).getIdDocument().equals(index))
				doc.remove(i);
		}
		
	}
			
// GETTER	
	public ArrayList<Document> getDocument(){
		return this._documents;
	}
// Setter
	
}
	
		
	

