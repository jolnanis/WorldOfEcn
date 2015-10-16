/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author nico
 */
public class Guerrier extends Personnage implements Combattant {
    /**
     * Violence
     */
    private int violence;
    //Constructeurs :

    /**
     * Constructeur de recopie de la classe Guerrier.
     * @param g
     */
    public Guerrier(Guerrier g) {
        super(g);
        this.violence = g.violence;
        this.nom = g.nom;
    }

    /**
     * Constructeur simple de la classe Guerrier.
     * @param violence
     * @param ptVie
     * @param pourcentageAtt
     * @param pourcentagePar
     * @param pourcentageResistMag
     * @param degAtt
     * @param distAttMax
     * @param pos
     */

    public Guerrier(int violence, int ptVie, int pourcentageAtt, int pourcentagePar, int pourcentageResistMag, int degAtt, int distAttMax, Point2D pos, String nom, LinkedList<Nourriture> stock) {
        super(ptVie, pourcentageAtt, pourcentagePar, pourcentageResistMag, degAtt, distAttMax, pos, nom, stock);
        this.violence = violence;
    }
    

    /**
     * Constructeur sans argument de la classe Guerrier.
     */
    public Guerrier() {
        super();
    }
 
    // Accesseurs 
  
    /**
     * 
     * @return
     */
    public int getViolence() {
        return violence;
    }

    //Modificateurs 

    /**
     * 
     * @param violence
     */
    public void setViolence(int violence) {
        this.violence = violence;
    }
    
    /**
     * Combat rapproché.
     * @param c
     */
    @Override
    public void combattre (Creature c){
        Random rng = new Random();
        int jetDe1 = rng.nextInt(99)+1;
        int jetDe2 = rng.nextInt(99)+1;
        if (this.getPos().distance(c.getPos())==1){
            if (jetDe1 <= this.pourcentageAtt){
                if (jetDe2 <= c.pourcentagePar)
                    c.setPtVie(this.degAtt-c.getPourcentagePar());
                else
                    c.setPtVie(this.degAtt);
                }
        }
    }
    
    
}
