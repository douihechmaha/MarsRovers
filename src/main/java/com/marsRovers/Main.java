package com.marsRovers;


public class Main {

    public static void main (String[] args) throws Exception{
        //String fichierSource = args[1];//pour tester avec  le fichier de la ligne de commande

        String fichierSource ="input.txt";//pour tester avec le fichier enregisté dans le projet

        final Runner runner = new Runner();//pour traiter les threads

        int nbreRovers = Services.readAndGetNbreRovers(fichierSource); //lecture initiale du fichier pour déterminer nombre de threads
        System.out.println("nbre Rovers = "+ nbreRovers);



        for(int i =0;i<nbreRovers;i++) {
            Thread thread = new Thread(() -> {
                try{
                    runner.runThread(fichierSource);//lecture et extraction de données et application des instructions
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            });

            //System.out.println(thread.getName()+" starts working ...");
            thread.start();
            thread.join();
            //runner.finished();//affiche déja un message que le thread a fini
            //System.out.println(thread.getName());// affiche le nom de thread qui a fini

       }

    }
}