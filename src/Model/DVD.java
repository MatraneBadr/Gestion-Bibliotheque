package Model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
 
public class DVD  extends Document{
	private DVD dvd;
	private float _duree;
	private ArrayList<DVD> listdvd=new ArrayList<DVD>();
	
	private int index;
	
		public DVD()
		{}

	public DVD(String id,String nomDocument, String createurDocument,float duree ) {
		super(id,nomDocument, createurDocument,"DVD");
		_duree = duree;
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

	public float getDuree() {
		return _duree;
	}

	public void setDuree(float duree) {
		this._duree = duree;
	}


	@Override
	public String getIdDocument() {
		// TODO Auto-generated method stub
		return _idDocument;
	}


	@Override
	public String getTypeDocument() {
		// TODO Auto-generated method stub
		return "DVD";
	}
	public ArrayList<DVD> getListedvd() {
		return listdvd;
	}

	public void setListdvd(ArrayList<DVD> listdvd) {
		this.listdvd = listdvd;
	}

	public void deletedvd(int id) {
	
		listdvd.remove(id);
	}
	public void update(int row,String nomdoc,String nomAut,float duree) {
		
		listdvd.get(row)._nomDocument=nomdoc;
		listdvd.get(row)._createurDocument=nomAut;
		listdvd.get(row)._duree=duree;
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
	public void adddvd(String nomDoc, String createurDoc, float duree) {
		int i = listdvd.size()+1;
	
		
		String id="L"+i;
		DVD dvd1=new DVD(id, nomDoc, createurDoc,duree);
		listdvd.add(dvd1);
		
	}
	public DVD getdvd() {
		return dvd;
	}
	
	public int sizeList()
	{
		return listdvd.size();
	}

	public void setdvd(DVD dvd) {
		this.dvd = dvd;
	}
	public void AfficheTab(DefaultTableModel model)
	{
		model.setRowCount(0);
		for(int i=0;i<listdvd.size();i++)
		{
			Object[] obj= {listdvd.get(i).getCreateurDocument(),listdvd.get(i).getNomDocument(),listdvd.get(i).getDuree()};
			model.addRow(obj);
		}
	}
	
	
}
