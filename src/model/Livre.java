package Model;

import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.table.DefaultTableModel;

//import model.Document;



public class Livre extends Document {
	private Livre livre;
	private int _nombrePages;
	private ArrayList<Livre> listLivre=new ArrayList<Livre>();
	private ArrayList<Livre> listLivre1=new ArrayList<Livre>();
	private int index;
	
		public Livre()
		{}

	public Livre(String id,String nomDocument, String createurDocument,int nombrePages ) {
		super(id,nomDocument, createurDocument,"Livre");
		_nombrePages = nombrePages;
		// TODO Auto-generated constructor stub
	}


	@Override
	public String getNomDocument() {
		// TODO Auto-generated method stub
		return _nomDocument;
	}

	@Override
	public String getCreateurDocument() {
		// TODO Auto-generated method stub
		return _createurDocument;
	}

	@Override
	public void setNomDocument(String nomDocument) {
		// TODO Auto-generated method stub
		this._nomDocument = nomDocument;
		
		
	}

	@Override
	public void setCreateurDocument(String createurDocument) {
		// TODO Auto-generated method stub
		this._createurDocument = createurDocument;
		
	}

	public int getNombrePages() {
		return _nombrePages;
	}

	public void setNombrePages(int nombrePages) {
		this._nombrePages = nombrePages;
	}


	@Override
	public String getIdDocument() {
		// TODO Auto-generated method stub
		return _idDocument;
	}


	@Override
	public String getTypeDocument() {
		// TODO Auto-generated method stub
		return "Livre";
	}
	public ArrayList<Livre> getListelivre() {
		return listLivre;
	}

	public void setListlivre(ArrayList<Livre> listLivre) {
		this.listLivre = listLivre;
	}

	public void deleteLivre(int id) {
	
			listLivre.remove(id);
	}
	public void update(int row,String nomdoc,String nomAut,int nbPage) {
		
		listLivre.get(row)._nomDocument=nomdoc;
		listLivre.get(row)._createurDocument=nomAut;
		listLivre.get(row)._nombrePages=nbPage;
}

/*
	public boolean searchLivre(String[] searchIntred) {
		for (String obj : searchIntred) {
			if (!listLivre.contains(obj)) {
				return false;
			} else {
				index = listLivre.indexOf(obj);
				setLivre(listLivre.get(index));
				break;
			}
		}
		return true;

	}
*/
	public void addLivre(String nomDoc, String createurDoc, int nombreP) {
		int i = listLivre.size()+1;
	
		
		String id="L"+i;
		Livre livre1=new Livre(id, nomDoc, createurDoc,nombreP);
		listLivre.add(livre1);
		
	}
	public Livre getLivre() {
		return livre;
	}
	
	public int sizeList()
	{
		return listLivre.size();
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}
	public void AfficheTab(DefaultTableModel model)
	{
		model.setRowCount(0);
		for(int i=0;i<listLivre.size();i++)
		{
			Object[] obj= {listLivre.get(i).getCreateurDocument(),listLivre.get(i).getNomDocument(),listLivre.get(i).getNombrePages()};
			model.addRow(obj);
		}
	}
	public int searchLivre(String nom)
	{
		int p=0;
	
		for(int i=0;i<listLivre.size();i++)
		{
			System.out.println(listLivre.get(i).getNomDocument());
			
			if(listLivre.get(i).getNomDocument().equals(nom))
			{p=i;}
			System.out.println(p);
		}
		return p;
	}
	public void afficheresultatSearch(int i,DefaultTableModel model)
	{
		model.getDataVector().clear();
		Object[] obj= {listLivre.get(i).getCreateurDocument(),listLivre.get(i).getNomDocument(),listLivre.get(i).getNombrePages()};
		model.addRow(obj);
	}
	
}
