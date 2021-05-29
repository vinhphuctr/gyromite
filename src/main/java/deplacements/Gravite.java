/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deplacements;

import static deplacements.Direction.bas;
import plateau.EntiteDynamique;
import plateau.Entite;

/**
 *
 * @author Epulapp
 */
public class Gravite extends RealiserDeplacements {
    
    @Override
    protected boolean realisationDeplacement() {
        boolean tomber = false;
        
        for (EntiteDynamique ed: entitesDynamiques) {
            Entite eBas = ed.regarderDansLaDirection(bas);
            if (eBas==null || (eBas!=null && !eBas.peutServirDeSupport())) {
                if (ed.deplacerVersLa(bas))
                    tomber = true;
            }
        }
        return tomber;
    }
    
}
