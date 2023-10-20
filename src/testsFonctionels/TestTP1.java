package testsFonctionels;

import jeu.*;

import java.util.Iterator;

import cartes.*;
import cartes.Probleme.Type;

public class TestTP1 {
	
	public static void affichage(Carte probleme) {
		StringBuilder message = new StringBuilder();
		message.append("Je pioche ");
		message.append(probleme.toString());
		System.out.println(message);
	}

	public static void main(String[] args) {
		Carte familleAccident = new Attaque(Type.ACCIDENT,2);
		Carte familleReparation = new Parade(Type.ACCIDENT,3);
		Carte familleAsDuVolant = new Botte(Type.ACCIDENT,1);
		
		Sabot sabot = new Sabot();
		sabot.ajouterFamilleCarte(familleAccident, familleReparation, familleAsDuVolant);
		
		for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
			type type = (type) iterator.next();
			
		}

		
		affichage(sabot.piocher());
		affichage(sabot.piocher());
		affichage(sabot.piocher());
		affichage(sabot.piocher());
		affichage(sabot.piocher());
		affichage(sabot.piocher());

	}

}
