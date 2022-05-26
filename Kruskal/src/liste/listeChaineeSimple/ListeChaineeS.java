package liste.listeChaineeSimple;

public class ListeChaineeS {

    private Noeud tete;

    public ListeChaineeS(){
        this.tete = null;
    }

    public ListeChaineeS(int valeur) {
        this.tete = new Noeud(valeur);
    }

    public ListeChaineeS(int valeur, ListeChaineeS next) {
        this.tete = new Noeud(valeur);
        this.tete.setSuivant(next.tete);
    }

    public ListeChaineeS(Noeud n) {
        this.tete = n;
    }
}
