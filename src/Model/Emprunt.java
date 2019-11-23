package Model;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JList;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;


public class Emprunt {
	
	Livre livre;
	String datedeb;
	String datefin;
	private ArrayList<Emprunt> listEmprunt=new ArrayList<Emprunt>();

	public Emprunt(String nom,String createur , String debut, String fin) {
		// TODO Auto-generated constructor stub
		Livre livre= new Livre(nom, createur);
		this.livre=livre;
		this.datedeb=debut;
		this.datefin=fin;
	}
	public Emprunt() {

	}
	

	public Livre getlivre()
	{
		return this.livre;
	}
	
	public String getdatedebut()
	{
		return this.datedeb;
	}

	public String getdatefin()
	{
		return this.datefin;
	}
	public void addEmprunt(String nom,String createur, String datedeb, String datefin) {
		int i = listEmprunt.size()+1;
	
		Emprunt Emprunt=new Emprunt(nom, createur,datedeb,datefin);
		listEmprunt.add(Emprunt);
		
	}
	public void deleteEmprunt(int id) {
		
		listEmprunt.remove(id);
	}
	public void update(int row,String nom,String createur,String datedebut,String datefin) {
	Livre livre=new Livre(nom,createur);
	listEmprunt.get(row).livre=livre;
	listEmprunt.get(row).datedeb=datedebut;
	listEmprunt.get(row).datefin=datefin;
	}
	public void AfficheTab(DefaultTableModel model)
	{
		model.setRowCount(0);
		for(int i=0;i<listEmprunt.size();i++)
		{
			String nom=listEmprunt.get(i).livre.getNomDocument();
			String createur=listEmprunt.get(i).livre.getCreateurDocument();
			String livre=nom+" "+createur;
			Object[] obj= {livre,listEmprunt.get(i).getdatedebut(),listEmprunt.get(i).getdatefin()};
			model.addRow(obj);
		}
	}
	

}
