package kruskal;

import models.Graphe;

import java.util.Scanner;

public class KruskalLCS {
    public static void main(String[] args) throws Exception {
        Graphe g = new Graphe();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ecrire un nombre (10, 100 ou 1000): ");
        int nSommets = sc.nextInt();
        g.creerGraphTresDense(nSommets);
        g.afficheGraphe();
    }
}
