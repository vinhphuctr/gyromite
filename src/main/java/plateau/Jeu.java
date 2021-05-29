/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plateau;

import deplacements.ColonneDeplacements;
import deplacements.ControleDesDirections;
import deplacements.Direction;
import static deplacements.Direction.*;
import deplacements.Gravite;
import deplacements.IA;
import deplacements.Ordonnanceur;
import java.awt.Point;
import java.util.HashMap;

/**
 *
 * @author Epulapp
 */
public class Jeu {
    public static final int SIZE_X = 25;
    public static final int SIZE_Y = 13;
    public int pause = 200;
    public int vies = 3;
    private int score = 0;
    private int carottes = 2;
    private int bombeRestantes = 5;
    public int temps = 500;
    private Ordonnanceur ordonnanceur = new Ordonnanceur(this);
    
    /* Entités dynamiques */
    private Professeur hector;
    private Smick[] smicks;
    private Colonne[] colonnes;
    private Entite[][] grilleEntites = new Entite[SIZE_X][SIZE_Y]; 
    
    // couples Entités et leurs coordonnées correspondant dans la grille 
    private static HashMap<Entite, Point> map;
    
    // compteur de déplacements horizontaux et verticaux <Entiter, pas (=1)>
    private HashMap<Entite, Integer> cptH;
    private HashMap<Entite, Integer> cptV;
    
    public void viderCompteurs() {
        cptH.clear();
        cptV.clear();
    }
    

    private Entite[][] getGrille() { return grilleEntites; }
    
    public Entite getEntite(int x, int y) {
        if (x<0 || x>=SIZE_X || y<0 || y>=SIZE_Y)
            return null;
        return grilleEntites[x][y];
    }
    
    public Ordonnanceur getOrdonnaceur() {
        return ordonnanceur;
    }
    
    
    public Jeu() {
        this.initEntites();
    }
    
