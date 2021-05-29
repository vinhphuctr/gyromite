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
public class Colonne extends EntiteDynamique {

    public Colonne(Jeu _jeu) { 
        super(_jeu);
    }
    
    @Override
    public boolean peutEtreEcrase() { return false; }
    
    @Override
    public boolean peutServirDeSupport() { return true; }
    
    @Override
    public boolean peutEtreRamasser(){ return false;}
    
    @Override
    public boolean peutPermettreDeMonterDescendre() { return false; };
    
    public boolean traversable() { return false; }
}
