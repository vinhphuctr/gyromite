/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deplacements;

import static deplacements.Direction.*;
import plateau.Entite;
import plateau.EntiteDynamique;

/**
 *
 * @author Epulapp
 */
public class ControleDesDirections extends RealiserDeplacements {

    private static Direction directionCourante;
    private static Direction directionPrecedente;
    
    // Singleton design pattern
    private static ControleDesDirections CDD;
    public static ControleDesDirections getInstance() {
        if (CDD==null) {
            CDD = new ControleDesDirections(); 
        }
        return CDD;
    }
    
    public static ControleDesDirections reset() {
        CDD = new ControleDesDirections();
        return CDD;
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
        for (EntiteDynamique ed : entitesDynamiques){
            if (directionCourante==gauche || directionCourante==droite) {
                directionPrecedente = directionCourante;
                if (ed.deplacerVersLa(directionCourante))
                    deplacer = true;
            }
            if (directionCourante==haut || directionCourante==bas) {
                Entite eBas = ed.regarderDansLaDirection(bas);
                Entite eHaut = ed.regarderDansLaDirection(haut);
                if (eBas!=null && eHaut!=null && eBas.peutServirDeSupport()) {
                   if (ed.deplacerVersLa(haut)) {
                    deplacer = true;
                   }
                }
            }
        }
        return deplacer;
    }
    
}
