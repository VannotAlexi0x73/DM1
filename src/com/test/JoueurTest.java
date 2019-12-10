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
    public void setPrenom() {
        j.setPrenom("Paul");
        assertEquals("Paul", j.getPrenom());
    }

    @Test
    public void setCaractere() {
        j.setCaractere("R");
        assertEquals("R", j.getCaractere());
    }

    @Test
    public void getPrenom() {
        j.setPrenom("Patrick");
        assertEquals("Patrick", j.getPrenom());
    }

    @Test
    public void getCaractere() {
        j.setCaractere("J");
        assertEquals("J", j.getCaractere());
    }
}