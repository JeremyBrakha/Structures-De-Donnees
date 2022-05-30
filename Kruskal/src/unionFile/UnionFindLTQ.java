package unionFile;

import java.util.ArrayList;
import ensemble.EnsembleLTQ;
import liste.listeChaineeTeteQueue.ListeChaineeTQ;
import liste.listeChaineeTeteQueue.Noeud;
import utils.LireLigne;

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

    public void union(int e1, int e2) throws Exception {
        boolean trouve_e1 = false;
        boolean trouve_e2 = false;
        int index_e1 = 0;
        int index_e2 = 0;

        // Determiner si les ensembles font parties de Union-Find
        for (EnsembleLTQ e : this.membres) {
            if (e.getListe().contient(e1)) {
                trouve_e1 = true;
                index_e1 = this.membres.indexOf(e);
            } else if (e.getListe().contient(e2)) {
                trouve_e2 = true;
                index_e2 = this.membres.indexOf(e);
            }
        }
        if (!trouve_e1 || !trouve_e2) {
            throw new Exception("Sommets non présents");
        }

        // Création d'une liste issu des 2 anciennes listes
        ListeChaineeTQ new_list = this.membres.get(index_e1).getListe();
        ListeChaineeTQ li_temp2 = this.membres.get(index_e2).getListe();
        Noeud n2 = li_temp2.tete();

        while (n2 != null) {
            new_list.insererEnQueue(n2.getValeur());
            n2 = n2.getSuivant();
        }

        /*
        // Détermination du représentant au hasard
        int new_rep;
        // Random ran = new Random();
        int nxt = LireLigne.entierAleatoire(0, 1);
        if (nxt == 0) {
            new_rep = this.membres.get(index_e1).getRepresentant();
        } else {
            new_rep = this.membres.get(index_e2).getRepresentant();
        }

         */

        // Création et Ajout de l'ensemble issu de l'union des 2 précédents, suppression
        // des anciens ensembles
        EnsembleLTQ new_ens = new EnsembleLTQ(this.membres.get(index_e1).getRepresentant(), new_list);
        // new_ens.getListe());
        this.membres.set(index_e1, new_ens);
        this.membres.remove(index_e2);

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

    public void affichePartition() {
        System.out.println("Nouvelle Partition:");
        for (EnsembleLTQ m : this.membres) {
            System.out.println("{ " + m.getRepresentant() + " : " + m.getListe() + " }");
        }
    }
}
