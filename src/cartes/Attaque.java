package cartes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cartes.Probleme.Type;
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
	

}
