package cartes;

import jeu.Joueur;

public abstract class Bataille extends Probleme {

	protected Bataille(Type type, int nbr) {
		super(type,nbr);
	}
	
	//Peut être optimisable
	@Override
	public boolean appliquer(Joueur j) {
		boolean prioritaire = false;
		if (j.getBataillePile().isEmpty()) {
			for(Botte b : j.getBotteList()) {
				if (b.getType().equals(Type.FEU)) {
					prioritaire = true;
				}
				if (!prioritaire) {
				//Il n'a pas la botte prioritaire
				if (this instanceof Attaque) {
					return false;
				}else {
					//On fait le appliquer de la parade
					return this.appliquer(j);
				}
				}else {
					//Si il a la priorité
					//Si c'est une parade on vérifie l'application
					if(this instanceof Attaque) {
						return this.appliquer(j);
						//Il n'y a rien à parer donc on refuse
						}else {
							return false;
							}
					}
				}
			}else {
				//Si la pile n'est pas vide
				//Si le sommet est une parade on autorise l'attaque
				if (j.getBataillePile().peek() instanceof Parade && this instanceof Attaque) {
					return this.appliquer(j);
				}else {
					//Si le sommet est une attaque on autorise la parade
					if(j.getBataillePile().peek() instanceof Attaque && this instanceof Parade) {
						return this.appliquer(j);
					}
			}		
		}
		return false;
		}


}
