package testsFonctionels;

import java.util.List;

import cartes.*;
import utils.*;

public class TestUtils {
	static Utils utils = new Utils();
	
	public static void main(String[] args) {
		JeuDeCartes jeu1 = new JeuDeCartes();
		Carte extraire = (Carte) Utils.extraire(jeu1);
		System.out.println(extraire);
		
		
	}

}
