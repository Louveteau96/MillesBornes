package cartes;

import java.util.Iterator;

import jeu.Joueur;

public class Attaque extends Bataille {

	public Attaque(Type type, int nbr) {
		super(type,nbr);
	}
	
	@Override
	public String toString(){
		switch (this.getType()) {
		case FEU: {
			return "Feu rouge";
		}
		case ESSENCE:{
			return "Panne d'essence";
		}
		case CREVAISON:{
			return "Crevaison";
		}
		case ACCIDENT:{
			return "Accident";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.getType());
		}
	}
	
	//C'est le même code entre attaque et parade
	@Override
	public boolean appliquer(Joueur j) {
		for(Botte b:j.getBotteList()) {
			if (b.getType().equals(this.getType())) {
				return false;
			}
		}
		j.getBataillePile().add(this);
		return true;
	}

}
