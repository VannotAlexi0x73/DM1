package com.jeu_pion;

/**
 * Classe Abstraite Jeu
 * @author : Remi B. / Valentin D.
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
        do 
        {
        	str = String.format("%n%n%s doit jouer. Choisi la colonne où lâcher la pièce (0 à 6) : ", joueur.getPrenom());
            Jeu.affichable.affichageElement(str);
            positionPion = scanner.nextInt();
        }
        while(!gestionPosition(positionPion, joueur.getCaractere()));
    }


	/**
	 * Cette méthode permet de vérifier si un joueur a gagné, perdu ou s'il y a égalité
	 * @param joueur : joueur pour lequel on souhaite vérifier une victoire, défaite, égalité
	 * @return 0 si le joueur doit "rejouer", 1 si victoire, 2 si egalité
	 */
	@Override
	public int verification( Joueur joueur) {
		String car = joueur.getCaractere();
		
		for (int i = 0; i < plateau.getLigneMatricePlateau(); i++) {
			for (int j = 0; j < plateau.getColonneMatricePlateau(); j++) {
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
		if (plateau.isMatricePlateauComplete() == true)
		{
			return 2;
		}
		else
		{
			return 0;
		}
	}


	private boolean gestionPosition(int position , String caractere) {
		int i = 0;
		if ((position >= 0) && (position < plateau.getColonneMatricePlateau()))
		{
			if ((plateau.obtenirValeurMatricePlateau(0, position) == null) &&
					(plateau.obtenirValeurMatricePlateau(1,position) == null))
			{
				do {
					i++;
				} while (plateau.obtenirValeurMatricePlateau( i + 1, position) == null);
				plateau.modifierMatricePlateau(i, position, caractere);
				return true;

			}
			else if ((plateau.obtenirValeurMatricePlateau(0, position) == null) &&
					(plateau.obtenirValeurMatricePlateau(1,position) != null))
			{
				plateau.modifierMatricePlateau(i, position, caractere);
				return true;
			}
			else
			{
				System.out.println( "la colonne est pleine");
				return false;
			}
		}
		else
		{
			System.out.println( "la colonne n'existe pas");
			return false;
		}
	}
}
