package model;


public abstract class Document {
	
	protected String _nomDocument;
	protected String _createurDocument;
	protected String _idDocument;
	
	public Document(String id,String nomDocument, String createurDocument) {
		_nomDocument = nomDocument;
		_createurDocument = createurDocument;
		_idDocument = id;
	}
	
	
	
// Getter	
	public abstract String getNomDocument();
	public abstract String getCreateurDocument();
	public abstract String getIdDocument();
// Setter	
	public abstract void setNomDocument(String nomDocument);
	public abstract void setCreateurDocument(String createurDocument);
	
	
	
	
	

}
