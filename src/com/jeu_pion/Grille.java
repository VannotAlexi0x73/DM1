package com.jeu_pion;

public class Grille {
    private char value;
    private char status;
    
    public void SetValue(char value) { this.value = value; }
    public void SetStatus(char status) { this.status = status; }
    public char GetValue(char value) { return this.value; }
    public char GetStatus(char status) { return this.status; }
}
