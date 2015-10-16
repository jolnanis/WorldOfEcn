package org.centrale.projet.objet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Lapin extends Monster {

    //Constructeurs
    /**
     * 
     * @param ptVie
     * @param pourcentageAtt
     * @param pourcentagePar
     * @param degAtt
     * @param pos
     */
    public Lapin(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, Point2D pos) {
        super(ptVie, pourcentageAtt, pourcentagePar, degAtt, pos);
    }

    /**
     * 
     */
    public Lapin() {
        super();
    }

    /**
     * 
     * @param m
     */
    public Lapin(Monster m) {
        super(m);
    }
    
    
}
