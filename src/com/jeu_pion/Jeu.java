package com.jeu_pion;

abstract class Jeu {

	protected Plateau plateau;
	protected Joueur [] listeJoueurs;

	abstract void jouer (Joueur joueur);
	
	abstract void gestionPosition ();
	
	abstract int verification (Joueur joueur);

	public static void main(String[] args) {
		Plateau test = new Plateau(10, 3);

		for (int i = 1; i < test.getLigneMatricePlateau(); i++)
		{
			for (int j = 0; j < test.getColonneMatricePlateau(); j++)
			{
				test.modifierMatricePlateau(i, j, "c");
			}
		}

		test.afficherPlateau();
	}

}
