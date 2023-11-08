package jeu;
import cartes.*;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sabot implements Iterable<Carte>{
	private Carte [] tableauDeCartes;
	private int nbCartes;
	Iterator<Carte> iterator = iterator();

	public Sabot() {
		this.tableauDeCartes = new Carte[110];
		this.nbCartes = 0;
	}
	
	public boolean estVide() {
		return nbCartes ==0;
	}
	
	private void ajouterCarte(Carte carte) {
		if(nbCartes ==110) {
			throw new ArrayIndexOutOfBoundsException();
		}else {
			tableauDeCartes[nbCartes] = carte;
			nbCartes++;
		}
	}
	
	//C'est une surcharge avec les plusieurs cartes
	public void ajouterFamilleCarte(Carte carte) {
		int nbrFamille = carte.getNombre();
		for (int i = 0; i < nbrFamille; i++) {
			ajouterCarte(carte);
		}
	}
	
	//Varargs
	public void ajouterFamilleCarte(Carte... args) {
		for (Carte carte : args){
			ajouterFamilleCarte(carte);
		}
	}
	
	public Carte piocher() {
        if (iterator.hasNext()) {
            Carte cartePiochee = iterator.next();
            iterator.remove();
            return cartePiochee;
        } else {
            throw new NoSuchElementException("Le sabot est vide, impossible de piocher.");
        }
    }
	
	////////////////////////////////
	//Les Méthodes de l'itération//
	//////////////////////////////
	@Override
    public Iterator<Carte> iterator() {
        return new SabotIterator();
    }
	
	

	
	///////////////////
	//Classe interne//
	/////////////////
	
	private class SabotIterator implements Iterator<Carte> {
        private int indiceIterator = 0;
        private boolean nextEffectue = false;
        private int nbCarteReference = nbCartes;
        
        public void verifOccurence() {
        	if (nbCarteReference != nbCartes) {
				throw new ConcurrentModificationException("Il y a plusieurs itérateurs");
			}
        }
        

        @Override
        public boolean hasNext() {
        	nextEffectue = false;        	
    		return indiceIterator < nbCartes;
        }

        @Override
    	public Carte next() {
        	verifOccurence();
    		if(!hasNext()) {
    			throw new NoSuchElementException("Il n'y a plus d'éléments next");
    		}else{
    			Carte carte = tableauDeCartes[indiceIterator];
    			indiceIterator++;
    			nextEffectue = true;
    			return carte;
    		}
    	}
        
        @Override
        public void remove() {
        	verifOccurence();
            if (nbCartes < 1) {
                throw new IllegalStateException("Il n'y a pas de cartes à retirer");
            } else if (!nextEffectue) {
                throw new IllegalStateException("not nextEffectue");
            } else {
            	//On décale tout le tableau
            	for(int i = indiceIterator-1 ; i<109 ; i++) {
            		tableauDeCartes[i] = tableauDeCartes[i+1];
            	}
                nextEffectue = false;
                nbCartes--;
                nbCarteReference--;
                indiceIterator--;
            }
        }

	}
}
