/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 *
 * @author nico
 */
public class Loup extends Monster implements Combattant {

    /**
     * Constructeur de recopie de la classe Loup.
     * @param l 
     */
    public Loup(Loup l) {
        super(l);
    }

    /**
     * Constructeur sans argument de la classe Loup.
     */
    public Loup() {
        super();
    }

    /**
     * Constructeur simple de la classe Loup.
     * @param ptVie
     * @param pourcentageAtt
     * @param pourcentagePar
     * @param degAtt
     * @param ptPar
     * @param pos
     */
    public Loup(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D pos) {
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, pos);
    }
    
    /**
     * Gare à la morsure.
     * @param c
     */
    @Override
        public void combattre (Creature c){
        Random rng = new Random();
        int jetDe1 = rng.nextInt(99)+1;
        int jetDe2 = rng.nextInt(99)+1;
        if (jetDe1 <= this.pourcentageAtt){
            if (jetDe2 <= c.pourcentagePar){
                c.setPtVie(c.getPtVie()-this.degAtt+c.getPtPar());
                System.out.println("Touché, mais défense réussie.");
            }
            else{
                c.setPtVie(c.getPtVie()-this.degAtt);
                System.out.println("Touché !!");
            }
        }
        
    }
    
}
