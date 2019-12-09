package com.jeu_pion;

public class Main {

    public static void main(String[] args) {
        Plateau test = new Plateau(10, 3);

        for (int i = 1; i < test.getLigneMatricePlateau(); i++)
        {
            for (int j = 0; j < test.getColonneMatricePlateau(); j++)
            {
                test.modifierMatricePlateau(i, j, "c");
            }
        }

        test.afficherPlateau();
    }
}
