package jeu;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.ArrayList;

import cartes.Carte;

public class MainAsList implements Main{
	private List<Carte> carteEnMain = new ArrayList<>();

	//Pas optimisé
	public int nbCarte(Carte carte) {
		int nbCarte = 0;
		for(Carte c:carteEnMain) {
			if(carte.equals(c)) {
				nbCarte++;
			}
		}
		return nbCarte;
	}
	
	@Override
	public void prendre(Carte carte) {
		int oldNbCarte = nbCarte(carte);
		carteEnMain.add(carte);
		assert(oldNbCarte+1 == nbCarte(carte));
	}
	@Override
	public void jouer(Carte carte) {
		assert(carteEnMain.contains(carte));
		int oldNbCarte = nbCarte(carte);
		carteEnMain.remove(carte);		
		assert(oldNbCarte-1 == nbCarte(carte));
	}

	@Override
	public Iterator<Carte> iterator() {
		return carteEnMain.iterator();
	}

	public List<Carte> getCarteEnMain() {
		return carteEnMain;
	}

}
