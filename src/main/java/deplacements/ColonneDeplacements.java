/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deplacements;

import static deplacements.Direction.*;
import plateau.Colonne;
import plateau.Entite;
import plateau.EntiteDynamique;

/**
 *
 * @author Epulapp
 */
public class ColonneDeplacements extends RealiserDeplacements{
    
    private Direction directionCourante;
    
    // singleton desing pattern
    private static ColonneDeplacements cd;
    
    public static ColonneDeplacements getInstance() {
        if (cd==null) {
            cd = new ColonneDeplacements();
        }
        return cd;
    }
    public static ColonneDeplacements reset() {
        cd = new ColonneDeplacements();
        return cd;
    }
    
    public void resetDirection() {
        directionCourante = null;
    }
    
    public void setDirectionCourante(Direction d) {
        directionCourante = d;
    }
    
    
    @Override
    protected boolean realisationDeplacement() {
        boolean deplacer = false;
        for (EntiteDynamique ed : entitesDynamiques) {
            if (directionCourante != null) {
                if (directionCourante==haut) {
                    Entite eHaut = ed.regarderDansLaDirection(haut);
                    if (eHaut==null || eHaut instanceof Colonne || eHaut.peutEtreEcrase()) {
                        if (ed.deplacerVersLa(haut))
                            deplacer = true;
                    }     
                }
                if (directionCourante==bas) {
                    Entite eBas = ed.regarderDansLaDirection(bas);
                    if (eBas==null || eBas instanceof Colonne || eBas.peutEtreEcrase()) {
                        if (ed.deplacerVersLa(bas))
                            deplacer = true;
                    }     
                }
            }
        }
        
        return deplacer;
    }
    
}
