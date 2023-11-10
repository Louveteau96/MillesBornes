package testsFonctionels;

import java.util.ArrayList;
import java.util.Stack;

import jeu.Joueur;
import jeu.MainAsList;
import cartes.Attaque;
import cartes.JeuDeCartes;
import cartes.Probleme.Type;
import cartes.Botte;
import cartes.Parade;

public class TestJoueur {
	public static void main(String[] args) {
		Joueur joueur1 = new Joueur("Joueur 1",0, new MainAsList(), new ArrayList<>(), new ArrayList<>(), new Stack<>(), new Stack<>());
		
		//Test get du Joueur
		System.out.println(joueur1.toString());
		System.out.println(joueur1.getBorneList());
		System.out.println(joueur1.getBotteList());
		System.out.println(joueur1.getLimitePile());
		
		//Test toString equals joueurs
		Joueur joueur2 = new Joueur("Joueur 2",0, new MainAsList(), new ArrayList<>(), new ArrayList<>(), new Stack<>(), new Stack<>());
		Joueur joueur3 = new Joueur("Joueur 1",0, new MainAsList(), new ArrayList<>(), new ArrayList<>(), new Stack<>(), new Stack<>());
		
		System.out.println("\nDeux joueurs dont les noms sont différents ne sont pas equals");
		System.out.println(joueur2.toString());
		System.out.println(joueur1.toString());
		System.out.println(joueur2.equals(joueur1));
		
		System.out.println("\nDeux joueurs de même nom sont equals");
		System.out.println(joueur3.toString());
		System.out.println(joueur1.toString());
		System.out.println(joueur3.equals(joueur1) + "\n");
		
		//Test prendreCarte
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		System.out.println(jeuDeCartes.getListeCartes());
		System.out.println(joueur1.prendreCarte(jeuDeCartes.getListeCartes()));
		System.out.println(joueur2.prendreCarte(jeuDeCartes.getListeCartes()));
		System.out.println(joueur3.prendreCarte(jeuDeCartes.getListeCartes()));
		System.out.println(joueur1.prendreCarte(jeuDeCartes.getListeCartes()));
		System.out.println(joueur2.prendreCarte(jeuDeCartes.getListeCartes()));
		System.out.println(joueur3.prendreCarte(jeuDeCartes.getListeCartes()));
		System.out.println(joueur1.prendreCarte(jeuDeCartes.getListeCartes()));
		System.out.println(joueur2.prendreCarte(jeuDeCartes.getListeCartes()));
		System.out.println(joueur3.prendreCarte(jeuDeCartes.getListeCartes()));
		
		//Test estBloque
		Joueur joueur4 = new Joueur("Joueur 4",0, new MainAsList(), new ArrayList<>(), new ArrayList<>(), new Stack<>(), new Stack<>());
		Attaque feuRouge = new Attaque(Type.FEU,1);
		Botte prioritaire = new Botte(Type.FEU,1);
		Attaque accident = new Attaque(Type.ACCIDENT,1);
		Botte asDuVolant = new Botte(Type.ACCIDENT,1);
		Attaque panne = new Attaque(Type.ESSENCE,1);
		Botte essence = new Botte(Type.ESSENCE,1);
		Parade feuVert = new Parade(Type.FEU,1);
		
		System.out.println("\nVérification est bloqué");
		joueur4.getBataillePile().add(feuRouge);
		System.out.println(joueur4.estBloque());
		joueur4.getBotteList().add(prioritaire);
		System.out.println(joueur4.estBloque());
		joueur4.getBataillePile().add(accident);
		System.out.println(joueur4.estBloque());
		joueur4.getBotteList().add(asDuVolant);
		System.out.println(joueur4.estBloque());
		joueur4.getBataillePile().add(panne);
		System.out.println(joueur4.estBloque());
		joueur4.getBotteList().add(essence);
		System.out.println(joueur4.estBloque());
		
		//Suppression des bottes
		joueur4.getBotteList().remove(prioritaire);
		joueur4.getBotteList().remove(asDuVolant);
		joueur4.getBotteList().remove(essence);
		System.out.println(joueur4.estBloque());
		joueur4.getBataillePile().add(feuVert);
		System.out.println(joueur4.estBloque());
		

	}

}
