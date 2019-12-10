package com.test;

import com.jeu_pion.Affichable;
import com.jeu_pion.AffichageConsole;
import com.jeu_pion.Plateau;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AffichageConsoleTest {

    static Plateau p;
    static String str;
    static Affichable affichable = new AffichageConsole();


    @Before
    public void setUp() throws Exception {
        p = new Plateau(10, 10);
        str = "Test de la classe AffichageConsole";

        for (int i = 0; i < p.getLigneMatricePlateau(); i++) {
            for (int j = 0; j < p.getColonneMatricePlateau() ; j++) {
                p.modifierMatricePlateau(i, j, "C");
            }
        }
        p.modifierMatricePlateau(9, 9, null);
    }

    @Test
    public void affichageElement() {
        affichable.affichageElement(str);
    }

    @Test
    public void affichagePlateau() {
        affichable.affichagePlateau(p);
    }
}