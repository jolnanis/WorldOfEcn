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
public class Mage extends Personnage implements Combattant {
//Attributs 

    private int ptMana ;
    private int degMag;
    private int pourcentageMag ;
    
    //Constructeurs


    /**
     * Constructeur de recopie de la classe Mage.
     * @param w
     */
    public Mage(Mage w) {
        super(w);
        this.ptMana = w.ptMana;
        this.degMag = w.degMag;
        this.pourcentageMag = w.pourcentageMag;
        this.nom = w.nom;
    }

    /**
     * Constructeur simple de la classe Mage.
     * @param ptMana
     * @param degMag
     * @param pourcentageMag
     * @param ptVie
     * @param pourcentageAtt
     * @param pourcentagePar
     * @param pourcentageResistMag
     * @param degAtt
     * @param distAttMax
     * @param pos
     */

    public Mage(int ptMana, int degMag, int pourcentageMag, int ptVie, int pourcentageAtt, int pourcentagePar, int pourcentageResistMag, int degAtt, int distAttMax, Point2D pos, String nom, LinkedList<Nourriture> stock) {
        super(ptVie, pourcentageAtt, pourcentagePar, pourcentageResistMag, degAtt, distAttMax, pos, nom, stock);
        this.ptMana = ptMana;
        this.degMag = degMag;
        this.pourcentageMag = pourcentageMag;
    }
    

    /**
     * Constructeur sans argument de la classe Mage.
     */
    public Mage() {
        super();
    }
    //Accesseurs

    /**
     * 
     * @return
     */
    public int getDegMag() {
        return degMag;
    }

    /**
     * 
     * @return
     */
    public int getPourcentageMag() {
        return pourcentageMag;
    }

    /**
     * 
     * @return
     */
    public int getPtMana() {
        return ptMana;
    }
    //Modificateurs

    /**
     * 
     * @param degMag
     */
    public void setDegMag(int degMag) {
        this.degMag = degMag;
    }

    /**
     * 
     * @param pourcentageMag
     */
    public void setPourcentageMag(int pourcentageMag) {
        this.pourcentageMag = pourcentageMag;
    }

    /**
     * 
     * @param ptMana
     */
    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
    }
    

    //Méthodes
    /**
     * Attaque magique.
     * @param c
     */
    @Override
    public void combattre (Creature c){
        Random rng = new Random();
        int jetDe = rng.nextInt(99)+1;
        this.ptMana --;
        if (jetDe<=this.pourcentageMag)
            c.setPtVie(this.degMag);
        
        
    }
    
    
    
}
