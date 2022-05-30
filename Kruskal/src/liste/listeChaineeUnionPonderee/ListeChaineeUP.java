package liste.listeChaineeUnionPonderee;

public class ListeChaineeUP {
    private Noeud tete;
    private Noeud queue;
    private int taille;

    public ListeChaineeUP(int tete) {
        this.tete = new Noeud(tete);
        this.taille = 1;
        this.queue = null;
    }

    public ListeChaineeUP(int tete, int queue) {
        this.tete = new Noeud(tete);
        this.queue = new Noeud(queue);
    }

    public boolean teteEstVide() {
        return this.tete == null;
    }

    public boolean queueEstVide() {
        return this.queue == null;
    }
    public int getTaille() {
        return this.taille;
    }

    public Noeud tete() {
        return this.tete;
    }

    public void insererEnQueue(int x) {
        // Cas où la liste est vide
        if (this.teteEstVide()) {
            this.tete = new Noeud(x, this);
        } else if (this.queueEstVide()) {
            this.queue = new Noeud(x, this);
        } else {
            // Cas où la liste n'est pas vide, on set directement après la queue
            this.queue.setSuivant(new Noeud(x, this));
        }
    }

    /***
     * Teste si x est présent dans la liste
     *
     * @param x : l'élément à rechercher
     * @return true si x est présent, false sinon
     */
    public boolean contient(int x) {
        boolean present = false;
        Noeud p = this.tete;

        while (p != null && !present) {
            if (x == p.getValeur())
                present = true;
            p = p.getSuivant();
        }

        return present;
    }
}
