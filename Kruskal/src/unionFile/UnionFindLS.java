package unionFile;

import ensemble.EnsembleLS;
import liste.listeChaineeSimple.ListeChaineeS;
import liste.listeChaineeSimple.Noeud;
import utils.LireLigne;

import java.io.IOException;
import java.util.*;

public class UnionFindLS {

    private ArrayList<EnsembleLS> membres;

    public UnionFindLS() {
        membres = new ArrayList<>();
    }

    private EnsembleLS makeSet(int rep) throws Exception {


        for (EnsembleLS e : this.membres) {
            if (e.getRepresentant() == rep) throw new Exception(rep + "déjà représentant d'un autre ensemble");
        }

        ListeChaineeS new_l = new ListeChaineeS(rep);
        EnsembleLS new_e = new EnsembleLS(rep, new_l);
        this.membres.add(new_e);

        return new_e;
    }

    private void union(EnsembleLS e1, EnsembleLS e2) throws Exception {

        boolean trouve_e1 = false;
        boolean trouve_e2 = false;
        int index_e1 = 0;
        int index_e2 = 0;

        //Determiner si les ensembles font parties de Union-Find
        for (EnsembleLS e : this.membres) {
            if (e.getRepresentant() == e1.getRepresentant()) {
                trouve_e1 = true;
                index_e1 = this.membres.indexOf(e);
            } else if (e.getRepresentant() == e2.getRepresentant()) {
                trouve_e2 = true;
                index_e2 = this.membres.indexOf(e);
            }
        }
        if (!trouve_e1 || !trouve_e2) {
            throw new Exception("Ensembles non présents");
        }

        //Création d'une liste issu des 2 anciennes listes
        ListeChaineeS new_list = e1.getListe();
        ListeChaineeS li_temp2 = e2.getListe();

        Noeud n1 = new_list.tete();
        Noeud n2 = li_temp2.tete();

        while (n1 != null) {
            n1 = new_list.queue();
        }
        while (n2 != null) {
            n1.setSuivant(n2);
            n2 = li_temp2.queue();
        }
        n1.setSuivant(null);

        //Détermination du représentant au hasard
        int new_rep;
        Random ran = new Random();
        int nxt = LireLigne.entierAleatoire(0, 1);
        if(nxt == 0){
            new_rep = e1.getRepresentant();
        } else {
            new_rep = e2.getRepresentant();
        }

        //Création et Ajout de l'ensemble issu de l'union des 2 précédents, suppression des anciens ensembles
        EnsembleLS new_ens = new EnsembleLS(new_rep, new_list);
        this.membres.add(index_e1, new_ens);
        this.membres.remove(index_e2);

    }

    private int find(int x) {
        for (EnsembleLS e : this.membres) {
            if (e.getListe() != null) {
                if (e.getListe().contient(x)) {
                    return e.getRepresentant();
                }
            }
        }
        return -1;
    }


}
