package cartes;

public abstract class Probleme extends Carte {
	enum Type {FEU,ESSENCE,CREVAISON,ACCIDENT};
	private Type type;
	
	protected Probleme(Type type,int nbr) {
		super(nbr);
		this.setType(type);
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	

}
