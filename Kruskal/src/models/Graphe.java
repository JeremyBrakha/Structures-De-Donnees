package models;

import java.util.*;

public class Graphe {

    private ArrayList<Arete> list_aretes;
    private ArrayList<Integer> list_sommets;

    public Graphe() {
        this.list_aretes = new ArrayList<>();
        this.list_sommets = new ArrayList<>();
    }

    public void ajoutArete(Arete a) {
        if (!this.contientArete(a)) {
            this.list_aretes.add(a);
        }
    }

    public void ajoutSommet(int s) {
        if (!this.list_sommets.contains(s)) this.list_sommets.add(s);
    }

    public boolean contientSommet(int new_so) {
        for (Integer i : this.list_sommets) {
            if (i == new_so) return true;
        }
        return false;
    }

    public boolean contientArete(Arete new_ar) {
        for (Arete a : this.list_aretes) {
            if (a.getSommet1() == new_ar.getSommet1() && a.getSommet2() == new_ar.getSommet2() && a.getPoids() == new_ar.getPoids())
                return true;
        }
        return false;
    }

    public Graphe creerBasicGraph(int taille_max) {

        for (int i = 0; i < taille_max; i++) {
            this.ajoutSommet(i);
        }

        return null;
    }

}
