package jeu;
import cartes.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Sabot {
	private Carte [] tableauDeCartes;
	private int nbCartes;

	public Sabot() {
		this.tableauDeCartes = new Carte[110];
	}
	
	public boolean estVide() {
		return nbCartes ==0;
	}
	
	private void ajouterCarte(Carte carte) {
		if(nbCartes ==110) {
			throw new ArrayIndexOutOfBoundsException();
		}else {
			tableauDeCartes[nbCartes] = carte;
			nbCartes++;
		}
	}
	
	//C'est une surcharge avec les plusieurs cartes
	public void ajouterFamilleCarte(Carte carte) {
		int nbrFamille = carte.getNombre();
		for (int i = 0; i < nbrFamille; i++) {
			ajouterCarte(carte);
		}
	}
	
	//Varargs
	public void ajouterFamilleCarte(Carte... args) {
		
	}

}
