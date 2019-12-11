package com.jeu_pion;

/**
 * Classe AffichageConsole
 * @author : Alexis V
 * @version : 1.0
 */
public class AffichageConsole implements Affichable {

    /**
     * Permet d'afficher une chaîne de caractères formatée dans la console
     * @param element : chaîne de caractères à afficher en console
     */
    @Override
    public void affichageElement(String element) {
        System.out.print(element);
    }


    /**
     * Permet d'afficher la matrice sous forme de pseudo tableau dans la console
     * La première et deuxième ligne correspondent aux numéros des colonnes
     * Les premiers chiffres de chaque lignes correspondent aux numéros des lignes
     * @param plateau : plateau de jeu
     */
    @Override
    public void affichagePlateau(Plateau plateau)
    {
        String displaySpaces = "\n   ";
        String str;

        // Affichage première ligne
        affichageElement(displaySpaces);
        for (int i = 0; i < plateau.getColonneMatricePlateau(); i++)
        {
            if (i % 5 == 0)
            {
                str = String.format(" %d  ", i / 10);
                affichageElement(str);
            }
            else {
                affichageElement("    ");
            }
        }

        // Affichage deuxième ligne
        affichageElement(displaySpaces);
        for (int i = 0; i < plateau.getColonneMatricePlateau(); i++)
        {
            str = String.format(" %d  ", i % 10);
            affichageElement(str);
        }

        // Affichage troisième ligne
        affichageElement(displaySpaces);
        for (int i = 0; i < plateau.getColonneMatricePlateau(); i++)
        {
            affichageElement("----");
        }
        affichageElement("\n");


        // Affichage du tableau
        for (int i = 0; i < plateau.getLigneMatricePlateau(); i++)
        {
            str = String.format("%2d|", i);
            affichageElement(str);
            for (int j = 0; j < plateau.getColonneMatricePlateau(); j++)
            {
                if (plateau.obtenirValeurMatricePlateau(i, j) != null)
                {
                    str = String.format(" %s ", plateau.obtenirValeurMatricePlateau(i, j));
                    affichageElement(str);
                }
                else
                {
                    affichageElement("   ");
                }
                affichageElement("|");
            }
            affichageElement("\n");
        }

        // Affichage de la dernière ligne
        affichageElement("   ");
        for (int i = 0; i < plateau.getColonneMatricePlateau(); i++)
        {
            affichageElement("----");
        }
    }
}
