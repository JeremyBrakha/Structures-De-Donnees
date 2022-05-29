package kruskal;

import java.util.ArrayList;
import java.util.Comparator;

import models.*;
import unionFile.UnionFindLS;

public class AlgoKruskal {

    public void kruskal(Graphe g) {
        UnionFindLS ufls = new UnionFindLS();
        int k = 0;
        g.getArete().sort(Comparator.comparingInt(Arete::getPoids));
        while (k < g.getSommet().size() - 1) {
            for (int i = 0; i < g.getArete().size(); i++) {
                Arete arete = g.getArete().get(i);
                if (ufls.find(arete.getSommet1()) != ufls.find(arete.getSommet2())) {
                    // ufls.union();
                }
            }
            k++;
        }
    }
}
