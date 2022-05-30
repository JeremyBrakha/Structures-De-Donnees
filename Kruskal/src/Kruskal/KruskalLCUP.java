package Kruskal;

import models.Arete;
import models.Graphe;
import unionFile.UnionFindUP;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class KruskalLCUP {
    public static void kruskalPeuDense() throws Exception {
        long debutInstance = System.currentTimeMillis();
        Graphe g = new Graphe();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ecrire un nombre (10, 100 ou 1000): ");
        int nSommets = sc.nextInt();
        g.creerGraphPeuDense(nSommets);
        g.afficheGraphe();

        UnionFindUP ufls = new UnionFindUP();

        for (int sommet : g.getSommet()) {
            ufls.makeSet(sommet);
        }
        ufls.affichePartition();

        ArrayList<Arete> bestArete = new ArrayList<>();

        // algorithme de Kruskal
        long debutTri = System.currentTimeMillis();
        int k = 0;
        g.getArete().sort(Comparator.comparingInt(Arete::getPoids));
        while (k < g.getSommet().size() - 1) {
            System.out.println(k);
            for (int i = 0; i < g.getArete().size(); i++) {
                Arete arete = g.getArete().get(i);
                if (ufls.find(arete.getSommet1()) != ufls.find(arete.getSommet2())) {
                    System.out.println("Poids de la prochaine arête : " + arete.getPoids());
                    ufls.union(arete.getSommet1(), arete.getSommet2());
                    bestArete.add(arete);
                    break;
                }
            }
            ufls.affichePartition();
            System.out.println("\nMeilleur chemin : ");
            int poidsTotal = 0;
            for (Arete a : bestArete) {
                a.afficheArete();
                poidsTotal += a.getPoids();
            }
            System.out.println("Poids total du meilleur chemin : " + poidsTotal);
            k++;
        }
        System.out.println("Temps de résolution du tri des arêtes : " + (System.currentTimeMillis() - debutTri)
                + " millisecondes");

        System.out.println("Temps de résolution global de l'instance : " + (System.currentTimeMillis() - debutInstance)
                + " millisecondes");
    }

    public static void kruskalTresDense() throws Exception {
        long debutInstance = System.currentTimeMillis();
        Graphe g = new Graphe();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ecrire un nombre (10, 100 ou 1000): ");
        int nSommets = sc.nextInt();
        g.creerGraphTresDense(nSommets);

        UnionFindUP ufls = new UnionFindUP();

        for (int sommet : g.getSommet()) {
            ufls.makeSet(sommet);
        }

        ArrayList<Arete> bestArete = new ArrayList<>();

        // algorithme de Kruskal
        long debutTri = System.currentTimeMillis();
        int k = 0;
        g.getArete().sort(Comparator.comparingInt(Arete::getPoids));
        while (k < g.getSommet().size() - 1) {
            System.out.println(k);
            for (int i = 0; i < g.getArete().size(); i++) {
                Arete arete = g.getArete().get(i);
                if (ufls.find(arete.getSommet1()) != ufls.find(arete.getSommet2())) {
                    System.out.println("Poids de la prochaine arête : " + arete.getPoids());
                    ufls.union(arete.getSommet1(), arete.getSommet2());
                    bestArete.add(arete);
                    break;
                }
            }
            ufls.affichePartition();
            System.out.println("\nMeilleur chemin : ");
            int poidsTotal = 0;
            for (Arete a : bestArete) {
                a.afficheArete();
                poidsTotal += a.getPoids();
            }
            System.out.println("Poids total du meilleur chemin : " + poidsTotal);
            k++;
        }
        System.out.println("Temps de résolution du tri des arêtes : " + (System.currentTimeMillis() - debutTri)
                + " millisecondes");

        System.out.println("Temps de résolution global de l'instance : " + (System.currentTimeMillis() - debutInstance)
                + " millisecondes");
    }

    public static void main(String[] args) throws Exception {
        kruskalTresDense();
    }
}
