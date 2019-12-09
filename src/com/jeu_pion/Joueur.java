package com.jeu_pion;

public class Joueur {
    private String prenom;
    private String caractere;

    /**
     * Permet de créer un Joueur en renseignant directement son prénom
     * @param prenom : prénom du Joueur
     */
    public Joueur(String prenom) { this.prenom = prenom; }

    /**
     * Permet de changer le prénom d'un Joueur
     * @param prenom : nouveau prénom du Joueur
     */
    public void modifierPrenom(String prenom) { this.prenom = prenom; }

    /**
     * Méthode qui enregistre le caractère que le Joueur a choisi pour ses "pions"
     * @param caractere : caractère choisi par le Joueur
     */
    public void enregistrerCaractere(String caractere) { this.caractere = caractere; }

    /**
     * Permet d'obtenir le prénom du Joueur
     * @return : prénom du Joueur
     */
    public String ObtenirPrenom() { return this.prenom; }

    /**
     * Permet d'obtenir le caractère que le Joueur a choisi
     * @return : caractère du Joueur
     */
    public String ObtenirCaractere() { return this.caractere; }
}
