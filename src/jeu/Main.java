package jeu;

import java.util.Iterator;
import java.util.List;

import cartes.Carte;

public interface Main {
	public void prendre(Carte carte);
	
	public void jouer(Carte carte);
	
	Iterator<Carte> iterator();
	

}
