package com.marsRovers;


import java.util.List;


public class Rover {

    private Position position;

    private List<String> instructions;

    public Rover(Position position, List<String> instructions) {
        this.position = position;
        this.instructions = instructions;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }


    public void move(Position position, Plateau plateau) throws PlateauOutOfBoundsException{
        char direction = position.getDirection();

        switch (direction){
            case 'N':
                if (position.exceedNorthLimit(plateau)) {
                    throw new PlateauOutOfBoundsException("Rover position exceed Northern limit of the Plateau");
                }
                moveNorth(position);
                break;
            case 'E':
                if (position.exceedEastLimit(plateau)) {
                    throw new PlateauOutOfBoundsException("Rover position exceed Eastern limit of the Plateau");
                }
                moveEast(position);
                break;
            case 'W':
                if (position.exceedWestLimit()) {
                    throw new PlateauOutOfBoundsException("Rover position exceed Western limit of the Plateau");
                }
                moveWest(position);
                break;
            case 'S':
                if (position.exceedSouthLimit()) {
                    throw new PlateauOutOfBoundsException("Rover position exceed Southern limit of the Plateau");
                }
                moveSouth(position);
                break;
        }
        //System.out.println("output : "+ this.getPosition().getX()+" "+ this.getPosition().getY()+" "+this.getPosition().getDirection()+" ");
    }

    private void moveSouth(Position position) {
        int y = position.getY();
        y--;
        position.setY(y);
    }

    private void moveWest(Position position) {
        int x = position.getX();
        x--;
        position.setX(x);
    }

    private void moveEast(Position position) {
        int x = position.getX();
        x++;
        position.setX(x);
    }

    private void moveNorth(Position position) {
        int y = position.getY();
        y++;
        position.setY(y);
    }

    public void rotateLeft(Position position) {
        switch (position.getDirection()){
            case 'N':
                position.setDirection('W');
                break;
            case 'W':
                position.setDirection('S');
                break;
            case 'S':
                position.setDirection('E');
                break;
            case 'E':
                position.setDirection('N');
                break;
            default:
                    break;
        }
    }
    public void rotateRight(Position position) {
        switch (position.getDirection()){
            case 'N':
                position.setDirection('E');
                break;
            case 'E':
                position.setDirection('S');
                break;
            case 'S':
                position.setDirection('W');
                break;
            case 'W':
                position.setDirection('N');
                break;
            default:
                break;
        }
    }
}