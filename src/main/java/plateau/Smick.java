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
public class Smick extends EntiteDynamique {
    private int id;
    
    public Smick(Jeu _jeu, int _id) {
        super(_jeu);
        /*this.id = _id;
        this.x = x;
        this.y = y;*/
    }
    
    /*public int getX() { return x; }
    public int getY() { return y; }
    
    public void droite() {
        if (traversable(x+1, y)) {
            x ++;
        }
    }

    public void gauche() {
        if (traversable(x-1, y)) {
            x --;
        }
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
    }*/
    
    @Override
    public boolean peutEtreEcrase() { return true; }
    
    @Override
    public boolean peutServirDeSupport() { return false; }
    
    @Override
    public boolean peutPermettreDeMonterDescendre() { return false; };
    
    @Override
    public boolean peutEtreRamasser(){ return false; };
}
