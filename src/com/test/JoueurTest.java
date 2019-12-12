package com.test;

import com.jeu_pion.Joueur;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JoueurTest {

    private static Joueur j;

    @Before
    public void setUp() throws Exception {
        j = new Joueur("Alexis", "X");
    }

    @Test
    public void getPrenom() {
        assertSame("Alexis", j.getPrenom());
    }

    @Test
    public void getCaractere() {
        assertSame("X", j.getCaractere());
    }
}
