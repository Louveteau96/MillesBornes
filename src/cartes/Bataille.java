package cartes;

import jeu.Joueur;
import java.util.ArrayList;
import java.util.List;

public abstract class Bataille extends Probleme {

	protected Bataille(Type type, int nbr) {
		super(type,nbr);
	}
	
	
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
				Bataille top = j.getBataillePile().peek();
				
				//Si la carte qu'on veut appliquer et la carte sur le haut de la pile de bataille de l'adversaire
				//Sont les même alors on ne fait rien
				if ((this instanceof Attaque && top instanceof Attaque) || (this instanceof Parade && top instanceof Parade))
					return false;				

				//Si la cible a une botte de ce type ou n'est pas ciblié par une attaque de ce type
				if (btypes.contains(this.getType()) || top instanceof Attaque && top.getType()!=this.getType()) {
					return false;
				}
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
