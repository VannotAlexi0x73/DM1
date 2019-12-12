package com.test;

import com.jeu_pion.Plateau;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlateauTest {

    private static Plateau p;

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
    public void modifierMatricePlateau() {
        assertEquals(1, p.modifierMatricePlateau(3, 3, "m"));
        assertEquals(1, p.modifierMatricePlateau(6, 2, "Z"));
        assertNotEquals(1, p.modifierMatricePlateau(6, -2, "Z"));
        assertEquals(-1, p.modifierMatricePlateau(-6, -2, "Z"));
        assertEquals(-1, p.modifierMatricePlateau(-6, 2, "Z"));
    }

    @Test
    public void obtenirValeurMatricePlateau() {
        assertSame("C", p.obtenirValeurMatricePlateau(1, 1));
        p.modifierMatricePlateau(8, 5, "K");
        assertSame("K", p.obtenirValeurMatricePlateau(8, 5));
        assertSame("error", p.obtenirValeurMatricePlateau(8, -5));
    }

    @Test
    public void isMatricePlateauComplete() {
        assertFalse(p.isMatricePlateauComplete());
        p.modifierMatricePlateau(9, 9, "C");
        assertTrue(p.isMatricePlateauComplete());
    }

    @Test
    public void getLigneMatricePlateau() {
        assertEquals(10, p.getLigneMatricePlateau());
    }

    @Test
    public void getColonneMatricePlateau() {
        assertEquals(10, p.getColonneMatricePlateau());
    }
}