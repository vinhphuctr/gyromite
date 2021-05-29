/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deplacements;

import static deplacements.Direction.*;
import java.util.Random;
import plateau.Entite;
import plateau.EntiteDynamique;

/**
 *
 * @author Epulapp
 */
public class IA extends RealiserDeplacements {
    
    private Direction directionCourante;
    
    public void setDirection(Direction d) {
        directionCourante = d;
    }
    
    public static IA ia;
    public static IA getInstance(){
        if (ia==null) {
            ia = new IA();
        }
        return ia;
    }
    
    public void setDirectionAleatoire() {
        Random ran = new Random();
        int i = ran.nextInt(6);
        switch(i) {
            case 1: directionCourante = bas;
            case 2: directionCourante = haut;
            case 3: directionCourante = droite;
            case 4: directionCourante = gauche;
        }
    }

    @Override
    protected boolean realisationDeplacement() {
        boolean deplacer = false;
        
        if (directionCourante==null)
            setDirectionAleatoire();
        
        for (EntiteDynamique ed: entitesDynamiques) {
            switch(directionCourante) {
                
                case haut:
                    Entite eHaut = ed.regarderDansLaDirection(haut);
                    if (eHaut==null || eHaut.peutPermettreDeMonterDescendre()) {
                       if (ed.deplacerVersLa(haut))
                           deplacer = true;
                    };
                break;
                
                case bas:
                    Entite eBas = ed.regarderDansLaDirection(bas);
                    if (eBas==null || eBas.peutPermettreDeMonterDescendre()) {
                        if (ed.deplacerVersLa(bas))
                            deplacer = true;
                   };
                break;
                
                case gauche:
                    Entite eGauche = ed.regarderDansLaDirection(gauche);
                    if (eGauche==null || eGauche.peutPermettreDeMonterDescendre()) {
                        if (ed.deplacerVersLa(gauche))
                            deplacer = true;
                   };
                break;
                
                case droite:
                    Entite eDroite = ed.regarderDansLaDirection(droite);
                    if (eDroite==null || eDroite.peutPermettreDeMonterDescendre()) {
                        if (ed.deplacerVersLa(droite))
                            deplacer = true;
                   };
                break;
           }
        }
        return deplacer;
    }
    
}
