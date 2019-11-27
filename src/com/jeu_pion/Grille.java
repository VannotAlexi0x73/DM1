package com.jeu_pion;

public class Grille {
    private char value;
    private char status;

    public void SetValue(char value) { this.value = value; }
    public void SetStatus(char status) { this.status = status; }
    public char GetValue() { return this.value; }
    public char GetStatus() { return this.status; }
}
