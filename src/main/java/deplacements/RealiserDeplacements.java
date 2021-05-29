/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deplacements;

import java.util.ArrayList;
import plateau.EntiteDynamique;

/**
 *
 * @author Epulapp
 */
public abstract class RealiserDeplacements {
    protected ArrayList<EntiteDynamique> entitesDynamiques = new ArrayList<>();
    protected abstract boolean realisationDeplacement();
    
    public void ajouterEntiteDynamique(EntiteDynamique ed) {
        entitesDynamiques.add(ed);
    }
    
    public void supprimerEntiteDynamique(EntiteDynamique ed) {
        entitesDynamiques.remove(ed);
    }
}