    public void initEntites() {
        // créer le mapping
        map = new HashMap<>();
        cptH = new HashMap<>();
        cptV = new HashMap<>();
        
        // créer le professeur
        this.hector = new Professeur(this);
        ajouterEntite(hector, 2, 2);
        
        // créer 3 smicks
        smicks = new Smick[3];
        smicks[0] = new Smick(this, 0);
        ajouterEntite(smicks[0], 5, 4);
        smicks[1] = new Smick(this, 1);
        ajouterEntite(smicks[1], 3, 14);
        smicks[2] = new Smick(this, 2);
        ajouterEntite(smicks[2], 11, 8);
        
        // créer les colonnes
        colonnes = new Colonne[10];
        for (int i=0; i<colonnes.length; i++) {
            colonnes[i] = new Colonne(this);
        }
        ajouterEntite(colonnes[0], 1, 4);
        ajouterEntite(colonnes[1], 2, 4);
        ajouterEntite(colonnes[2], 3, 4);
        ajouterEntite(colonnes[3], 3, 10);
        ajouterEntite(colonnes[4], 4, 10);
        ajouterEntite(colonnes[5], 5, 10);
        ajouterEntite(colonnes[6], 5, 16);
        ajouterEntite(colonnes[7], 6, 16);
        ajouterEntite(colonnes[8], 7, 16);
        ajouterEntite(colonnes[9], 8, 16);

        // ajouter les propriétés de déplacement à Hector, au Smicks et aux colonnes
        ControleDesDirections.getInstance().ajouterEntiteDynamique(hector);
        for (Smick smick : smicks) {
            ControleDesDirections.getInstance().ajouterEntiteDynamique(smick);
            IA.getInstance().ajouterEntiteDynamique(smick);
        }
        for (Colonne colonne: colonnes) {
            ColonneDeplacements.getInstance().ajouterEntiteDynamique(colonne);
        }
        ordonnanceur.ajouter(ControleDesDirections.getInstance());
        ordonnanceur.ajouter(ColonneDeplacements.getInstance());
        ordonnanceur.ajouter(IA.getInstance());
        
        // ajouter la gravité à Hector et aux Smicks
        Gravite gravite = new Gravite();
        gravite.ajouterEntiteDynamique(hector);
        for (Smick smick : smicks) {
            gravite.ajouterEntiteDynamique(smick);
        }
        ordonnanceur.ajouter(gravite);
        
        // créer les sols
        /// sols horizontaux
        //// ligne 1
        ajouterEntite(new SolHorizontal(this), 1, 0);
        ajouterEntite(new SolHorizontal(this), 1, 1);
        ajouterEntite(new SolHorizontal(this), 1, 23);
        ajouterEntite(new SolHorizontal(this), 1, 24);
        //// ligne 3
        ajouterEntite(new SolHorizontal(this), 3, 1);
        ajouterEntite(new SolHorizontal(this), 3, 2);
        ajouterEntite(new SolHorizontal(this), 3, 3);
        ajouterEntite(new SolHorizontal(this), 3, 5);        
        ajouterEntite(new SolHorizontal(this), 3, 6);
        ajouterEntite(new SolHorizontal(this), 3, 8);
        ajouterEntite(new SolHorizontal(this), 3, 9);
        ajouterEntite(new SolHorizontal(this), 3, 11);
        //// ligne 4
        for (int y = 6; y < 9; y++) {
            ajouterEntite(new SolHorizontal(this), 4, y);
        }
        ajouterEntite(new SolHorizontal(this), 4, 11);
        ajouterEntite(new SolHorizontal(this), 4, 13);
        ajouterEntite(new SolHorizontal(this), 4, 14);
        ajouterEntite(new SolHorizontal(this), 4, 15);
        for (int y = 17; y < 21; y++) {
            ajouterEntite(new SolHorizontal(this), 4, y);
        }
        //// ligne 5
        for (int y = 11; y < 13; y++) {
            ajouterEntite(new SolHorizontal(this), 5, y);
        }
        //// ligne 6
        ajouterEntite(new SolHorizontal(this), 6, 3);
        ajouterEntite(new SolHorizontal(this), 6, 4);
        //// ligne 7
        for (int y = 4; y < 6; y++) {
            ajouterEntite(new SolHorizontal(this), 7, y);
        }
        for (int y = 17; y < 21; y++) {
            ajouterEntite(new SolHorizontal(this), 7, y);
        }
        //// ligne 8
        for (int y = 6; y < 17; y++) {
            if (y != 14) {
                ajouterEntite(new SolHorizontal(this), 8, y);   
            } 
        }
        
        /// sols verticaux
        //// colonne 1
        ajouterEntite(new SolVertical(this), 2, 1);
        for (int x = 4; x < 11; x++) {
            ajouterEntite(new SolVertical(this), x, 1);      
        }
        //// colonne 23
        for (int x = 2; x < 11; x++) {
            ajouterEntite(new SolVertical(this), x, 23);      
        }
        
        // créer les murs en bas de l'écran
        for (int x = 0; x < SIZE_X; x++) {
            ajouterEntite(new Mur(this), x, 12);
            ajouterEntite(new Mur(this), x, 13);
        }
        
        // créer les carottes
        ajouterEntite(new Carotte(this), 3, 7);
        ajouterEntite(new Carotte(this), 4, 12);
        
        // créer les bombes
        ajouterEntite(new Bombe(this), 2, 5);
        ajouterEntite(new Bombe(this), 5, 21);
        ajouterEntite(new Bombe(this), 6, 6);
        ajouterEntite(new Bombe(this), 10, 2);
        ajouterEntite(new Bombe(this), 11, 19);
        
        // créer les cordes
        /// 6e colonne
        ajouterEntite(new Corde(this), 4, 5);
        ajouterEntite(new Corde(this), 5, 5);
        ajouterEntite(new Corde(this), 6, 5);
        /// 8e colonne
        ajouterEntite(new Corde(this), 1, 7);
        ajouterEntite(new Corde(this), 2, 7);
        ajouterEntite(new Corde(this), 5, 7);
        ajouterEntite(new Corde(this), 6, 7);
        ajouterEntite(new Corde(this), 7, 7);
        /// 13e colonne
        ajouterEntite(new Corde(this), 1, 12);
        ajouterEntite(new Corde(this), 2, 12);
        ajouterEntite(new Corde(this), 3, 12);
        /// 15e colonne
        for (int x=5; x<12; x++) {
            ajouterEntite(new Corde(this), x, 14);
        }
        /// 23e colonne
        for (int x=1; x<12; x++) {
            ajouterEntite(new Corde(this), x, 22);
        }

        
    }
    
