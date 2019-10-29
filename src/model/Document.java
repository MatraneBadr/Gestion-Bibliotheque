package model;


public abstract class Document {
	
	protected String _nomDocument;
	protected String _createurDocument;
	
	public Document(String nomDocument, String createurDocument) {
		_nomDocument = nomDocument;
		_createurDocument = createurDocument;
	}
	
	
	
// Getter	
	public abstract String getNomDocument();
	public abstract String getCreateurDocument();
// Setter	
	public abstract void setNomDocument(String nomDocument);
	public abstract void setCreateurDocument(String createurDocument);
	
	
	
	
	

}
