package models;

public class Arete {

    private int sommet1;
    private int sommet2;
    private int poids;

    public Arete(int s1, int s2, int t) {
        this.sommet1 = s1;
        this.sommet2 = s2;
        this.poids = t;
    }

    public int getSommet1() {
        return this.sommet1;
    }

    public int getSommet2() {
        return this.sommet2;
    }

    public int getPoids() {
        return this.poids;
    }

    public void afficheArete() {
        System.out.println(this.sommet1 + " --- " + this.sommet2 + " : " + this.poids);
    }

}
