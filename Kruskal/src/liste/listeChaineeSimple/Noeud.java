package liste.listeChaineeSimple;

public class Noeud {

    private int valeur;
    private Noeud nSuivant;

    public Noeud(int valeur) {
        this.valeur = valeur;
        nSuivant = null;
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
