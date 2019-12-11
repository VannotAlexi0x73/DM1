package com.jeu_pion;

/**
 * Classe Plateau
 * @author : Alexis V
 * @version : 1.0
 */
public class Plateau {

    private String [][] matrice;
    private int ligne;
    private int colonne;


    /**
     * Permet de créer une matrice : String de taille [i][j]
     * @param i : nombre de ligne de la matrice à créer
     * @param j : nombre de colonne de la matrice à créer
     */
    public Plateau(int i, int j)
    {
        if ((i > 0) && (j > 0))
        {
            this.matrice = new String[i][j];
            this.ligne = i;
            this.colonne = j;
        }
    }


    /**
     * Permet de modifier la matrice en y insérant une valeur à la position [i][j]
     * @param i : numéro de la ligne à modifier
     * @param j : numéro de la colonne à modifier
     * @param valeur : valeur à ajouter à la matrice aux coordonnées [i][j]
     * @return -1 si erreur sinon 1
     */
    public int modifierMatricePlateau(int i, int j, String valeur)
    {
       if ((i >= 0) && (j >= 0) && (i < this.ligne ) && (j < this.colonne))
       {
           this.matrice[i][j] = valeur;
           return 1;
       }
       else
       {
           return -1;
       }
    }


    /**
     * Permet d'obtenir la valeur enregistrer dans la matrice aux coordonnées [i][j]
     * @param i : numéro de la ligne de la valeur à récupérer
     * @param j : numéro de la colonne de la valeur à récupérer
     * @return "error" si erreur sinon valeur aux coordonnées [i][j]
     */
    public String obtenirValeurMatricePlateau(int i, int j)
    {
        if ((i >= 0) && (j >= 0) && (i < this.colonne) && (j < this.ligne))
        {
            return this.matrice[i][j];
        }
        else
        {
            return "error";
        }
    }


    /**
     * Permet de vérifier si la matrice a été complètement utilisée ou non
     * @return true si la matrice est complète ou false s'il reste des cases disponibles
     */
    public Boolean isMatricePlateauComplete()
    {
        for (String [] i: this.matrice)
        {
            for (String j : i)
            {
                if (j == null)
                {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * Permet d'obtenir le nombre de lignes du plateau
     * @return le nombre de lignes du plateau
     */
    public int getLigneMatricePlateau() {
        return this.ligne;
    }


    /**
     * Permet d'obtenir le nombre de colonnes du plateau
     * @return le nombre de colonnes du plateau
     */
    public int getColonneMatricePlateau() {
        return this.colonne;
    }
}
