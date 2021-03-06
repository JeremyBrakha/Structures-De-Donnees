package ensemble;

import liste.listeChaineeSimple.ListeChaineeS;

public class EnsembleLS {
    private int representant;
    private ListeChaineeS element;

    public EnsembleLS(int r, ListeChaineeS l) {
        this.representant = r;
        this.element = l;
    }

    public int getRepresentant() {
        return this.representant;
    }

    public ListeChaineeS getListe() {
        return this.element;
    }
}
