package testsFonctionels;

import jeu.*;

import java.util.ConcurrentModificationException;
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
		
		Sabot sabot = new Sabot();
		sabot.ajouterFamilleCarte(familleAccident, familleReparation);
		
		
		// Utilisation d'un itérateur et remove
		Iterator<Carte> iterator = sabot.iterator();
        while (iterator.hasNext()) {
            Carte cartePiochee = iterator.next();
            System.out.println("je pioche " + cartePiochee);
            iterator.remove();
            
        }
		
		// Ajout de "As du volant" et tentative de piocher
		Carte familleAsDuVolant = new Botte(Type.ACCIDENT,1);
		sabot.ajouterFamilleCarte(familleAsDuVolant);
		
		//Parcours des éléments de Sabot
		for(Carte c:sabot) {
			//On déclence l'erreur concurent
			try {
	            System.out.println("Je pioche " + sabot.piocher());
	        } catch (ConcurrentModificationException e) {
	            System.out.println("Exception levée : " + e.getMessage());
	        }
			
		}
		
		



	}

}
