package liste.listeChaineeTeteQueue;

public class Noeud {
    private int valeur;
    private ListeChaineeTQ liste;
    private Noeud nSuivant;

    private Noeud(int valeur, ListeChaineeTQ liste, Noeud nSuivant) {
        this.valeur = valeur;
        this.liste = liste;
        this.nSuivant = nSuivant;
        
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
