package utils;

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
     * @param min
     * @param max
     * @return l'entier généré aléatoirement
     */
    public static int entierAleatoire(int min, int max) {
        //
        return min + (int) Math.floor(Math.random()*(max-min+1));
    }



    public static void main(String[] argv) throws IOException {
        BufferedReader lecteurAvecBuffer=null;
        String ligne;
        String exempleCheminWindows = "C:\\Users\\Eric Soutil\\Desktop\\essai.csv";
        String exempleCheminLinux = "/home/jean/essai.csv";
        try {
            lecteurAvecBuffer = new BufferedReader(new FileReader(exempleCheminWindows));
            while ((ligne = lecteurAvecBuffer.readLine())!=null) {
                System.out.println(ligne);
                // ou traitement de la ligne : Exemple de split
                String[] tab = ligne.split(" ");
                int[] valeurLigne = new int[tab.length];
                for (int i = 0; i < valeurLigne.length; i++) {
                    valeurLigne[i] = Integer.parseInt(tab[i]);
                }
            }
            lecteurAvecBuffer.close();
        }
        catch(FileNotFoundException exc) {
            System.out.println("Erreur d'ouverture");
        }
    }
}
