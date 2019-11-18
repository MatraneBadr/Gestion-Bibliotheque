package model;

public class CD extends Document {


	public CD(String id,String nomDocument, String createurDocument,int duree) {
		super(id,nomDocument, createurDocument,"CD",duree);
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



	@Override
	public void setDureeDocument(int dureeDocument) {
		// TODO Auto-generated method stub
		this._dureeDocument = dureeDocument;
		
	}
	
	@Override
	public int getDureeDocument() {
		return _dureeDocument;
	}
	

}
