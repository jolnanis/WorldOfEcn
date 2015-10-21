/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 *
 * @author Antoine
 */
public class Nourriture extends Objet{

    /**
     * Quantité algébrique de bonus apporté par l'objet.
     */
    protected int bonusmalus ;

    /**
     * Nom de la Nourriture.
     */
    protected String name ;

    /**
     * Durée des effets.
     */
    protected int duree;
       
       //Constructeur

    /**
     *
     */
    
    //Setters et getters
    public Nourriture(){
           super();
       }
           
    public int getBonusmalus() {
        return bonusmalus;
    }
    
    public void setBonusmalus(int bonusmalus) {
        this.bonusmalus = bonusmalus;
    }
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getDuree() {
        return duree;
    }
    
    public void setDuree(int duree) {
        this.duree = duree;
    }
    
    /**
     *
     * @return
     */
    public int DonnerValeur(){
           Random generateurAleatoire = new Random();
           this.bonusmalus = generateurAleatoire.nextInt(20) - 10;
           if (this.bonusmalus < 0) {
               this.name = "Soupe de jus de chaussette";
               this.duree = 5;
           }
           if (this.bonusmalus > 0) {
               this.name = "Gateau au chocolat";
               this.duree = 7;
           }
           while (this.bonusmalus == 0){
               this.bonusmalus = generateurAleatoire.nextInt(20)-10;
               if (this.bonusmalus < 0) {
                   this.name = "Soupe de jus de chaussette";
                   this.duree = 10;
               }
               if (this.bonusmalus > 0) {
                   this.name = "Gateau au chocolat";
                   this.duree = 7;
               }
           }
           return this.bonusmalus;
       }
}
