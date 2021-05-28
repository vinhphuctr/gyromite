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
        this.hector = new Professeur(this, 2, 2);
        
        // créer les smicks
        
        // créer les sols
        
        
        // créer les murs en bas de l'écran
        for (int x = 0; x < SIZE_X; x++) {
            addEntiteStatique(new Mur(this), x, 12);
            addEntiteStatique(new Mur(this), x, 13);
        }
        
        // créer les carottes
        addEntiteStatique(new Carotte(this), 3, 7);
        addEntiteStatique(new Carotte(this), 4, 12);
        
        // créer les bombes
        addEntiteStatique(new Bombe(this), 2, 5);
        addEntiteStatique(new Bombe(this), 5, 21);
        addEntiteStatique(new Bombe(this), 6, 6);
        addEntiteStatique(new Bombe(this), 10, 2);
        addEntiteStatique(new Bombe(this), 11, 19);
        
        // créer les cordes
        /// 6e colonne
        addEntiteStatique(new Corde(this), 4, 5);
        addEntiteStatique(new Corde(this), 5, 5);
        addEntiteStatique(new Corde(this), 6, 5);
        /// 8e colonne
        addEntiteStatique(new Corde(this), 1, 7);
        addEntiteStatique(new Corde(this), 2, 7);
        addEntiteStatique(new Corde(this), 5, 7);
        addEntiteStatique(new Corde(this), 6, 7);
        addEntiteStatique(new Corde(this), 7, 7);
        /// 13e colonne
        addEntiteStatique(new Corde(this), 1, 12);
        addEntiteStatique(new Corde(this), 2, 12);
        addEntiteStatique(new Corde(this), 3, 12);
        /// 15e colonne
        for (int x=5; x<12; x++) {
            addEntiteStatique(new Corde(this), x, 14);
        }
        /// 23e colonne
        for (int x=1; x<12; x++) {
            addEntiteStatique(new Corde(this), x, 22);
        }

        // créer les colonnes
    }
    
    public void bouger(Entite e, Direction d) {}
    
    private void addEntiteStatique(EntiteStatique e, int x, int y) {
        grilleEntites[x][y] = e;
    }
    
    
    
}
