package model;

public class Livre extends Document {

	private int _nombrePages;
	
	
	public Livre(int numDoc, String nomDocument, String createurDocument, int nombrePages ) {
		super(numDoc, nomDocument, createurDocument);
		setNombrePages(nombrePages);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return _idDocument;
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
	
	

	

}