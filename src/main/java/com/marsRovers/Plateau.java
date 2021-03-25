package com.marsRovers;

import java.util.ArrayList;

public class Plateau {

    private int hauteur;
    private int largeur;
    private int nbreRovers;
    private ArrayList<Rover> roversList;



    public int getHauteur() {
        return hauteur;
    }


    public Plateau(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getNbreRovers() {
        return nbreRovers;
    }

    public void setNbreRovers(int nbreRovers) {
        this.nbreRovers = nbreRovers;
    }


}