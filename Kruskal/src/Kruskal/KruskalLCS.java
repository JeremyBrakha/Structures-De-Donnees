package kruskal;

import models.Graphe;
import unionFile.UnionFindLS;

import java.util.List;
import java.util.Scanner;

public class KruskalLCS {
    public static void main(String[] args) throws Exception {
        Graphe graphePeuDense = new Graphe();
        Graphe graphetresDense = new Graphe();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ecrire un nombre (10, 100 ou 1000): ");
        int nSommets = sc.nextInt();
        graphePeuDense.creerGraphPeuDense(nSommets);
        graphetresDense.creerGraphTresDense(nSommets);
        graphePeuDense.afficheGraphe();
        graphetresDense.afficheGraphe();

        UnionFindLS ufls = new UnionFindLS();
        List<Integer> sommetsGraphePeuDense = graphePeuDense.getSommet();
        List<Integer> sommetsGrapheTresDense = graphetresDense.getSommet();
        for (int sommet : sommetsGraphePeuDense) {
            ufls.makeSet(sommet);
        }

        for (int sommet : sommetsGrapheTresDense) {
            ufls.makeSet(sommet);
        }

    }
}
