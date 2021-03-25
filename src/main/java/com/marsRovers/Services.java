package com.marsRovers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Services {
    static Plateau plateau  = new Plateau(0,0); //a verifier
    static Position position = new Position(0,0,'N');
    static List<String> list = new ArrayList<String>();
    static Rover rover = new Rover(position,list);


    public static void readAndExtractFile(String fichierSource) {
        String ligne ;
        int nbreLignes = 0;

        //lecture
        try {
            BufferedReader fichier = new BufferedReader(new FileReader(fichierSource));
            while ((ligne = fichier.readLine()) != null) {
                nbreLignes++;
                if(nbreLignes == 1){ //premiere ligne
                    extractPlateauDimensions(ligne);
                    continue;
                }else{
                    if(nbreLignes%2 == 0) {//ligne pair
                        extractRoverPosition(ligne);
                        continue;

                    }else //ligne impair
                        extractRoverInstructions(ligne);
                        executeInstructions();
                }
                System.out.println("output : "+ rover.getPosition().getX()+" "+ rover.getPosition().getY()+" "+rover.getPosition().getDirection()+" ");

            }
            fichier.close();
        } catch (Exception e) {
            System.out.println("fichier Input.txt vide");

            e.printStackTrace();
        }
    }

    private static  void executeInstructions() {
        rover.getInstructions().forEach(instruction -> {
            switch (instruction){
                case "M":
                    try {
                        rover.move(position,plateau);

                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                case "L":
                    rover.rotateLeft(position);
                    break;
                case "R":
                    rover.rotateRight(position);
                    break;
                default:
                    System.out.println("can not resolve instruction "+instruction+"for rover");
            }
        });
    }


    private static void extractRoverPosition(String ligne) {
        String str[] = ligne.split(" ");
        list = Arrays.asList(str);

        rover.getPosition().setX(Integer.valueOf(list.get(0)));
        rover.getPosition().setY(Integer.valueOf(list.get(1)));
        rover.getPosition().setDirection(list.get(2).charAt(0));
    }

    private static void extractRoverInstructions(String ligne) {
        String str[] = ligne.split("");
        List<String> list = Arrays.asList(str);
        rover.setInstructions(list);
        System.out.println(rover.getInstructions());

    }

    private static  void extractPlateauDimensions(String ligne) {
        String str[] = ligne.split(" ");
        List<String> list = Arrays.asList(str);

            plateau.setHauteur(Integer.valueOf(list.get(0)));
            plateau.setLargeur(Integer.valueOf(list.get(1)));
            System.out.println(plateau.getHauteur()+" "+plateau.getLargeur());
    }

    private static int extractNbreRovers(int nbreLignes) {
        if(nbreLignes>0) {
            return (nbreLignes - 1) / 2;
        }
        return  0;
    }

    public static int readAndGetNbreRovers(String fichierSource) {
        int nbreLignes = 0;
        int nbreRovers = 0;
        String ligne ;

        try {
            BufferedReader fichier = new BufferedReader(new FileReader(fichierSource));
            while ((ligne = fichier.readLine()) != null) {
                nbreLignes++;
            }
            fichier.close();
    } catch (Exception e) {
        System.out.println("fichier Input.txt vide");

        e.printStackTrace();
    }

    nbreRovers = extractNbreRovers(nbreLignes);
    return nbreRovers;
}
}