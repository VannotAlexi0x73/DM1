package com.jeu_pion;

/**
 * Classe Abstraite Jeu
 * @author : Remi B, Valentin D
 * @version : 1.0
 */
public class Puissance4 extends Jeu {

	/**
	 * Constructeur qui fait appel à une autre méthode afin de créer le plateau de jeu du puissance 4
	 */
	public Puissance4()
	{
		this.initialisation();
	}


	/**
	 * Création d'un plateau de jeu pour le puissance 4 de taille standard 6 x 7
	 */
	@Override
	public void initialisation() {
		plateau = new Plateau(6, 7);
	}


	/**
	 * Méthode qui permet de demander au joueur passé en paramètre de saisir
	 * la colonne dans laquelle il veut insérer sa pièce
	 * @param joueur : joueur qui doit modifier le plateau de jeu
	 */
	@Override
	public void jouer(Joueur joueur) {
        int positionPion;
        String str;
        // Vérification que la colonne est cohérente
        do 
        {
        	str = String.format("%n%n%s doit jouer. Choisi la colonne où lâcher la pièce (0 à 6) : ", joueur.getPrenom());
            Jeu.affichable.affichageElement(str);
            positionPion = scanner.nextInt();
			// On vérifie l'exactitude de la colonne puis on place la pièce
        } while (!gestionPosition(positionPion, joueur.getCaractere()));
    }


	/**
	 * Cette méthode permet de vérifier si un joueur a gagné, perdu ou s'il y a égalité
	 * @param joueur : joueur pour lequel on souhaite vérifier une victoire, défaite, égalité
	 * @return 0 si le joueur doit "rejouer", 1 si victoire, 2 si egalité
	 */
	@Override
	public int verification( Joueur joueur) {
		String car = joueur.getCaractere();

		// Boucle sur les lignes
		for (int i = 0; i < plateau.getLigneMatricePlateau(); i++)
		{
			// Boucle sur les colonnes
			for (int j = 0; j < plateau.getColonneMatricePlateau(); j++)
			{
				// Test des 7 directions pour vérifier si un joueur a gagné
				// TODO optimisation dynamique
				if ((plateau.obtenirValeurMatricePlateau(i, j) == car) && (plateau.obtenirValeurMatricePlateau(i, j-1) == car && plateau.obtenirValeurMatricePlateau(i, j-2) == car && plateau.obtenirValeurMatricePlateau(i, j-3) == car)
						||
					(plateau.obtenirValeurMatricePlateau(i, j) == car) &&(plateau.obtenirValeurMatricePlateau(i+1, j-1) == car && plateau.obtenirValeurMatricePlateau(i+2, j-2) == car && plateau.obtenirValeurMatricePlateau(i+3, j-3) == car)
						||
					(plateau.obtenirValeurMatricePlateau(i, j) == car) &&(plateau.obtenirValeurMatricePlateau(i+1, j+1) == car && plateau.obtenirValeurMatricePlateau(i+2, j+2) == car && plateau.obtenirValeurMatricePlateau(i+3, j+3) == car)
						||
					(plateau.obtenirValeurMatricePlateau(i, j) == car) &&(plateau.obtenirValeurMatricePlateau(i, j+1) == car && plateau.obtenirValeurMatricePlateau(i, j+2) == car && plateau.obtenirValeurMatricePlateau(i, j+3) == car)
						||
					(plateau.obtenirValeurMatricePlateau(i, j) == car) &&(plateau.obtenirValeurMatricePlateau(i-1, j+1) == car && plateau.obtenirValeurMatricePlateau(i-2, j+2) == car && plateau.obtenirValeurMatricePlateau(i-3, j+3) == car)
						||
					(plateau.obtenirValeurMatricePlateau(i, j) == car) &&(plateau.obtenirValeurMatricePlateau(i-1, j) == car && plateau.obtenirValeurMatricePlateau(i-2, j) == car && plateau.obtenirValeurMatricePlateau(i-3, j) == car)
						||
					(plateau.obtenirValeurMatricePlateau(i, j) == car) &&(plateau.obtenirValeurMatricePlateau(i-1, j-1) == car && plateau.obtenirValeurMatricePlateau(i-2, j-2) == car && plateau.obtenirValeurMatricePlateau(i-3, j-3) == car)) 
				{
					return 1;
				}
			}
		}
		if (plateau.isMatricePlateauComplete())
		{
			return 2;
		}
		else
		{
			return 0;
		}
	}

	/**
	 * Méthode qui modifie le plateau de jeu si la colonne du joueur est correcte avec son caractère
	 * @param position : la colonne de la pièce que le joueur souhaite insérer dans le plateau
	 * @param caractere : le caractère du joueur qu'on va insérer dans le plateau
	 * @return true si le joueur a bien modifié le plateau de jeu sinon false
	 */
	private boolean gestionPosition(int position , String caractere) {
		int i = 0;
		// Vérification que la colonne choisi est cohérente
		if ((position >= 0) && (position < plateau.getColonneMatricePlateau())) {
			// Test si les 2 premières cases ne sont pas occupées, on ajoute le pion dans la colonne
			// TODO simplification vérification pieces dans les colonnes
			if ((plateau.obtenirValeurMatricePlateau(0, position) == null) &&
					(plateau.obtenirValeurMatricePlateau(1, position) == null)) {
				do {
					i++;
					// On descend dans la colonne tant qu'il n'y a pas de pièces
				} while (plateau.obtenirValeurMatricePlateau(i + 1, position) == null);
				plateau.modifierMatricePlateau(i, position, caractere);

				return true;
				// Test si la première case est vide et si la deuxième case est pleine, alors on insère dans la première case
			} else if ((plateau.obtenirValeurMatricePlateau(0, position) == null) &&
					(plateau.obtenirValeurMatricePlateau(1, position) != null)) {
				plateau.modifierMatricePlateau(i, position, caractere);
				return true;
			} else {
				Jeu.affichable.affichageElement("La colonne est pleine !");
				return false;
			}
		} else {
			Jeu.affichable.affichageElement("La colonne n'existe pas !");
			return false;
		}
	}
}
