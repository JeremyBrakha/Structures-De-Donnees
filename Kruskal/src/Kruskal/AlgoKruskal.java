package kruskal;

import java.util.Comparator;

import models.*;

public class AlgoKruskal {

    public void kruskal(Graphe g) {
        int k = 0;
        g.getArete().sort(Comparator.comparingInt(Arete::getPoids));
        while (k < g.getSommet().size() - 1) {
            for (int i = 0; i < g.getArete().size(); i++) {

            }
        }

    }
}
