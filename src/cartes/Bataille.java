package cartes;

import jeu.Joueur;
import java.util.ArrayList;
import java.util.List;

public abstract class Bataille extends Probleme {

	protected Bataille(Type type, int nbr) {
		super(type,nbr);
	}
	
	//Peut être optimisable
//	@Override
//	public boolean appliquer(Joueur j) {
//		//La liste qui contient tout les types des bottes
//		//On pourrait le remplacer avec un hashCode je pense
//		List<Type> btypes = new ArrayList<>();
//		for(Botte botte:j.getBotteList()) {
//			btypes.add(botte.getType());
//		}
//		if (j.getBataillePile().isEmpty()) {
//				if (!btypes.contains(Type.FEU)) {
//					//Il n'a pas la botte prioritaire
//					//On considère donc qu'on est fasse à un feu rouge
//					//Si la cible a une botte face à notre carte on ne peut rien faire
//					if(btypes.contains(this.getType())) {
//						return false;
//					}else {
//						//On ne peux pas poser un feu rouge c'est la carte de base lorsque c'est vide et sans priorité
//						if (this instanceof Attaque && this.getType().equals(Type.FEU)) {
//							return false;
//						}
//						j.getBataillePile().add(this);
//						return true;
//					}
//
//				}else {
//					//Si il a la priorité
//					//Si c'est une parade on vérifie l'application
//					if(this instanceof Attaque) {
//						for(Botte botte2:j.getBotteList()) {
//							if (b.getType().equals(this.getType())) {
//								return false;
//							}
//						}
//						j.getBataillePile().add(this);
//						return true;
//						//Il n'y a rien à parer donc on refuse
//						}else {
//							return false;
//							}
//					}
//				}
//			}else {
//				//Si la pile n'est pas vide
//				//Si le sommet est une parade on autorise l'attaque
//				if (j.getBataillePile().peek() instanceof Parade && this instanceof Attaque) {
//					return this.appliquer(j);
//				}else {
//					//Si le sommet est une attaque on autorise la parade
//					if(j.getBataillePile().peek() instanceof Attaque && this instanceof Parade) {
//						return this.appliquer(j);
//					}
//			}
//		}
//		return false;
//		}
//
	
	@Override
	public boolean appliquer(Joueur j) {
		//La liste qui contient tout les types des bottes
		//On pourrait le remplacer avec un hashCode je pense
		List<Type> btypes = new ArrayList<>();
		for(Botte botte:j.getBotteList()) {
			btypes.add(botte.getType());
		}		
		//Si la cible n'est pas protégé par une botte du type de notre carte
		if (!btypes.contains(this.getType())) {
			//Le type du haut de la pile de bataille adverse
			//Si elle n'est pas vide
			if (!j.getBataillePile().isEmpty()) {
				Carte top = j.getBataillePile().peek();
				
				//Si la carte qu'on veut appliquer et la carte sur le haut de la pile de bataille de l'adversaire
				//Sont les même alors on ne fait rien
				if ((this instanceof Attaque && top instanceof Attaque) || (this instanceof Parade && top instanceof Parade))
					return false;
				//Sinon on peut appliquer la carte
				j.getBataillePile().add(this);
				return true;
			}else {
				//Si on se met un feu vert sans priorité et sans carte
				if (this.getType().equals(Type.FEU) && this instanceof Parade) {
					j.getBataillePile().add(this);
					return true;
				}
				//sinon on peut rien faire
				return false;
			}	
		}
		else {
			//Si la cible a une botte contre notre carte on ne fait rien
			return false;
		}
	
	}
}
