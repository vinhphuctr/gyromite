/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plateau;

/**
 *
 * @author Epulapp
 */
public abstract class EntiteStatique extends Entite {
    public EntiteStatique(Jeu _jeu) {
        super(_jeu);
    }
    @Override
    public boolean peutEtreEcrase() { return false; }
    
    @Override
    public boolean peutServirDeSupport() { return true; }

    @Override
    public boolean peutPermettreDeMonterDescendre() { return false; };

    @Override
    public boolean peutEtreRamasser(){return false;};
    
    public abstract boolean traversable();
}
