package ensemble;

import liste.listeChaineeTeteQueue.ListeChaineeTQ;

public class EnsembleLTQ {
    private int representant;
    private ListeChaineeTQ element;

    public EnsembleLTQ(int r, ListeChaineeTQ l) {
        this.representant = r;
        this.element = l;
    }

    public int getRepresentant() {
        return this.representant;
    }

    public void setRepresentant(int r) {
        this.representant = r;
    }

    public ListeChaineeTQ getListe() {
        return this.element;
    }
}
