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
    private boolean rage;

    /**
     * Constructeur de recopie de la classe Loup.
     * @param l 
     */
    public Loup(Loup l) {
        super(l);
        this.rage = l.rage;
    }

    /**
     * Constructeur sans argument de la classe Loup.
     */
    public Loup() {
        super();
    }

    /**
     * Constructeur simple de la classe Loup.
     * @param rage
     * @param ptVie
     * @param pourcentageAtt
     * @param pourcentagePar
     * @param degAtt
     * @param ptPar
     * @param pos
     */
    public Loup(boolean rage, int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D pos) {
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, ptPar, pos);
        this.rage = rage;
    }
    
    //Accesseur

    /**
     * 
     * @return
     */
    public boolean isRage() {
        return rage;
    }

    /**
     * 
     * @param rage
     */
    public void setRage(boolean rage) {
        this.rage = rage;
    }
    
    @Override
        public void combattre (Creature c){
        Random rng = new Random();
        int jetDe1 = rng.nextInt(99)+1;
        int jetDe2 = rng.nextInt(99)+1;
        if (jetDe1 <= this.pourcentageAtt){
            if (jetDe2 <= c.pourcentagePar)
                c.setPtVie(c.getPtVie()-this.degAtt+c.getPtPar());
            else
                c.setPtVie(c.getPtVie()-this.degAtt);
            }
        
    }
    
}
