/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deplacements;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Observable;
import plateau.Jeu;

/**
 *
 * @author Epulapp
 */
public class Ordonnanceur extends Observable implements Runnable {

    private Jeu jeu;
    private int pause;
    private ArrayList<RealiserDeplacements> listeDeplacements = new ArrayList<>();
    
    public Ordonnanceur(Jeu _jeu) {
        jeu = _jeu;
    }
    
    public void start(int _pause) {
        pause = _pause;
        new Thread(this).start();
    }
    
    public void ajouter(RealiserDeplacements deplacement) {
        listeDeplacements.add(deplacement);
    }
    
    public void supprimer(RealiserDeplacements deplacement) {
        listeDeplacements.remove(deplacement);
    }
    
    public void vider() {
        listeDeplacements.clear();
    }
    
    @Override
    public void run() {
        boolean update = false;
        while (true) {
            jeu.viderCompteurs();
            for (RealiserDeplacements r: listeDeplacements) {
                if (r.realisationDeplacement())
                    update = true;
            }
            
            ControleDesDirections.getInstance().resetDirection();
            ColonneDeplacements.getInstance().resetDirection();
            
            if (update) {
                setChanged();
                notifyObservers();
            }
            
            try {
                sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
