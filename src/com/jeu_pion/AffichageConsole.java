package com.jeu_pion;

public class AffichageConsole implements Affichable {

    /**
     * Permet d'afficher une chaine de caractère formater dans la console
     * @param element : chaine de caractère à afficher en console
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
                str = "";
                str = str.format(" %d  ", i / 10);
                affichageElement(str);
            }
            else {
                affichageElement("    ");
            }
        }

        // Affichage deuxième migne
        affichageElement(displaySpaces);
        for (int i = 0; i < plateau.getColonneMatricePlateau(); i++)
        {
            str = "";
            str = str.format(" %d  ", i % 10);
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
            str = "";
            str = str.format("%2d|", i);
            affichageElement(str);
            for (int j = 0; j < plateau.getColonneMatricePlateau(); j++)
            {
                if (plateau.obtenirValeurMatricePlateau(i, j) != null)
                {
                    str = "";
                    str = str.format(" %s ", plateau.obtenirValeurMatricePlateau(i, j));
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

        // Affichage de la derniere ligne
        affichageElement("   ");
        for (int i = 0; i < plateau.getColonneMatricePlateau(); i++)
        {
            affichageElement("----");
        }
    }
}
