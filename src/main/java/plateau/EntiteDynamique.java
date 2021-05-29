/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plateau;

import deplacements.Direction;

/**
 *
 * @author Epulapp
 */
public abstract class EntiteDynamique extends Entite {
    public EntiteDynamique(Jeu _jeu) {
        super(_jeu);
    }

    @Override
    public boolean peutEtreRamasser(){
        return false;
    };
        
    public boolean deplacerVersLa(Direction d) {
        return jeu.deplacerEntite(this, d);
    };
    
    public Entite regarderDansLaDirection(Direction d) {
        return jeu.regarderDansLaDirection(this, d);
    }
}
