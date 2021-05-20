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
public class Jeu {
    public static final int SIZE_X = 25;
    public static final int SIZE_Y = 13;
    public int pause = 200;
    
    /* Entités dynamiques */
    private Professeur hector;
    private Smick smick;
    private Colonne colonne_head;
    private Colonne colonne_body;
    private Colonne colonne_foot;
    private EntiteStatique[][] grilleEntites = new EntiteStatique[SIZE_X][SIZE_Y]; 

    /* getters */
    private Professeur getHector() { return hector; }
    private Smick getSmicks() { return smick; }
    private Colonne getColonneHead() { return colonne_head; }
    private Colonne getColonneBody() { return colonne_body; }
    private Colonne getColonneFoot() { return colonne_foot; }
    private EntiteStatique[][] getGrille() { return grilleEntites; }
    
    public EntiteStatique getEntite(int x, int y) {
        if (x<0 || x>=SIZE_X || y<0 || y>=SIZE_Y)
            return null;
        return grilleEntites[x][y];
    }
    
    public Jeu() {
        this.initEntites();
    }
    
    public void initEntites() {
        // créer le professeur
        this.hector = new Professeur(this,2,2);
        
        // créer les smicks
        
        // créer les sols
        
        // créer les murs
        
        // créer les carottes
        
        // créer les bombes
        
        // créer les cordes
        
        // créer les colonnes
    }
    
    public void bouger(Entite e, Direction d) {}
    
    
    
    
}
