package testsFonctionels;


import jeu.*;
import cartes.*;
import cartes.Probleme.Type;

public class TestEquals {
	
	public static void affichage(Carte c1, Carte c2) {
		StringBuilder message = new StringBuilder();
		message.append(c1.equals(c2));
		System.out.println(message);
	}
	
	public static void main(String[] args) {
		Carte citerne = new Botte(Type.FEU,1);
		Carte prioritaire = new Botte(Type.ESSENCE,1);
		Carte increvable = new Botte(Type.CREVAISON,1);
		Carte asDuVolant = new Botte(Type.ACCIDENT,1);
		
		Carte feuRouge = new Attaque(Type.FEU,1);
		Carte panneEssence = new Attaque(Type.ESSENCE,1);
		Carte crevaison = new Attaque(Type.CREVAISON,1);
		Carte accident = new Attaque(Type.ACCIDENT,1);
		
		Carte feuVert = new Parade(Type.FEU,1);
		Carte essence = new Parade(Type.ESSENCE,1);
		Carte roueDeSecours = new Parade(Type.CREVAISON,1);
		Carte reparation = new Parade(Type.ACCIDENT,1);
		
		
		Carte borne10 = new Borne(10,1);
		Carte borne100 = new Borne(100,1);
		
		//Les premiers doivent être true les autres false
		affichage(borne10, borne10);
		affichage(borne100, borne100);
		affichage(citerne, citerne);
		affichage(crevaison, crevaison);
		affichage(essence, essence);
		System.out.println("\n");
		affichage(borne10, borne100);
		affichage(borne10, citerne);
		affichage(borne10, feuRouge);
		affichage(borne10, essence);
		affichage(citerne, prioritaire);
		affichage(increvable, feuVert);
		affichage(asDuVolant, panneEssence);
		affichage(crevaison, accident);
		affichage(roueDeSecours, reparation);
	}

}
