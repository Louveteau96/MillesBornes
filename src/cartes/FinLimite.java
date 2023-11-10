package cartes;

import cartes.Probleme.Type;
import jeu.Joueur;

public class FinLimite extends Limite {

	public FinLimite(int nbr) {
		super(nbr);
	}
	
	//Rajout des méthodes toString()
	public String toString() {
		return "Fin limite";
	}

	@Override
	public boolean appliquer(Joueur j) {
		for(Botte b : j.getBotteList()) {
			//Si il a une botte prioritaire
			if (b.getType().equals(Type.FEU)) {
				return false;
			}
		}
		if (j.getLimite()==50) {
			j.getLimitePile().add(this);
			return true;
		}
		return false;
	}
}
