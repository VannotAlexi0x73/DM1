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
     * Permet d'afficher le plateau sous forme de pseudo tableau dans la console
     * La première et deuxième ligne correspondent aux numéros des colonnes
     * Les premiers chiffres de chaque lignes correspondent aux numéros des lignes
     * @param plateau : plateau de jeu
     */
    @Override
    public void affichagePlateau(Plateau plateau)
    {
        String displaySpaces = "\n   ";
        StringBuilder str = new StringBuilder();

        // On formatte première ligne
        str.append(displaySpaces);
        for (int i = 0; i < plateau.getColonneMatricePlateau(); i++)
        {
            if (i % 5 == 0)
            {
                str.append(String.format(" %d  ", i / 10));
            }
            else {
                str.append("    ");
            }
        }

        // On formatte la deuxième ligne
        str.append(displaySpaces);
        for (int i = 0; i < plateau.getColonneMatricePlateau(); i++)
        {
            str.append(String.format(" %d  ", i % 10));
        }

        // On formatte la troisième ligne
        str.append(displaySpaces);
        str.append("----".repeat(Math.max(0, plateau.getColonneMatricePlateau())));
        str.append("\n");


        // On formatte le tableau
        for (int i = 0; i < plateau.getLigneMatricePlateau(); i++)
        {
            str.append(String.format("%2d|", i));
            for (int j = 0; j < plateau.getColonneMatricePlateau(); j++)
            {
                if (plateau.obtenirValeurMatricePlateau(i, j) != null)
                {
                    str.append(String.format(" %s ", plateau.obtenirValeurMatricePlateau(i, j)));
                }
                else
                {
                    str.append("   ");
                }
                str.append("|");
            }
            str.append("\n");
        }

        // On formatte la dernière ligne
        str.append("   ");
        str.append("----".repeat(Math.max(0, plateau.getColonneMatricePlateau())));


        // Affichage du tableau
        affichageElement(str.toString());
    }
}
