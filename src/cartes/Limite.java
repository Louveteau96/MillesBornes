package cartes;

import cartes.Probleme.Type;
import jeu.Joueur;

public class Limite extends Carte {

	protected Limite(int nbr) {
		super(nbr);
	}
	
	@Override
	public boolean appliquer(Joueur j) {
		if (j.getLimite() == 50) {
			return false;
		}
		for(Botte b : j.getBotteList()) {
			//Si il a une botte prioritaire
			if (b.getType().equals(Type.FEU)) {
				return false;
			}
		}
		j.getLimitePile().add(this);
		return true;
	}
	
	

}
