package com.jeu_pion;

import java.util.Scanner;

public class Morpion {
	
	private  int taillePlateau;
	Scanner scanner = new Scanner(System.in);
	private  String nom1;
	private String nom2;
	private  String caractere1;
	private  String caractere2;
	private  String positionPion;
	final static String SEPARATEUR = ";";
	Plateau Plat;
	
	public void init() 
	{
		System.out.println("Entrez la taille du plateau (max 5)");
		do 
		{
			taillePlateau = scanner.nextInt();
			if(taillePlateau >= 6) 
			{
				System.out.println("Erreur : entrez a nouveau la taille du plateau (max 5)");
			}
		}
		while(taillePlateau >= 6);
		Plat = new Plateau(taillePlateau,taillePlateau);
		System.out.println("Entrez le nom du premier joueur");
		nom1 = scanner.next();
		System.out.println("Entrez le symbole du premier joueur (ex : X)");
		do 
		{
			caractere1 = scanner.next();
			if(caractere1.length() > 1) 
			{
				System.out.println("Erreur : entrez à nouveau le symbole du premier joueur (ex : X)");
			}
		}
		while(caractere1.length() > 1);
		System.out.println("Entrez le nom du second joueur");
		nom2 = scanner.next();
		System.out.println("Entrez le symbole du second joueur (ex : O)");
		do 
		{
			caractere2 = scanner.next();
			if(caractere2.length() > 1) 
			{
				System.out.println("Erreur : entrez à nouveau le symbole du second joueur (ex : O)");
			}
		}
		while(caractere2.length() > 1);
		Joueur joueur1 = new Joueur (nom1,caractere1);
		Joueur joueur2 = new Joueur (nom2,caractere2);
	}
	
	public void jouer(Joueur joueur) 
	{
		
		System.out.println( joueur.getPrenom() + " à toi de jouer");
		System.out.println("place ton pion (ex : 0;0)");
		positionPion = scanner.next();
		gestionPosition(positionPion,joueur.getCaractere());
		if(verification1(joueur) == 1 ) 
		{
			System.out.println( joueur.getPrenom() + " à gagner");
		}
	}
	
	public int verification1(Joueur joueur) 
	{
		int cpt = 0,cpt1 = 0,cpt2,cpt3;
		
		for (int i = 0; i < taillePlateau; i++) 
		{
			if(Plat.obtenirValeurMatricePlateau( i, i) == joueur.getCaractere()) 
			{
				cpt++;
			}
			if(Plat.obtenirValeurMatricePlateau( i, taillePlateau - i) == joueur.getCaractere()) 
			{
				cpt1++;
			}
			cpt2 = 0;
			cpt3 = 0;
			for(int t = 0; t < taillePlateau; t++) 
			{
				if(Plat.obtenirValeurMatricePlateau( i, t) == joueur.getCaractere()) 
				{
					cpt2++;
				}
				if(Plat.obtenirValeurMatricePlateau( t, i) == joueur.getCaractere()) 
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
		else
		{
			return 0;
		}
	}
	
	public void gestionPosition(String valeur, String caractere) 
	{
		int x;
		int y;
		String pos[] = valeur.split(SEPARATEUR);
		x = Integer.valueOf(pos[0]);
		y = Integer.valueOf(pos[1]);
		if((0 <= x ) && (x < taillePlateau) && (0 <= y ) && (y < taillePlateau)) {
			if(Plat.obtenirValeurMatricePlateau( x, y) != null ) 
			{
				System.out.println("Erreur : la case est déjà prise");
			}
			else 
			{
				Plat.modifierMatricePlateau( x, y, caractere);
			}
		}
		else 
		{
			System.out.println("Erreur : case n'existe pas");
		}
	}
}

