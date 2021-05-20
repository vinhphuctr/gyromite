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
public class Professeur extends EntiteDynamique {
    private int x, y;
    public Jeu jeu;
    
    public Professeur(Jeu _jeu, int _x, int _y) {
        jeu = _jeu;
        x = _x;
        y = _y;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

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
        if (x >0 && x < jeu.SIZE_X && y > 0 && y < jeu.SIZE_Y) {
            return jeu.getEntite(x, y).traversable();
        } else {
            return false;
        }
    }
    
    
    @Override
    public boolean peutEtreEcrase() { return true; }
    
    @Override
    public boolean peutServirDeSupport() { return false; }
    
    @Override
    public boolean peutPermettreDeMonterDescendre() { return false; };
    
    @Override
    public boolean peutEtreRamasser(){ return false; };

}
