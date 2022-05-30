package liste.listeChaineeUnionPonderee;

public class Noeud {
    private int valeur;
    private ListeChaineeUP liste;
    private Noeud nSuivant;

    public Noeud(int valeur) {
        this.valeur = valeur;
        this.liste = null;
        this.nSuivant = null;
    }

    public Noeud(int valeur, ListeChaineeUP liste, Noeud nSuivant) {
        this.valeur = valeur;
        this.liste = liste;
        this.nSuivant = nSuivant;

    }

    public Noeud(int valeur, ListeChaineeUP liste) {
        this.valeur = valeur;
        this.liste = liste;
        this.nSuivant = null;

    }

    public int getValeur() {
        return this.valeur;
    }

    public Noeud getSuivant() {
        return this.nSuivant;
    }

    public void setSuivant(Noeud nextNoeud) {
        this.nSuivant = nextNoeud;
    }
}
