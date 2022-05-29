package unionFile;

import java.util.ArrayList;
import ensemble.EnsembleLTQ;
import liste.listeChaineeTeteQueue.ListeChaineeTQ;

public class UnionFindLTQ {
    private ArrayList<EnsembleLTQ> membres;

    public UnionFindLTQ() {
        membres = new ArrayList<>();
    }

    public EnsembleLTQ makeSet(int rep) throws Exception {

        for (EnsembleLTQ e : this.membres) {
            if (e.getRepresentant() == rep)
                throw new Exception(rep + "déjà représentant d'un autre ensemble");
        }

        ListeChaineeTQ new_l = new ListeChaineeTQ(rep);
        EnsembleLTQ new_e = new EnsembleLTQ(rep, new_l);
        this.membres.add(new_e);

        return new_e;
    }

    

    public int find(int x) {
        for (EnsembleLTQ e : this.membres) {
            if (e.getListe() != null) {
                if (e.getListe().contient(x)) {
                    return e.getRepresentant();
                }
            }
        }
        return -1;
    }
}
