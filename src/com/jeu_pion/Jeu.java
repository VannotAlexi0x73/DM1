package com.jeu_pion;

import java.util.Scanner;

/**
 * Classe Abstraite Jeu
 * @author : Alexis V
 * @version : 1.0
 */
abstract class Jeu {

	protected Plateau plateau;
	protected Scanner scanner = new Scanner(System.in);
	protected Joueur [] listeJoueurs;
	protected static Affichable affichable = new AffichageConsole();

	/**
	 * Méthode qui doit permettre de demander à l'utilisateur la taille du plateau de jeu qu'il desire,
	 * idéalement à appeler dans le constructeur d'une classe fille
	 */
	abstract void initialisation ();


	abstract void jouer (Joueur joueur);

	/**
	 * Cette méthode doit permettre de vérifier si un joueur a gagné, perdu ou s'il y a égalité
	 * @param joueur : joueur pour lequel on souhaite vérifier une victoire, défaite, égalité
	 * @return Elle doit retourner 0 si le joueur doit "rejouer", 1 si victoire, 2 si egalité, 3 si défaite
	 */
	abstract int verification (Joueur joueur);
}
