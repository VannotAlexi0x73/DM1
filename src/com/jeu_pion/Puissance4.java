package com.jeu_pion;

public class Puissance4 {
	private Plateau plateau;
	private int NB_CARACt_ALIGNER = 4;
	
	
	public Puissance4 (int longueur, int largeur) {
		plateau = new Plateau(longueur, largeur);
	}
	
	public void initialisation(int i, int j) {
		
	}
	
	
	public void jouer(Joueur joueur) {
		
	}
	
	
	public void gestionPosition() {
		
	}
	
	
	
	public int verification(Joueur joueur) {
		int i = 0;
		
		// Si le joueur a gagné on renvoie XXX
		if (/* Nb pions alignés == 4 */) {
			i = 1;
			return i ;
		}
		// Si il y a égalité alors on renvoie XXX
		else if (/* Plateau plein & aucun gagnant */) {
			i = 2;
			return i ;
		}

	}
}
