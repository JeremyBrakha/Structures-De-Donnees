package liste.listeChaineeTeteQueue;

public class Noeud {
    private int valeur;
    private ListeChaineeTQ liste;
    private Noeud nSuivant;

    public Noeud(int valeur) {
        this.valeur = valeur;
        this.liste = null;
        this.nSuivant = null;
    }

    public Noeud(int valeur, ListeChaineeTQ liste, Noeud nSuivant) {
        this.valeur = valeur;
        this.liste = liste;
        this.nSuivant = nSuivant;
        
    }

    public Noeud(int valeur, ListeChaineeTQ liste) {
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
