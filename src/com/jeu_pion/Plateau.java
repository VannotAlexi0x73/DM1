package com.jeu_pion;

public class Plateau {

    private Grille matrice [][];


    public Plateau(int i, int j)
    {
        if ((i != 0) && (j != 0))
        {
            this.matrice = new Grille[i][j];
        }
    }

    public void AfficherPlateau()
    {
        for (int i = 0; i < matrice.length; i++)
        {
            for (int j = 0; j < matrice[i].length; j++)
            {
                System.out.print(" | " + this.matrice[i][j]);
            }
            System.out.print(" |");
            System.out.println(" ");
        }
    }
}
