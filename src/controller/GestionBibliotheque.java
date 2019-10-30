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
		
	}
	
	public void ajouterDoc(ArrayList<Document> doc, String typeTravail, String nomDoc, String auteurDoc, int dureeDoc) {
		switch(typeTravail) {
			case "livre":
				_documents.add(new Livre(nomDoc,auteurDoc,dureeDoc));
				break;
			case "CD":
				_documents.add(new CD(nomDoc,auteurDoc));
				break;
			case "DVD":
				_documents.add(new DVD(nomDoc,auteurDoc));
				break;
			default:
				System.out.println("Pas compris");
				break;
		}
			
				
	}
	
	public ArrayList<Document> getDocument(){
		return this._documents;
	}
}
	
		
	

