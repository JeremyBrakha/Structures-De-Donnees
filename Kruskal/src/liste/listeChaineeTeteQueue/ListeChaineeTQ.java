package liste.listeChaineeTeteQueue;

public class ListeChaineeTQ {
    private Noeud tete;
    private Noeud queue;

    public ListeChaineeTQ(Noeud tete) {
        this.tete = tete;
        this.queue = null;
    }

    public ListeChaineeTQ(Noeud tete, Noeud queue) {
        this.tete = tete;
        this.queue = queue;
    }

    public boolean teteEstVide() {
        return this.tete == null;
    }

    public boolean queueEstVide() {
        return this.queue == null;
    }
}
