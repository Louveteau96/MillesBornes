package testsFonctionels;

import  cartes.*;

public class TestJeuDeCartes {
	
	public static void main(String[] args) {
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		
		System.out.println(jeuDeCartes.checkCount());
		System.out.println("\n");
		jeuDeCartes.affichage();
	
	}

}
