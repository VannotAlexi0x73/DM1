package com.test;

import com.jeu_pion.Plateau;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlateauTest {

    static Plateau p;

    @Before
    public void setUp() throws Exception {
        p = new Plateau(10, 10);
        for (int i = 0; i < p.getLigneMatricePlateau(); i++) {
            for (int j = 0; j < p.getColonneMatricePlateau() ; j++) {
                p.modifierMatricePlateau(i, j, "C");
            }
        }
        p.modifierMatricePlateau(9, 9, null);
    }

    @Test
    public void afficherPlateau() {
        p.afficherPlateau();
    }

    @Test
    public void modifierMatricePlateau() {
        assertTrue(p.modifierMatricePlateau(3, 3, "m") == 1);
        assertTrue(p.modifierMatricePlateau(6, 2, "Z") == 1);
        assertFalse(p.modifierMatricePlateau(6, -2, "Z") == 1);
        assertTrue(p.modifierMatricePlateau(6, -2, "Z") == -1);
    }

    @Test
    public void obtenirValeurMatricePlateau() {
        assertTrue(p.obtenirValeurMatricePlateau(1, 1) == "C");
        p.modifierMatricePlateau(8, 5, "K");
        assertTrue(p.obtenirValeurMatricePlateau(8, 5) == "K");
        assertTrue(p.obtenirValeurMatricePlateau(8, -5) == "error");
    }

    @Test
    public void isMatricePlateauComplete() {
        assertTrue(!p.isMatricePlateauComplete());
        p.modifierMatricePlateau(9, 9, "C");
        assertTrue(p.isMatricePlateauComplete());
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