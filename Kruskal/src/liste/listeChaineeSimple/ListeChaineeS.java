package liste.listeChaineeSimple;

public class ListeChaineeS {

    private Noeud tete;

    public ListeChaineeS(int valeur) {
        this.tete = new Noeud(valeur);
    }

    public boolean estVide() {
        return this.tete == null;
    }

    public Noeud tete() {
        return this.tete;
    }

    /***
     * Insère l'élément x en fin de la liste
     *
     * @param x l'élement à insérer
     */
    public void insererEnQueue(int x) {
        // Cas où la liste est vide
        if (this.estVide())
            this.tete = new Noeud(x);
        else {
            // Cas où la liste n'est pas vide, on parcourt jusqu'au dernier élément celui
            // qui n'a pas de suivant
            Noeud courant = tete;
            while (courant.getSuivant() != null) {
                courant = courant.getSuivant();
            }
            courant.setSuivant(new Noeud(x));
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

        if (this.estVide())
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
