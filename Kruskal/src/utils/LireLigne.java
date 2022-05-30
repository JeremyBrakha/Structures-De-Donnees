package utils;

import models.Arete;
import models.Graphe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class LireLigne {

    /***
     * Retourne un entier choisi aléatoirement selon une loi uniforme
     * entre les valeurs min (incluse) et max (incluse)
     * Utilise la fonction Math.Random() qui
     * renvoie un double tiré aléatoirement selon une loi uniforme entre les
     * valeurs 0 inclus et 1 exclus :
     * 0 <= Math.Random() < 1
     * 
     * @param min
     * @param max
     * @return l'entier généré aléatoirement
     */
    public static int entierAleatoire(int min, int max) {
        //
        return min + (int) Math.floor(Math.random() * (max - min + 1));
    }

    public static void main(String[] argv) throws IOException {
        BufferedReader lecteurAvecBuffer = null;
        String ligne;
        //String exempleCheminWindows = "C:\\Users\\Eric Soutil\\Desktop\\essai.csv";
        String exempleCheminLinux = "/home/user/Téléchargements/graphe.txt";
        try {
            lecteurAvecBuffer = new BufferedReader(new FileReader(exempleCheminLinux));
            if((ligne = lecteurAvecBuffer.readLine()) == null) {
                System.out.println("Fichier vide");
            }

            String[] tab = ligne.split(" ");
            int[][] data = new int[tab.length][tab.length];
            for(int i = 0; i < tab.length ; i++){
                data[0][i] = Integer.parseInt(tab[i]);
            }
            int k = 1;
            while ((ligne = lecteurAvecBuffer.readLine()) != null) {
                //System.out.println(ligne);
                tab = ligne.split(" ");
                for (int i = 0; i < tab.length; i++) {
                    data[k][i] = Integer.parseInt(tab[i]);
                }
                k += 1;
            }
            lecteurAvecBuffer.close();

            System.out.println("\nFichier graph:");
            for(int i = 0; i < data.length; i++){
                for(int j = 0; j < data[i].length; j++){
                    System.out.print(" " + data[i][j]);
                }
                System.out.println(" ");
            }

            Graphe g = new Graphe();
            for(int i = 0; i < data.length; i++){
                g.ajoutSommet(i);
            }
            for(int i = 0; i < data.length; i++){
                for(int j = 0; j < data[i].length; j++){
                    if(data[i][j] > 0){
                        Arete a = new Arete(i, j, data[i][j]);
                        if(!g.contientArete(a))
                            g.ajoutArete(a);
                    }
                }
            }
            System.out.println("\nGraph créé:");
            g.afficheGraphe();


        } catch (FileNotFoundException exc) {
            System.out.println("Erreur d'ouverture");
        } catch (Exception arr) {
            System.out.println("Erreur lors de l'ajout d'arête");
        }

    }
}
