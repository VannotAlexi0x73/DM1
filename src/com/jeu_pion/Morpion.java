package com.jeu_pion;

public class Morpion extends Jeu {
	
	private int taillePlateau;
	private static final String SEPARATEUR = ";";
	private static final int MAX_PLATEAU = 5;

	/**
	 *
	 */
	public Morpion()
	{
		this.initialisation();
	}

	/**
	 *
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
	 *
	 * @param joueur
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
	 *
	 * @param joueur
	 * @return
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


	public boolean gestionPosition(String valeur, String caractere)
	{
		int x;
		int y;
		boolean res;
		String [] pos = valeur.split(SEPARATEUR);
		x = Integer.valueOf(pos[0]);
		y = Integer.valueOf(pos[1]);
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

