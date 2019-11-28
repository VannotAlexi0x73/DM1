package com.jeu_pion;

public class Plateau {

    private String matrice [][];
    private int ligne;
    private int colonne;

    /**
     * TODO
     * @param i
     * @param j
     */
    public Plateau(int i, int j)
    {
        if ((i != 0) && (j != 0))
        {
            this.matrice = new String[i][j];
            this.ligne = i;
            this.colonne = j;
        }
    }

    /**
     * TODO
     */
    public void AfficherPlateau()
    {
        // First line display
        System.out.print("\n   ");
        for (int i = 0; i < this.colonne; i++)
        {
            if (i % 5 == 0)
            {
                System.out.print(" " + i / 10 + "  ");
            }
            else {
                System.out.print("    ");
            }
        }

        // Second line display
        System.out.print("\n   ");
        for (int i = 0; i < this.colonne; i++)
        {
            System.out.print(" " + i % 10 + "  ");
        }

        // Third line display
        System.out.print("\n   ");
        for (int i = 0; i < this.colonne; i++)
        {
            System.out.print("----");
        }


        System.out.println();
        // Matrix display
        for (int i = 0; i < this.ligne; i++)
        {
            System.out.printf("%2d|", i);
            for (int j = 0; j < this.colonne; j++)
            {
                if (this.matrice[i][j] != null)
                {
                    System.out.print(" " + this.matrice[i][j] + " ");
                }
                else
                {
                    System.out.print("   ");
                }
                System.out.print("|");
            }
            System.out.print("\n");
        }

        // Last line display
        System.out.print("   ");
        for (int i = 0; i < this.colonne; i++)
        {
            System.out.print("----");
        }
    }

    /**
     * TODO
     * @param i : It's the matrix line number
     * @param j : It's the matrix column number
     * @param valeur : It's the value to add to the matrix
     * @return : -1 Error code / 1 No error
     */
    public int ModifierMatrice(int i, int j, String valeur)
    {
       if ((i >= 0) && (j >= 0))
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
     * TODO
     * @param i : It's the matrix line number
     * @param j : It's the matrix column number
     * @return TODO
     */
    public String ObtenirValeurMatrice(int i, int j)
    {
        if (i >= 0 && j >= 0)
        {
            return this.matrice[i][j];
        }
        else
        {
            return "e";
        }
    }
}
