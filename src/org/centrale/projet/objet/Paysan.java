package org.centrale.projet.objet;

import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Paysan extends Personnage {
    
    //Constructeurs
    /**
     * Constructeur sans argument de la classe Paysan
     */
    public Paysan() {
        super();
    }

    /**
     * Constructeur simple de la classe Paysan
     * @param ptVie
     * @param pourcentageAtt
     * @param pourcentagePar
     * @param pourcentageResistMag
     * @param degAtt
     * @param distAttMax
     * @param pos
     */

    public Paysan(int ptVie, int pourcentageAtt, int pourcentagePar, int pourcentageResistMag, int degAtt, int distAttMax, Point2D pos, String nom, LinkedList<Nourriture> stock) {
        super(ptVie, pourcentageAtt, pourcentagePar, pourcentageResistMag, degAtt, distAttMax, pos, nom, stock);
    }
    



    /**
     * Constructeur de recopie
     * @param p
     */
    public Paysan(Paysan p) {
        super(p);
    }

    
    
    
    
    
}
