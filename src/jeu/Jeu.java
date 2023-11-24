package jeu;

import java.util.ArrayList;
import java.util.List;

public class Jeu {
	private List<Joueur> joueurs;
	private Sabot sabot;
	
	public Jeu() {
		this.joueurs = new ArrayList<>();
		this.sabot = new Sabot();
	}

	
	public void inscription(Joueur j) {
		j.setJeu(this);
	}
	
	public Sabot getSabot() {
		return this.sabot;
	}
	
	public List<Joueur> listJoueurs(){
		return this.joueurs;
	}
	
	
}
