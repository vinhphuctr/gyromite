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
    private int x, y;
    public Colonne(Jeu _jeu, int _x, int _y) { 
        super(_jeu);
        x = _x;
        y = _y;
    }
    
    public void bas() {
        if (traversable(x, y+1)) {
            y ++;
        }
    }

    public void haut() {
        if (traversable(x, y-1)) {
            y --;
        }
    }
    
    private boolean traversable(int x, int y) {
        if (x >0 && x < Jeu.SIZE_X && y > 0 && y < Jeu.SIZE_Y) {
            return jeu.getEntite(x, y).traversable();
        } else {
            return false;
        }
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
