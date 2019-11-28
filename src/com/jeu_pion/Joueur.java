package com.jeu_pion;

public class Joueur {
    private String prenom;
    private String caractere;

    /**
     * Permet de créer un Joueur en renseignant directement son prenom
     * @param prenom : prenom du Joueur
     */
    public Joueur(String prenom) { this.prenom = prenom; }

    /**
     * Permet de changer le prénom d'un Joueur
     * @param prenom : nouveau prenom du Joueur
     */
    public void EnregistrerPrenom(String prenom) { this.prenom = prenom; }

    /**
     * Méthode qui enregistre le caractère que le joueur a choisi pour ses "pions"
     * @param caractere :
     */
    public void EnregistrerCaractere(String caractere) { this.caractere = caractere; }

    /**
     * Permet d'obtenir le nom du Joueur
     * @return : prenom du Joueur
     */
    public String ObtenirPrenom() { return this.prenom; }

    /**
     * Permet d'obtenir le caractère que le Joueur a choisi
     * @return : caractère du Joueur
     */
    public String ObtenirCaractere() { return this.caractere; }
}
