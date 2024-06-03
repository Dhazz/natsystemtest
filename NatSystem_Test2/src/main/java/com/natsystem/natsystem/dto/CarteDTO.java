package com.natsystem.natsystem.dto;


import com.natsystem.natsystem.enums.CouleursCarte;

public class CarteDTO {
    CouleursCarte couleur;
    String valeur;

    public CarteDTO(){};
    public CarteDTO(CouleursCarte couleur, String valeur){
        this.couleur = couleur;
        this.valeur = valeur;
    };

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
