package cartes;

import java.util.ArrayList;
import java.util.Collections;
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
	
	new DebutLimite(4),
	new FinLimite(6),
	
	new Borne(25, 10),
	new Borne(50, 10),
	new Borne(75, 10),
	new Borne(100, 12),
	new Borne(200, 4)};
	
	
	private Carte[] tabCartes= new Carte[106];
	
	public JeuDeCartes() {
		int indexTab = 0;
		for (int i = 0; i < typeDeCarte.length; i++) {
			Carte famille = typeDeCarte[i];
			for (int j = 0; j < famille.getNombre() ; j++) {
				tabCartes[indexTab] = famille;
				indexTab++;
			}
		}
	}
	
	public void affichage() {
		StringBuilder message = new StringBuilder();
		for (int i = 0; i < tabCartes.length; i++) {
			message.append(tabCartes[i]);
			message.append("\n");
		}
		System.out.println(message);
	}
	
	

	public List<Carte> getListeCartes() {
		List<Carte> liste = new ArrayList<>();
		for (int i = 0; i < tabCartes.length; i++) {
			liste.add(tabCartes[i]);
		}
		Collections.shuffle(liste);
		return liste;
	}
	
	public boolean checkCount() {
        int countFeuRouge = 0;
        int countPanneEssence = 0;
        int countCrevaison = 0;
        int countAccident = 0;
        
        int countCiterneEssence = 0;
        int countIncrevable = 0;
        int countAsDuVolant = 0;
        int countVehiculePrioritaire = 0;
        
        int countFeuVert = 0;
        int countEssence = 0;
        int countRoueSecours = 0;
        int countReparation = 0;
        
        int countBorne25 = 0;
        int countBorne50 = 0;
        int countBorne75 = 0;
        int countBorne100 = 0;
        int countBorne200 = 0;
        
        int countDebutLimite = 0;
        int countFinLimite = 0;

        for (Carte carte : tabCartes) {
        	if(carte==null) {
        		return false;
        	}
            if (carte instanceof Attaque) {
                Attaque attaque = (Attaque) carte;
                switch (attaque.getType()) {
                    case FEU:
                        countFeuRouge++;
                        break;
                    case ESSENCE:
                        countPanneEssence++;
                        break;
                    case CREVAISON:
                        countCrevaison++;
                        break;
                    case ACCIDENT:
                        countAccident++;
                        break;
                    default:
    					throw new IllegalArgumentException("Unexpected value: " + attaque.getType());
                }
            } else if (carte instanceof Botte) {
                Botte botte = (Botte) carte;
                switch (botte.getType()) {
                    case ESSENCE:
                        countCiterneEssence++;
                        break;
                    case CREVAISON:
                        countIncrevable++;
                        break;
                    case ACCIDENT:
                        countAsDuVolant++;
                        break;
                    case FEU:
                        countVehiculePrioritaire++;
                        break;
                    default:
    					throw new IllegalArgumentException("Unexpected value: " + botte.getType());
                }
            }else if(carte instanceof Parade) {
            	Parade parade = (Parade) carte;
            	switch (parade.getType()){
					case FEU: 
						countFeuVert++;
						break;
					case ESSENCE:
						countEssence++;
						break;
					case CREVAISON:
						countRoueSecours++;
						break;
					case ACCIDENT:
						countReparation++;
						break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + parade.getType());
				}
            }else if (carte instanceof Borne) {
            	Borne borne = (Borne) carte;
            	switch (borne.getKm()) {
            		case 25:
            			countBorne25++;
            			break;
            		case 50:
            			countBorne50++;
            			break;
            		case 75:
            			countBorne75++;
            			break;
            		case 100:
            			countBorne100++;
            			break;
            		case 200:
            			countBorne200++;
            			break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + borne.getKm());
				}
            }else if(carte instanceof DebutLimite) {
            	countDebutLimite++;
            }else if(carte instanceof FinLimite) {
            	countFinLimite++;
            }
				
			}


        return countFeuRouge == 5 &&
               countPanneEssence == 3 &&
               countCrevaison == 3 &&
               countAccident == 3 &&
               
               countCiterneEssence == 1 &&
               countIncrevable == 1 &&
               countAsDuVolant == 1 &&
               countVehiculePrioritaire == 1 &&
               
               countFeuVert == 14 &&
               countEssence == 6 &&
               countRoueSecours == 6 &&
               countReparation == 6 &&
               
               countBorne25 == 10 &&
               countBorne50 == 10 &&
               countBorne75 == 10 &&
               countBorne100 == 12 &&
               countBorne200 == 4 &&
               
               countDebutLimite == 4 &&
               countFinLimite == 6
               ;
        
    }

}
