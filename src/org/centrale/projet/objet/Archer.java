package org.centrale.projet.objet;

import java.util.LinkedList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Archer extends Personnage implements Combattant {

 //Attributs
    /**
     * Nombre de flèches
     */
    private int nbFleches;
    
    //Constructeurs

    /**
     * Constructeur de recopie de la classe Archer.
     * @param a
     */
    public Archer(Archer a) {
        super(a);
        this.nbFleches = a.nbFleches;
    }

    /**
     * Constructeur simple de la classe Archer.
     * @param nbFleches
     * @param ptVie
     * @param pourcentageAtt
     * @param pourcentagePar
     * @param pourcentageResistMag
     * @param degAtt
     * @param ptPar
     * @param distAttMax
     * @param pos
     * @param nom
     * @param stock
     */

    public Archer(int nbFleches, int ptVie, int pourcentageAtt, int pourcentagePar, int pourcentageResistMag, int degAtt, int ptPar, int distAttMax, Point2D pos, String nom, LinkedList<Nourriture> stock) {
        super(ptVie, pourcentageAtt, pourcentagePar, pourcentageResistMag, degAtt, ptPar, distAttMax, pos, nom, stock);
        this.nbFleches = nbFleches;
    }
    

    /**
     * Constructeur sans argument de la classe Archer.
     */
    public Archer() {
        super();
    }
    


    
    //Accesseur

    /**
     * 
     * @return
     */
    public int getNbFleches() {
        return nbFleches;
    }
    
    //Modificateur

    /**
     * 
     * @param nbFleches
     */
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }
    
    /**
     * Combat à distance
     * @param c
     * 
     */
    @Override
    public void combattre (Creature c){
        Random rng = new Random();
        int jetDe = rng.nextInt(99)+1;
        if (this.nbFleches > 0){
            this.nbFleches --;
                if (jetDe<=this.pourcentageAtt){
                    c.setPtVie(c.getPtVie()-this.degAtt);
                    System.out.println("Touché !!");
                    }
                else{
                    System.out.println("Ha, raté..");
                }
        }
        else{
            System.out.println("Plus de flèches !");
        }
        
    }
    

    

    
}
