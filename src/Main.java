import controller.GestionBibliotheque;
import controller.Application;

public class Main {
	
	
	public static void main(String [] args) {

		//Application app = new Application();
		
		//app.lancementApplication();
		GestionBibliotheque gest = new GestionBibliotheque();
		gest.remplirList(gest.getDocument());
		gest.parcourirDoc(gest.getDocument(), "CD");
		
		
		
		
		
	}

}
