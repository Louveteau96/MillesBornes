package cartes;

public abstract class Carte {
	private int nombre;
	
	protected Carte(int nbr) {
		this.setNombre(nbr);
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
	public boolean equals(Object carte) {
		return  this.getClass()==carte.getClass();
	}


	
}
