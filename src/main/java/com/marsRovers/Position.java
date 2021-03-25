package com.marsRovers;

public class Position {
    private int x;
    private int y;
    private char direction;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public Position(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }


    public boolean exceedNorthLimit(Plateau plateau) {
        int hauteurPlateau = plateau.getHauteur();
        return (this.y == hauteurPlateau); //si la position actuelle y du rover égale à la hauteurplateau donc on va depasser la limite nord
    }

    public boolean exceedEastLimit(Plateau plateau) {
        int largeurPlateau = plateau.getLargeur();
        return (this.x == largeurPlateau);
    }

    public boolean exceedWestLimit() {
        return (this.x == 0);
    }

    public boolean exceedSouthLimit() {
        return (this.y == 0);
    }
}