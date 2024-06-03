package com.natsystem1.dto;

import com.natsystem1.enums.CouleursCarte;

public class Carte {
    CouleursCarte couleur;
    String valeur;

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public CouleursCarte getCouleur() {
        return couleur;
    }

    public void setCouleur(CouleursCarte couleur) {
        this.couleur = couleur;
    }
}
