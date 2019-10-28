package model;


public abstract class Document {
	
	protected int _idDocument;
	protected String _nomDocument;
	protected String _createurDocument;
	
	public Document(int numDoc, String nomDocument, String createurDocument) {
		_idDocument = numDoc;
		_nomDocument = nomDocument;
		_createurDocument = createurDocument;
	}
	
	
	
// Getter	
	public abstract int getId();
	public abstract String getNomDocument();
	public abstract String getCreateurDocument();
// Setter	
	public abstract void setNomDocument(String nomDocument);
	public abstract void setCreateurDocument(String createurDocument);
	
	
	
	
	

}
