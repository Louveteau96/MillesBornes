package utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import cartes.*;

public class Utils {
	
	
	//La version sans le listeIterator
	public static Object extraire(List<Object> list) {
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
	public static Object extraireIterator(List<Object> list) {
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
	
	public static List<Carte> melanger(List<Object> list1){
		ArrayList<Carte> list2 = new ArrayList<>();
		while(!list1.isEmpty()) {
			Object carte = extraire(list1);
			if(carte instanceof Carte) {
				list2.add((Carte) carte);
			}else {
				throw new IllegalStateException("Le type des object de la liste donné n'est pas prévu");
			}
		}
		return list2;
	}
	
	
	
	public static Object verifierMelange(List<Object> list1, List<Object> list2) {
		for (int i = 0; i < list1.size(); i++) {
			if(list1.get(i) instanceof Carte && list2.get(i) instanceof Carte) {
				int frq1 = Collections.frequency(list1, list1.get(i));
				int frq2 = Collections.frequency(list2, list1.get(i));
				if(frq1 != frq2){
					return false;
				}
			}else {
				throw new IllegalStateException("L'une des listes n'est pas d'un type attendu");
			}
		}
		return true;
	}
	
	public static List<?> rassembler(List<Object> list1){
		ArrayList<Carte> list2 = new ArrayList<>();
		for (int i = 0; i < list1.size(); i++) {
			Object object = list1.get(i);
			if(object instanceof Carte) {
				if(!list2.contains(object)) {
					for (int j = 1; j < Collections.frequency(list1, object); j++) {
						list2.add((Carte) object);
					}
					list1.removeAll((Collection<?>)object);
				}
			}else {
				throw new IllegalStateException("Le type de la liste n'est pas attendu");
			}
		}
		return list2;
	}
	
	public static boolean verifierRassemblement(List<Object> list1) {
		int indexFin = list1.size()-1;
		int index = 0;
		ListIterator<Object> listIteratorDebut = list1.listIterator();
		ListIterator<Object> listIteratorFin = list1.listIterator(indexFin);
		while(listIteratorDebut.hasNext()) {
			while(listIteratorDebut.next().equals(listIteratorDebut)) {
				listIteratorDebut.next();
			}
			index = listIteratorDebut.nextIndex()-1;
			for (int i = indexFin; i > index; i--) {
				if(listIteratorFin.equals(listIteratorDebut)) {
					return false;
				}
			}
			listIteratorDebut.next();
		}
		return true;		
	}

}