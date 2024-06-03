package com.natsystem.natsystem.dto;


import com.natsystem.natsystem.enums.CouleursCarte;

import java.io.Serializable;

public class CarteDTO implements Serializable {
    CouleursCarte couleur;
    String valeur;
    String imageUrl;

    public CarteDTO(){};
    public CarteDTO(CouleursCarte couleur, String valeur, String imageUrl){
        this.couleur = couleur;
        this.valeur = valeur;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
