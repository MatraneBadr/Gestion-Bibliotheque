package model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
 
public class CD  extends Document{
	private CD cd;
	private float _duree;
	private ArrayList<CD> listcd=new ArrayList<CD>();
	
	private int index;
	
		public CD()
		{}

	public CD(String id,String nomDocument, String createurDocument,float duree ) {
		super(id,nomDocument, createurDocument,"CD");
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

	public float getNombrePages() {
		return _duree;
	}

	public void setNombrePages(float duree) {
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
		return "CD";
	}
	public ArrayList<CD> getListecd() {
		return listcd;
	}

	public void setListcd(ArrayList<CD> listcd) {
		this.listcd = listcd;
	}

	public void deletecd(int id) {
	
		listcd.remove(id);
	}
	public void update(int row,String nomdoc,String nomAut,float duree) {
		
		listcd.get(row)._nomDocument=nomdoc;
		listcd.get(row)._createurDocument=nomAut;
		listcd.get(row)._duree=duree;
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
	public void addcd(String nomDoc, String createurDoc, float duree) {
		int i = listcd.size()+1;
	
		
		String id="L"+i;
		CD cd1=new CD(id, nomDoc, createurDoc,duree);
		listcd.add(cd1);
		
	}
	public CD getcd() {
		return cd;
	}
	
	public int sizeList()
	{
		return listcd.size();
	}

	public void setcd(CD cd) {
		this.cd = cd;
	}
	public void AfficheTab(DefaultTableModel model)
	{
		model.setRowCount(0);
		for(int i=0;i<listcd.size();i++)
		{
			Object[] obj= {listcd.get(i).getCreateurDocument(),listcd.get(i).getNomDocument(),listcd.get(i).getNombrePages()};
			model.addRow(obj);
		}
	}
	
	
}
