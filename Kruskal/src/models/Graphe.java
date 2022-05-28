package models;

import utils.LireLigne;

import java.util.*;

public class Graphe {

    private ArrayList<Arete> list_aretes;
    private ArrayList<Integer> list_sommets;

    public Graphe() {
        this.list_aretes = new ArrayList<>();
        this.list_sommets = new ArrayList<>();
    }

    public ArrayList<Arete> getArete() {
        return this.list_aretes;
    }

    public ArrayList<Integer> getSommet() {
        return this.list_sommets;
    }

    public void ajoutArete(Arete a) throws Exception {
        if (!this.contientArete(a)) {
            this.list_aretes.add(a);
        } else {
            throw new Exception("Arête déjà créée");
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
            if (a.getSommet1() == new_ar.getSommet1() && a.getSommet2() == new_ar.getSommet2())
                return true;
            if (a.getSommet2() == new_ar.getSommet1() && a.getSommet1() == new_ar.getSommet2())
                return true;
        }
        return false;
    }

    public void creerBasicGraph(int taille_max) throws Exception {

        for (int i = 0; i < taille_max; i++) {
            this.ajoutSommet(i);
        }

        int rand_poids;
        for (int i = 0; i < taille_max - 1; i++) {
            rand_poids = LireLigne.entierAleatoire(1, 1000);
            Arete a = new Arete(this.list_sommets.get(i), this.list_sommets.get(i + 1), rand_poids);
            this.ajoutArete(a);
        }

    }

    public void creerGraphPeuDense(int taille_max) throws Exception {

        this.creerBasicGraph(taille_max);
        int nbAreteMax = 3 * taille_max;
        int rand_poids;
        int rand_s1;
        int rand_s2;
        Arete a;
        for (int i = 0; i < (nbAreteMax - (taille_max - 1)); i++) {

            rand_poids = LireLigne.entierAleatoire(1, 1000);
            //System.out.println(rand_poids);
            do {
                rand_s1 = LireLigne.entierAleatoire(0, taille_max - 1);
                rand_s2 = LireLigne.entierAleatoire(0, taille_max - 1);
                a = new Arete(this.list_sommets.get(rand_s1), this.list_sommets.get(rand_s2), rand_poids);
            } while (rand_s1 == rand_s2 || this.contientArete(a));

            //System.out.println(rand_s1 + " --- " + rand_s2);
            this.ajoutArete((a));
        }
    }

    public void creerGraphTresDense(int taille_max) throws Exception {

        this.creerBasicGraph(taille_max);
        int nbAreteMax =(int) Math.floor(Math.pow(taille_max, 2) / 3);
        int rand_poids;
        int rand_s1;
        int rand_s2;
        for (int i = 0; i < (nbAreteMax - (taille_max - 1)); i++) {

            rand_poids = LireLigne.entierAleatoire(1, 1000);
            System.out.println(rand_poids);
            Arete a;
            do {
                rand_s1 = LireLigne.entierAleatoire(0, taille_max - 1);
                rand_s2 = LireLigne.entierAleatoire(0, taille_max - 1);
                a = new Arete(this.list_sommets.get(rand_s1), this.list_sommets.get(rand_s2), rand_poids);
            } while (rand_s1 == rand_s2 || this.contientArete(a));

            System.out.println(rand_s1 + " --- " + rand_s2);
            this.ajoutArete((a));
        }
    }

    public void afficheGraphe() {
        System.out.println("\nListe Sommets :");
        for (Integer i : list_sommets) {
            System.out.println(i);
        }
        System.out.println("\nListe Aretes :");
        for (Arete a : list_aretes) {
            System.out.println(a.getSommet1() + " --- " + a.getSommet2() + " : " + a.getPoids());
        }
    }
}
