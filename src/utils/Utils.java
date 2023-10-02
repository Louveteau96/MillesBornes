package utils;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import cartes.*;

public class Utils {
	
	
	//La version sans le listeIterator
	public static Object extraire(ArrayList<Object> list) {
		Random random = new Random();
		int rand = random.nextInt(list.size());
		if(list.get(rand) instanceof Carte) {
			Carte carte = (Carte) list.get(rand);
			list.remove(rand);
			return carte;
		}
		throw new IllegalStateException("La liste n'est pas du type attendu");
	}
	
	
	//La version avec le listeIterator
	public static Object extraireIterator(ArrayList<Object> list) {
		Random random = new Random();
		Carte carte = null;
		int rand = random.nextInt(list.size());
		if(list.get(rand) instanceof Carte) {
			ListIterator<Object> iterator = list.listIterator();
			while(iterator.hasNext() && carte!=list.get(rand)) {
				if(iterator.next() instanceof Carte) {
					carte = (Carte) iterator.next();
				}
			}
			if(carte==list.get(rand)) {
				iterator.remove();
				return carte;
			}
		}
		throw new IllegalStateException("extraireIterator erreur");
	}

}
