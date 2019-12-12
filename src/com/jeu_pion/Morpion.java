package com.jeu_pion;

/**
 * Classe Abstraite Jeu
 * @author : Remi B.
 * @version : 1.0
 */
public class Morpion extends Jeu {
	
	private int taillePlateau;
	private static final String SEPARATEUR = ";";
	private static final int MAX_PLATEAU = 5;

	/**
	 * Constructeur qui fait appel à une autre méthode afin de créer le plateau de jeu du morpion
	 */
	public Morpion()
	{
		this.initialisation();
	}

	/**
	 * Permet de demander à l'utilisateur la taille du plateau de jeu qu'il desire avec une taille maximale MAX_PLATEAU
	 */
	@Override
	public void initialisation()
	{
		String str;
		str = String.format("Entrer la taille du plateau (max %d): ", MAX_PLATEAU);
		Jeu.affichable.affichageElement(str);
		do 
		{
			taillePlateau = scanner.nextInt();
			scanner.nextLine(); // Remise à "zéro" du scanner
			if((taillePlateau <= 0) || (taillePlateau > MAX_PLATEAU))
			{
				str = String.format("Veuillez entrer une valeur entre 1 et %d: ", MAX_PLATEAU);
				Jeu.affichable.affichageElement(str);
			}
		} while ((taillePlateau <= 0) || (taillePlateau > MAX_PLATEAU));
		plateau = new Plateau(taillePlateau, taillePlateau);
	}

	/**
	 * Méthode qui permet de demander au joueur passé en paramètre de saisir des
	 * coordonnées afin de modifier le plateau de jeu
	 * @param joueur : joueur qui doit modifier le plateau de jeu
	 */
	@Override
	public void jouer(Joueur joueur) 
	{
		String positionPion;
		String str;
		do {
			str = String.format("%n%n%s doit jouer. Placer votre pion (ex: 0;0) : ", joueur.getPrenom());
			Jeu.affichable.affichageElement(str);
			positionPion = scanner.next();
		} while (!gestionPosition(positionPion, joueur.getCaractere()));
	}

	/**
	 * Cette méthode permet de vérifier si un joueur a gagné, perdu ou s'il y a égalité
	 * @param joueur : joueur pour lequel on souhaite vérifier une victoire, défaite, égalité
	 * @return 0 si le joueur doit "rejouer", 1 si victoire, 2 si egalité
	 */
	@Override
	public int verification(Joueur joueur)
	{
		int cpt = 0;
		int cpt1 = 0;
		int cpt2 = 0;
		int cpt3 = 0;
		
		for (int i = 0; i < taillePlateau; i++) 
		{
			if(plateau.obtenirValeurMatricePlateau( i, i) == joueur.getCaractere())
			{
				cpt++;
			}
			if(plateau.obtenirValeurMatricePlateau( i, taillePlateau - i) == joueur.getCaractere())
			{
				cpt1++;
			}
			cpt2 = 0;
			cpt3 = 0;
			for(int t = 0; t < taillePlateau; t++) 
			{
				if(plateau.obtenirValeurMatricePlateau( i, t) == joueur.getCaractere())
				{
					cpt2++;
				}
				if(plateau.obtenirValeurMatricePlateau( t, i) == joueur.getCaractere())
				{
					cpt3++;
				}
			}
			if(cpt2 == taillePlateau|| cpt3 == taillePlateau)
			{
				return 1;
			}
		}
		if(cpt == taillePlateau || cpt1 == taillePlateau)
		{
			return 1;
		}
		else if (plateau.isMatricePlateauComplete())
		{
			return 2;
		}
		else
		{
			return 0;
		}
	}


	/**
	 * Méthode qui modifie le plateau de jeu si les coordonnées du joueur sont correctes avec son caractère
	 * @param valeur : les coordonnées du pion que le joueur souhaite insérer dans le plateau sous la forme /!\ X;Y /!\
	 * @param caractere : le caractère du joueur qu'on va insérer dans le plateau
	 * @return true si le joueur a bien modifié le plateau de jeu (ex: test si les coordonnées sont correctes) sinon false
	 */
	private boolean gestionPosition(String valeur, String caractere)
	{
		int x;
		int y;
		boolean res;
		String [] pos = valeur.split(SEPARATEUR);
		x = Integer.parseInt(pos[0]);
		y = Integer.parseInt(pos[1]);
		if((x >= 0 ) && (x < taillePlateau) && (y >= 0) && (y < taillePlateau))
		{
			if(plateau.obtenirValeurMatricePlateau(y, x) == null )
			{
				plateau.modifierMatricePlateau(y, x, caractere);
				res = true;
			}
			else
			{
				Jeu.affichable.affichageElement("Cette case est déjà prise");
				res = false;
			}
		}
		else 
		{
			Jeu.affichable.affichageElement("Cette case n'est pas dans le plateau");
			res = false;
		}
		return res;
	}
}

