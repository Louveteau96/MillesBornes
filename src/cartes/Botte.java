package cartes;

import jeu.Joueur;

public class Botte extends Probleme {

	public Botte(Type type,int nbr) {
		super(type,nbr);
	}
	
	@Override
	public String toString(){
		switch (this.getType()) {
		case FEU: {
			return "Véhicule prioritaire";
		}
		case ESSENCE:{
			return "Citerne d'essence";
		}
		case CREVAISON:{
			return "Increvable";
		}
		case ACCIDENT:{
			return "As du volant";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.getType());
		}
	}
	
	@Override
	public boolean appliquer(Joueur j) {
		boolean sortie = false;
		j.getBotteList().add(this);
		for(Carte c:j.getBataillePile()) {
			//Si c'est une attaque du même type que la botte on l'enleve
			if (c instanceof Attaque && ((Attaque) c).getType().equals(this.getType())) {
				j.getBataillePile().remove(c);
				sortie = true;
			}
		}
		return sortie;
	}

}
