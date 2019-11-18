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
	
// Modification d'un document
	public void  modifierDoc(ArrayList<Document> doc, String typeDocument) {
			
		String newName;
		String idModification;
		int choice;
		int newDuree;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quel est le document que vous souhaiter modifier : (Taper l'ID) ");		
		idModification = sc.nextLine();	
		findDocID(doc, idModification);
		
		System.out.println();
		System.out.println("Quel parametre voulez-vous modifier  : ");
		System.out.println("1 - Le nom du document");
		System.out.println("2 - Le créateur du document");
		System.out.println("3 - Le nombre de page");
		choice = sc.nextInt();	
		System.out.println("");
		
		
		switch (choice) {
		case 1:
			System.out.println("Quel est le nouveau nom du document :  ");
			sc.nextLine();
			newName = sc.nextLine();
			
			for(int i = 0 ; i<doc.size();i++) {
				if(doc.get(i).getIdDocument().equals(idModification)) {
					doc.get(i).setNomDocument(newName);
					System.out.println("ID: "+doc.get(i).getIdDocument()+ ", Nom: "+doc.get(i).getNomDocument() +", Createur : "+ doc.get(i).getCreateurDocument());
				}
			}			
			break;
		case 2:
			System.out.println("Quel est le nouveau createur :  ");
			newName = sc.nextLine();
			for(int i = 0 ; i<doc.size();i++) {
				if(doc.get(i).getIdDocument().equals(idModification)) {
					doc.get(i).setCreateurDocument(newName);
					System.out.println("ID: "+doc.get(i).getIdDocument()+ ", Nom: "+doc.get(i).getNomDocument() +", Createur : "+ doc.get(i).getCreateurDocument());
				}
			}			
			break;
		case 3:
			System.out.println("Quel est le nombre de page de votre document ? ");
			newDuree = sc.nextInt();
			for(int i = 0 ; i<doc.size();i++) {
				if(doc.get(i).getIdDocument().equals(idModification)) {
					doc.get(i).setDureeDocument(newDuree);
					System.out.println("ID: "+doc.get(i).getIdDocument()+ ", Nom: "+doc.get(i).getNomDocument() +", Createur : "+ doc.get(i).getCreateurDocument()+
							", Durée:"+doc.get(i).getDureeDocument());
				}
			}
			break;
		default:
			System.out.println("commande non reconnue ");
			break;
		} 
	}
	
// Parcourir documents en fonction du type
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
	
// Affichage de tout les document
	public void afficherAll(ArrayList<Document> doc) {
		for(int i = 0 ; i<doc.size();i++) {
			System.out.println("ID: "+doc.get(i).getIdDocument()+ " Nom: "+doc.get(i).getNomDocument()+ 
					" Durée du Document "+doc.get(i).getDureeDocument());
		}
	}
	
// Permet de remplir notre programme avec des documents à son lancement
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
	
		
	

