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
public class SolVertical extends EntiteStatique {

    public SolVertical(Jeu _jeu) { 
        super(_jeu);
    }
    
    @Override
    public boolean traversable() {
        return false;
    }
}
