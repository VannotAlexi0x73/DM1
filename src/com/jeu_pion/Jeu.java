package com.jeu_pion;

abstract class Jeu {
	
	abstract void initialisation (int i, int j);
	
	abstract void jouer (Joueur joueur);
	
	abstract void gestionPosition ();
	
	abstract int verification (Joueur joueur);

}