    public boolean deplacerEntite(Entite e, Direction d) {
        boolean deplacer = false;
        boolean isBombe = false;
        boolean retour = false;
        Point positionCourante = map.get(e);
        Point positionCible = getNouvellePosition(positionCourante, d);
        // en prenant compte les collision entre entités
        if (positionCible.x>=0 && positionCible.x<SIZE_X && positionCible.y>=0 && positionCible.y<SIZE_Y) {
            Entite entiteCible = entiteALaPosition(positionCible);
            if (entiteCible !=null) {
                if (entiteCible instanceof Bombe) {
                    if (!(e instanceof Smick)) {
                        deplacer = true;
                        isBombe = true;
                        supprimerEntite(entiteCible, positionCible.x, positionCible.y);
                    }
                }
                if (entiteCible instanceof Professeur && e instanceof Colonne) {
                    System.out.println("Vies restantes: " + --vies);
                    deplacer = true;
                    deplacerEntite(entiteCible, Direction.gauche);
                }
                if (entiteCible instanceof Professeur && e instanceof Smick) {
                    System.out.println("Vies restantes: " + --vies);
                    deplacer = false;
                }
                if (entiteCible instanceof Smick && e instanceof Colonne) {
                    supprimerEntite(entiteCible, positionCible.x, positionCible.y);
                    deplacer = true;
                }
            }
        }
        
        if (deplacer) {
            if (d==gauche || d==droite) {
                if (cptH.get(e)==null) {
                    cptH.put(e, 1);
                    if (isBombe) {
                        gagnerScore(100);
                        bombeRestantes -= 1;
                    }
                    retour = true;
                }
            }
            if (d==haut || d==bas) {
                if (cptV.get(e)==null) {
                    cptV.put(e, 1);
                    if (isBombe) {
                        gagnerScore(100);
                        bombeRestantes -= 1;
                    }
                    retour = true;
                }
            }
        }
        
        if (retour) {
            deplacer(e, positionCourante, positionCible);
        }
        
        return retour;
    }
    
    public void deplacer(Entite e, Point positionCourante, Point positionCible) {
        grilleEntites[positionCourante.x][positionCourante.y] = null;
        grilleEntites[positionCible.y][positionCible.y] = e;
        map.put(e, positionCible);
    }
    
    private void ajouterEntite(Entite e, int x, int y) {
        grilleEntites[x][y] = e;
        map.put(e, new Point(x,y));
    }
    
    private void supprimerEntite(Entite e, int x, int y) {
        grilleEntites[x][y] = null;
        map.remove(e);
    }
    
    public Entite regarderDansLaDirection(Entite e, Direction d) {
        Point positionCourante = map.get(e);
        Point positionCible = getNouvellePosition(positionCourante, d); 
        return entiteALaPosition(positionCible);
    }
    
    private Point getNouvellePosition(Point positionCourant, Direction d) {
        Point nouveauPoint = null;
        switch(d) {
            case gauche: nouveauPoint = new Point(positionCourant.x-1, positionCourant.y); break;
            case droite: nouveauPoint = new Point(positionCourant.x+1, positionCourant.y); break;
            case haut: nouveauPoint = new Point(positionCourant.x, positionCourant.y+1); break;
            case bas: nouveauPoint = new Point(positionCourant.x, positionCourant.y-1); break;
        }
        return nouveauPoint;
    }
    
    private Entite entiteALaPosition(Point p) {
        Entite e = null;
        if (p.x>=0 && p.x<SIZE_X && p.y>=0 && p.y<SIZE_Y)
            e = grilleEntites[p.x][p.y];
        return e;
    }
    
    public int getScore() {
        return score;
    }
    
    public void gagnerScore(int point) {
        score += point;
    }
    
    public void resetJeu() {
        score = 0;
        bombeRestantes = 5;
        vies = 3;
        carottes = 2;
        map.clear();
        ordonnanceur.vider();
        ControleDesDirections.reset();
        ColonneDeplacements.reset();
        initEntites();
    }
    
    
    
    
}
