package liste.listeChaineeTeteQueue;

public class ListeChaineeTQ {
    private Noeud tete;
    private Noeud queue;

    public ListeChaineeTQ(int tete) {
        this.tete = new Noeud(tete, this);
        this.queue = this.tete;
    }

    public boolean listeVide() {
        return this.tete == null;
    }

    public Noeud tete() {
        return this.tete;
    }

    public void insererEnQueue(int x) {
        // Cas où la liste est vide
        if (this.listeVide()) {
            this.tete = new Noeud(x, this);
            this.queue = this.tete;
        } else {
            // Cas où la liste n'est pas vide, on set directement après la queue
            this.queue.setSuivant(new Noeud(x, this));
            this.queue = this.queue.getSuivant();
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

    public String toString() {
        String s = "[ ";

        if (this.listeVide())
            s = s + "Chaîne vide";
        else {
            // Parcours de la liste
            Noeud p = tete;
            while (p != null) {
                s = s + p.getValeur() + " ";
                // Avancer d'un noeud dans la liste
                p = p.getSuivant();
            }
        }
        return s + "]";
    }
}
