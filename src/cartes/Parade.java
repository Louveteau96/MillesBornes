package cartes;

public class Parade extends Bataille {

	public Parade(Type type, int nbr) {
		super(type,nbr);
	}
	
	@Override
	public String toString(){
		switch (this.getType()) {
		case FEU: {
			return "Feu vert";
		}
		case ESSENCE:{
			return "Essence";
		}
		case CREVAISON:{
			return "Roue de secours";
		}
		case ACCIDENT:{
			return "Réparation";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.getType());
		}
	}

}
