package com.jeu_pion;

public class Main {

    public static void main(String[] args) {
        Plateau test = new Plateau(3, 3);
        test.ModifierMatrice(0, 0, "O");
        test.ModifierMatrice(1, 1, "O");
        test.ModifierMatrice(2, 2, "O");
        test.ModifierMatrice(0, 1, "X");
        test.ModifierMatrice(0, 2, "X");
        test.ModifierMatrice(2, 1, "O");
        test.ModifierMatrice(1, 0, "X");
        test.ModifierMatrice(2, 0, "X");
//        test.ModifierMatrice(5, 1, "O");
//        test.ModifierMatrice(1, 4, "X");
//        test.ModifierMatrice(3, 8, "O");
//        test.ModifierMatrice(2, 5, "X");
        test.AfficherPlateau();
        String i = test.ObtenirValeurMatrice(-1, -1);
        System.out.print("test" + i);

        Joueur toto[] = new Joueur[4];
        toto[0] = new Joueur("coycou");
        toto[1] = new Joueur("coycou");
        toto[2] = new Joueur("coycou");
        toto[3] = new Joueur("coycou");
    }
}
