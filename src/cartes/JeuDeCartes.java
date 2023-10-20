package cartes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cartes.Probleme.Type;


public class JeuDeCartes {
	private Carte[] typeDeCarte = {
	new Attaque(Type.FEU, 5),
	new Parade(Type.FEU, 14),
	new Botte(Type.FEU, 1),
	
	new Attaque(Type.ACCIDENT, 3),
	new Parade(Type.ACCIDENT, 6),
	new Botte(Type.ACCIDENT, 1),
	
	new Attaque(Type.CREVAISON, 3),
	new Parade(Type.CREVAISON, 6),
	new Botte(Type.CREVAISON, 1),
	
	new Attaque(Type.ESSENCE, 3),
	new Parade(Type.ESSENCE, 6),
	new Botte(Type.ESSENCE, 1),
	
	new Limite(4),
	new FinLimite(6),
	
	new Borne(25, 10),
	new Borne(50, 10),
	new Borne(75, 10),
	new Borne(100, 12),
	new Borne(200, 4)};
	
	private Carte[] listeCartes= new Carte[106];
	
	public JeuDeCartes() {
		int indexTab = 0;
		for (int i = 0; i < typeDeCarte.length; i++) {
			Carte famille = typeDeCarte[i];
			for (int j = 0; j < famille.getNombre() ; j++) {
				listeCartes[indexTab] = famille;
				indexTab++;
			}
		}
	}
	
	public void affichage() {
		StringBuilder message = new StringBuilder();
		for (int i = 0; i < listeCartes.length; i++) {
			message.append(listeCartes[i]);
			message.append("\n");
		}
		System.out.println(message);
	}
	
	
	public boolean checkCount() {
		for (int i = 0; i < listeCartes.length; i++) {
			if (listeCartes[i]==null) {
				return false;
			}
		}
		return true;
	}

	public List<Carte> getListeCartes() {
		List<Carte> liste = new ArrayList<>();
		liste.addAll(liste);
		return liste;
	}

}
