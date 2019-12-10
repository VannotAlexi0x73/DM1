package com.jeu_pion;
import java.util.Scanner;

public class Puissance4 {
	private Plateau plateau;
	private Scanner saisieUtilisateur = new Scanner(System.in);
	
	// Instanciation du plateau de jeu
	public Puissance4 (int longueur, int largeur) {
		plateau = new Plateau(longueur, largeur);
	}
	
	
	
	// Modification du plateau en fonction de la colonne d'entr�e de l'utilisateur
	public void jouer (Joueur joueur) {
		
		// Demande de la colonne
		int Col = saisieUtilisateur.nextInt();
		while (Col < 0 || Col > getColonneMatricePlateau()) {
			System.out.println("Veuillez choisir parmi les colonnes existantes : ");
			int Col1 = saisieUtilisateur.nextInt();
		}
		
		// Regarde la ligne dans laquelle ins�rer la pi�ce
		gestionPosition();
		
		// Insertion de la pi�ce dans le plateau
		modifierMatricePlateau( XXX, Col , getCaractere());
		
		
	}
	
	
	
	
	public void gestionPosition () {
		// V�rif si colonne est pleine
		
		
		
		
	}
	
	
	
	
	
	public int verification (Joueur joueur) {
		int i;
		// R�cup�ration du plateau � l'instant t
		
		
		// ** Cas de la victoire pour le joueur actuel, on retourne 1 **
		if (
				(obtenirValeurMatricePlateau(i, j-1) == getCaractere() && obtenirValeurMatricePlateau(i, j-2) == getCaractere() && obtenirValeurMatricePlateau(i, j-3) == getCaractere())
				||
				(obtenirValeurMatricePlateau(i+1, j-1) == getCaractere() && obtenirValeurMatricePlateau(i+2, j-2) == getCaractere() && obtenirValeurMatricePlateau(i+3, j-3) == getCaractere())
				||
				(obtenirValeurMatricePlateau(i+1, j+1) == getCaractere() && obtenirValeurMatricePlateau(i+2, j+2) == getCaractere() && obtenirValeurMatricePlateau(i+3, j+3) == getCaractere())
				||
				(obtenirValeurMatricePlateau(i, j+1) == getCaractere() && obtenirValeurMatricePlateau(i, j+2) == getCaractere() && obtenirValeurMatricePlateau(i, j+3) == getCaractere())
				||
				(obtenirValeurMatricePlateau(i-1, j+1) == getCaractere() && obtenirValeurMatricePlateau(i-2, j+2) == getCaractere() && obtenirValeurMatricePlateau(i-3, j+3) == getCaractere())
				||
				(obtenirValeurMatricePlateau(i-1, j) == getCaractere() && obtenirValeurMatricePlateau(i-2, j) == getCaractere() && obtenirValeurMatricePlateau(i-3, j) == getCaractere())
				||
				(obtenirValeurMatricePlateau(i-1, j-1) == getCaractere() && obtenirValeurMatricePlateau(i-2, j-2) == getCaractere() && obtenirValeurMatricePlateau(i-3, j-3) == getCaractere())
			) {
			i = 1;
			return i;
		}
		// ** Cas de l'�galit�, on retourne 2**
		else if (/* Nb pieces == Nb cases plateau*/ isMatricePlateauComplete() ==  "True") {
			i = 2;
			return i;
		}
		// ** Cas d'une partie non achev�e on retourne 0**
		else {
			i = 0;
			return i;
		}
		
	}
}
