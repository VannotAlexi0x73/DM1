package com.jeu_pion;
import java.util.Scanner;

public class Puissance4 extends Jeu {
	
	private Scanner saisieUtilisateur = new Scanner(System.in);
	private int x;
	private int y;
	
	// Instanciation du plateau de jeu
	public Puissance4 () {
		plateau = new Plateau(6, 7);
	}
	
	public void jouer(Joueur joueur) {

        int positionPion;

        do 
        {
            System.out.println( joueur.getPrenom() + " à toi de jouer");
            System.out.println("Choisi la colonne où lâcher la pièce : ");
            positionPion = scanner.nextInt();
        }
        while(gestionPosition(positionPion, joueur.getCaractere()) == false);
    }
	
	
	

	public boolean gestionPosition(int position , String caractere) {
		int i = 0;
		if ((position>=0)&&(position< plateau.getColonneMatricePlateau())) {
			if (plateau.obtenirValeurMatricePlateau(0,position) == null) {
				do {
					i++;
				}	while	(plateau.obtenirValeurMatricePlateau( i+1, position) == null);
				plateau.modifierMatricePlateau(i, position, caractere);
				return true;

			}else {
				System.out.println( "La colonne est pleine");
				return false;
			}
		}
		else {
			System.out.println( "La colonne n'existe pas");
			return false;
		}
	}
	
	
	
	
	public int verification( Joueur joueur) {
		String car = joueur.getCaractere();
		
		for (int i = 0; i < plateau.getLigneMatricePlateau(); i++) {
			for (int j = 0; j < plateau.getColonneMatricePlateau(); j++) {
				if (	(plateau.obtenirValeurMatricePlateau(i, j-1) == car && plateau.obtenirValeurMatricePlateau(i, j-2) == car && plateau.obtenirValeurMatricePlateau(i, j-3) == car)
						||
					(plateau.obtenirValeurMatricePlateau(i+1, j-1) == car && plateau.obtenirValeurMatricePlateau(i+2, j-2) == car && plateau.obtenirValeurMatricePlateau(i+3, j-3) == car)
						||
					(plateau.obtenirValeurMatricePlateau(i+1, j+1) == car && plateau.obtenirValeurMatricePlateau(i+2, j+2) == car && plateau.obtenirValeurMatricePlateau(i+3, j+3) == car)
						||
					(plateau.obtenirValeurMatricePlateau(i, j+1) == car && plateau.obtenirValeurMatricePlateau(i, j+2) == car && plateau.obtenirValeurMatricePlateau(i, j+3) == car)
						||
					(plateau.obtenirValeurMatricePlateau(i-1, j+1) == car && plateau.obtenirValeurMatricePlateau(i-2, j+2) == car && plateau.obtenirValeurMatricePlateau(i-3, j+3) == car)
						||
					(plateau.obtenirValeurMatricePlateau(i-1, j) == car && plateau.obtenirValeurMatricePlateau(i-2, j) == car && plateau.obtenirValeurMatricePlateau(i-3, j) == car)
						||
					(plateau.obtenirValeurMatricePlateau(i-1, j-1) == car && plateau.obtenirValeurMatricePlateau(i-2, j-2) == car && plateau.obtenirValeurMatricePlateau(i-3, j-3) == car)) 
				{
					return 1;
				}
			}
		}
		if(plateau.isMatricePlateauComplete() == true) {
			return 2;
		}
		else {
			return 0;
		}
		
		
	}
		
	

    public int getLigne() {
        return this.x;
    }

    public int getColonne() {
        return this.y;
    }

	@Override
	void initialisation() {
		// TODO Auto-generated method stub
		
	}

}