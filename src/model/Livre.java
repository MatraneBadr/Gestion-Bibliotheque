package model;

public class Livre extends Document {

	
	
	public Livre(String id,String nomDocument, String createurDocument, int nombrePages ) {
		super(id,nomDocument, createurDocument,"Livre",nombrePages);
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
	public int getDureeDocument() {
		return _dureeDocument;
	}
	
	@Override
	public void setDureeDocument(int nombrePage) {
		this._dureeDocument = nombrePage;
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
	
	

	

}
