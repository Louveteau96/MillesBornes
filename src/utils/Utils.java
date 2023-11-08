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
	public static <T>T extraire(List<T> list) {
		if (list.isEmpty()) {
            throw new IllegalArgumentException("La liste est vide.");
        }
		Random random = new Random();
		int rand = random.nextInt(list.size());
		return list.remove(rand);
	}
	
	
	//La version avec le listeIterator
	public static <T>T extraireIterator(List<T> list) {
		Random random = new Random();
		Carte carte = null;
		int rand = random.nextInt(list.size());
		ListIterator<T> iterator = list.listIterator();
		while(iterator.hasNext() && carte != list.get(rand)) {
			iterator.next();
		}
		T element = iterator.next();
		return element;
	}
	
	
	//Le mélange
	public static <T> List<T> melanger(List<T> list){
		ArrayList<T> resultat = new ArrayList<>(list);
		Collections.shuffle(resultat);
		return resultat;
	}
	
	
	
	public static Object verifierMelange(List<? extends Object> list1, List<? extends Object> list2) {
		for (int i = 0; i < list1.size(); i++) {
			//Si les deux éléments des listes sont des Cartes
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
	
	public static List<Object> rassembler(List<? extends Object> list1){
		List<Object> list2 = new ArrayList<>();
		for (int i = 0; i < list1.size(); i++) {
			Object object = list1.get(i);
			//Si c'est une carte
			if(object instanceof Carte) {
				if(!list2.contains(object)) {
					for (int j = 1; j < Collections.frequency(list1, object); j++) {
						list2.add(object);
					}
					list1.removeAll((Collection<?>)object);
				}
			}else {
				throw new IllegalStateException("Le type de la liste n'est pas attendu");
			}
		}
		return list2;
	}
	
	public static boolean verifierRassemblement(List<? extends Object> list1) {
		int indexFin = list1.size()-1;
		int index = 0;
		ListIterator<?> listIteratorDebut = list1.listIterator();
		ListIterator<?> listIteratorFin = list1.listIterator(indexFin);
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
