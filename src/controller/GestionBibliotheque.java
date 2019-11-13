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
	
///
/// Cette fonction permet d'ajouter un document en fonction de son type, de son nom et de sa durée
///
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
	
// Cette fonction permet de modifier un document
	public void  modifierDoc(ArrayList<Document> doc, String typeDocument) {
			
		String new_name;
		String ID_en;
		int choice;
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel est le document que vous souhaiter modifier : (Taper l'ID) ");		
		ID_en = sc.nextLine();	
		findDocID(doc, ID_en);
		
		System.out.println("");
		System.out.println("Quel parametre voulez-vous modifier  : ");
		System.out.println("1 - nom du document");
		System.out.println("2 - createur");
		choice = sc.nextInt();	
		System.out.println("");
		
		
		switch (choice) {
		case 1:
			System.out.println("Quel est le nouveau nom du document :  ");
			sc.nextLine();
			new_name = sc.nextLine();
			
			for(int i = 0 ; i<doc.size();i++) {
				if(doc.get(i).getIdDocument().equals(ID_en)) {
					doc.get(i).setNomDocument(new_name);
					System.out.println("ID: "+doc.get(i).getIdDocument()+ ", Nom: "+doc.get(i).getNomDocument() +", Createur : "+ doc.get(i).getCreateurDocument());
				}
			}			
			break;
		case 2:
			System.out.println("Quel est le nouveau createur :  ");
			new_name = sc.next();
			for(int i = 0 ; i<doc.size();i++) {
				if(doc.get(i).getIdDocument().equals(ID_en)) {
					doc.get(i).setCreateurDocument(new_name);
					System.out.println("ID: "+doc.get(i).getIdDocument()+ ", Nom: "+doc.get(i).getNomDocument() +", Createur : "+ doc.get(i).getCreateurDocument());
				}
			}			
			break;
		default:
			System.out.println("commande non reconnue ");
			break;
		} 
	}
	
// Parcourir document en fonction du type
	public void parcourirDoc(ArrayList<Document> doc, String typeDocument) {
		for(int i = 0 ; i<doc.size();i++) {
			if(doc.get(i).getTypeDocument().equals(typeDocument))
				System.out.println("ID: "+doc.get(i).getIdDocument()+ " Nom: "+doc.get(i).getNomDocument());
		}
	}
	
// Parcourir les documents et les retrouver en fonction de l'ID	
	public void findDocID(ArrayList<Document> doc, String ID) {
		for(int i = 0 ; i<doc.size();i++) {
			if(doc.get(i).getIdDocument().equals(ID))
				System.out.println("ID: "+doc.get(i).getIdDocument()+ ", Nom: "+doc.get(i).getNomDocument() +", Createur : "+ doc.get(i).getCreateurDocument());
		}
	}
	
	public void afficherAll(ArrayList<Document> doc) {
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
	
	// Suppression d'un document
	public void supprimerDoc(ArrayList<Document> doc) {
		String idSuppression;
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel est le document que vous souhaiter supprimer:(Taper l'ID) ");
		idSuppression = sc.nextLine();
		for(int i = 0; i<doc.size();i++) {
			if(doc.get(i).getIdDocument().equals(idSuppression))
				doc.remove(i);
		}
		
	}
	
			
// GETTER	
	public ArrayList<Document> getDocument(){
		return this._documents;
	}
// Setter
	
}
	
		
	

