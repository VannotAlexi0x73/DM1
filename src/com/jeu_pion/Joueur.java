package com.jeu_pion;

/**
 * Classe Joueur
 * @author : Alexis V.
 * @version : 1.0
 */
public class Joueur {
    private String prenom;
    private String caractere;


    /**
     * Permet de créer un joueur en renseignant directement son prénom et son caractère
     * @param prenom : prénom du joueur
     * @param caractere : caractère du joueur
     */
    public Joueur(String prenom, String caractere)
    {
        this.prenom = prenom;
        this.caractere = caractere;
    }


    /**
     * Permet de changer le prénom du joueur passé en paramètre
     * @param prenom : nouveau prénom du joueur
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    /**
     * Méthode qui enregistre le caractère que le Joueur a choisi pour ses "pions"
     * @param caractere : caractère choisi par le Joueur
     */
    public void setCaractere(String caractere) {
        this.caractere = caractere;
    }


    /**
     * Permet d'obtenir le prénom du Joueur
     * @return : prénom du joueur
     */
    public String getPrenom() {
        return this.prenom;
    }


    /**
     * Permet d'obtenir le caractère que le joueur a choisi
     * @return : caractère du joueur
     */
    public String getCaractere() {
        return this.caractere;
    }
}
