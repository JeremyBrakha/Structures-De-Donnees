package liste.listeChaineeUnionPonderee;

public class ListeChaineeUP {
    private Noeud tete;
    private Noeud queue;
    private int taille;

    public ListeChaineeUP(int tete) {
        this.tete = new Noeud(tete, this);
        this.taille = 1;
        this.queue = this.tete;
    }

    public boolean listVide() {
        return this.tete == null;
    }

    public int getTaille() {
        return this.taille;
    }

    public Noeud tete() {
        return this.tete;
    }

    public void insererEnQueue(int x) {
        // Cas où la liste est vide
        if (this.listVide()) {
            this.tete = new Noeud(x, this);
            this.queue = this.tete;
            this.taille = 1;
        } else {
            // Cas où la liste n'est pas vide, on set directement après la queue
            this.queue.setSuivant(new Noeud(x, this));
            this.queue = this.queue.getSuivant();
            this.taille = this.taille + 1;
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

        if (this.listVide())
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
