package model;


public abstract class Document {
	
	protected String _nomDocument;
	protected String _createurDocument;
	protected String _idDocument;
	protected String _typeDocument;
	
	public Document(String id,String nomDocument, String createurDocument,String typeDocument) {
		_nomDocument = nomDocument;
		_createurDocument = createurDocument;
		_idDocument = id;
		_typeDocument = typeDocument;
	}
	
	
	
// Getter	
	public abstract String getNomDocument();
	public abstract String getCreateurDocument();
	public abstract String getIdDocument();
	public abstract String getTypeDocument();
// Setter	
	public abstract void setNomDocument(String nomDocument);
	public abstract void setCreateurDocument(String createurDocument);
	
	
	
	
	

}
