package jeu;


import java.util.Objects;

import cartes.Attaque;
import cartes.Carte;
import cartes.DebutLimite;

public class Coup {
	private Joueur joueur;
	private Carte carte;
	
	public Coup(Joueur joueur, Carte carte) {
		this.joueur=joueur;
		this.carte=carte;
	}
	
	public Joueur getJoueur() {
		return this.joueur;
	}
	
	public Carte getCarte() {
		return this.carte;
	}
	
	public boolean estValide(Joueur j) {
		if (carte instanceof Attaque || carte instanceof DebutLimite) {
			return !j.equals(joueur);
		}
		return j.equals(joueur);
	}

	@Override
	public boolean equals(Object c) {
		if (c instanceof Coup) {
			return c.hashCode() == this.hashCode();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 7*joueur.hashCode() + carte.hashCode()*31;
	}
	
	public boolean jouer(Joueur j) {
		if(!(j.getJeu().equals(joueur.getJeu()))) {
			//Remise de la carte dans le sabot
			System.out.println(j.toString() + " repose la carte " + carte.toString());
			this.joueur.getSabot().ajouterFamilleCarte(this.carte);
			return true;
		}
		boolean bool = carte.appliquer(joueur);
		if(bool) {
			System.out.println(j.toString() + " utilise la carte " + carte.toString() + " sur " + joueur.toString());
			joueur.getMain().jouer(carte);
		}
		return bool;
	}
}
