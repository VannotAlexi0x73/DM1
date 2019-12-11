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
		
		int positionPion;
		
		do 
		{
			System.out.println( joueur.getPrenom() + " à toi de jouer");
			System.out.println("place ton pion (ex : ");
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
				}while(plateau.obtenirValeurMatricePlateau( i+1, position) == null);
				plateau.modifierMatricePlateau( i, position, caractere);
				return true;
		
			}else {
				System.out.println( "la colone est pleine");
				return false;
			}
		}
		else {
			System.out.println( "la colone n'existe pas");
			return false;
		}
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
