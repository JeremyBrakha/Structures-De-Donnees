package ensemble;

import liste.listeChaineeUnionPonderee.ListeChaineeUP;

public class EnsembleUP {
    private int representant;
    private ListeChaineeUP element;

    public EnsembleUP(int r, ListeChaineeUP l) {
        this.representant = r;
        this.element = l;
    }

    public int getRepresentant() {
        return this.representant;
    }

    public void setRepresentant(int r) {
        this.representant = r;
    }

    public ListeChaineeUP getListe() {
        return this.element;
    }
}
