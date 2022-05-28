package liste.listeChaineeSimple;

public class ListeChaineeS {

    private Noeud tete;

    public ListeChaineeS() {
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

    public boolean estVide() {
        return this.tete == null;
    }

    public Noeud tete() {
       return this.tete;
    }

    public Noeud queue() {
        return this.tete.getSuivant();
    }

    public void insererEnTete(int x) {
        this.tete = new Noeud(x, this.tete);
    }

    /***
     * Insérer y après la première occurrence de x dans la liste,
     * uniquement si x est bien présent
     *
     * @param x est l'élément à rechercher
     * @param y est l'élément à insérer si x est présent
     */
    public void insererApres(int x, int y) {
        Noeud courant = tete;
        while (courant != null) {
            if (courant.getValeur() == x) {
                Noeud noeudY = new Noeud(y, courant.getSuivant());
                courant.setSuivant(noeudY);
                break;
            }
            courant = courant.getSuivant();
        }
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
     * Supprime la première occurrence de x dans la liste,
     * si x est bien présent (ne fait rien sinon)
     *
     * @param x l'élément dont on supprime la première occurrence
     */
    public void supprimer(int x) {
        if (!this.estVide() && this.contient(x)) {
            // On teste si x est en tete
            if (tete.getValeur() == x) {
                tete = tete.getSuivant();
            } else {
                // Recherche de l'élément qui précède x
                Noeud courant = tete;
                while (courant.getSuivant().getValeur() != x) {
                    courant = courant.getSuivant();
                }
                courant.setSuivant(courant.getSuivant().getSuivant());
            }
        }
        // il n'y a rien à faire si la liste est vide
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
