package com.jeu_pion;

/**
 * Interface Affichable
 * @author : Alexis V
 * @version : 1.0
 */
public interface Affichable {

    /**
     * Afficher une chaîne de caractères sans retour à la ligne passé en paramètre
     * @param element : chaîne de caractères qu'on veut afficher
     */
    public void affichageElement(String element);


    /**
     * Afficher le plateau de jeu passé en paramètre
     * @param plateau : plateau de jeu qu'on souhaite afficher
     */
    public void affichagePlateau(Plateau plateau);
}
