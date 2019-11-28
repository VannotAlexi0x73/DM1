package com.jeu_pion;

public class Joueur {
    private String prenom;
    private String caractere;

    public Joueur(String prenom) { this.prenom = prenom; }

    public void EnregistrerPrenom(String prenom) { this.prenom = prenom; }
    public void EnregistrerCaractere(String caractere) { this.caractere = caractere; }
    public String ObtenirPrenom(String prenom) { return this.prenom; }
    public String ObtenirCaractere(String caractere) { return this.caractere; }
}
