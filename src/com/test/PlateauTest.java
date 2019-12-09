package com.test;

import com.jeu_pion.Plateau;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlateauTest {

    static Plateau p;
    static Plateau p2;

    @Before
    public void setUp() throws Exception {
        p = new Plateau(10, 10);
        p2  = new Plateau(10, 10);
        for (int i = 0; i < p.getLigneMatricePlateau(); i++) {
            for (int j = 0; j < p.getColonneMatricePlateau() ; j++) {
                p.modifierMatricePlateau(i, j, "C");
            }
        }
    }

    @Test
    public void afficherPlateau() {
        p.afficherPlateau();
    }

    @Test
    public void modifierMatricePlateau() {
        p.modifierMatricePlateau(3, 3, "m");
        assertTrue(p.obtenirValeurMatricePlateau(3, 3) == "m");
        p.modifierMatricePlateau(6, 2, "Z");
        assertTrue(p.obtenirValeurMatricePlateau(6, 2) == "Z");
    }

    @Test
    public void obtenirValeurMatricePlateau() {
        assertTrue(p.obtenirValeurMatricePlateau(1, 1) == "C");
        p.modifierMatricePlateau(8, 5, "K");
        assertTrue(p.obtenirValeurMatricePlateau(8, 5) == "K");
    }

    @Test
    public void isMatricePlateauComplete() {
        assertTrue(p.isMatricePlateauComplete());
        assertTrue(!p2.isMatricePlateauComplete());
    }

    @Test
    public void getLigneMatricePlateau() {
        assertTrue(p.getLigneMatricePlateau() == 10);
    }

    @Test
    public void getColonneMatricePlateau() {
        assertTrue(p.getColonneMatricePlateau() == 10);
    }
}