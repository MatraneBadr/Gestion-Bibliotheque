package model;


public abstract class Document {
	
	protected String _nomDocument;
	protected String _createurDocument;
	protected String _idDocument;
	protected String _typeDocument;
	protected int _dureeDocument;
	
	public Document(String id,String nomDocument, String createurDocument,String typeDocument,int dureeDocument) {
		_nomDocument = nomDocument;
		_createurDocument = createurDocument;
		_idDocument = id;
		_typeDocument = typeDocument;
		_dureeDocument = dureeDocument;
	}
	
	
	
// Getter	
	public abstract String getNomDocument();
	public abstract String getCreateurDocument();
	public abstract String getIdDocument();
	public abstract String getTypeDocument();
	public abstract int getDureeDocument();
// Setter	
	public abstract void setNomDocument(String nomDocument);
	public abstract void setCreateurDocument(String createurDocument);
	public abstract void setDureeDocument(int dureeDocument);
	
	
	
	
	

}
