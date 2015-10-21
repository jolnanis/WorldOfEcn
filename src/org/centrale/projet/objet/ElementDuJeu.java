/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.StringTokenizer;

/**
 *
 * @author nico
 */
abstract public class ElementDuJeu {

    /**
     * Matrice static dont chaque élément pointe vers ce que contient la case correspondante :
     * Objet, Creature, ou null si la case est vide.
     */
    protected static ElementDuJeu[][] map;

    /**
     * Position de l'élément du jeu.
     */
    protected Point2D pos;
    
    /**
     * Constructeur sans argument de ElementDuJeu.
     */
    public ElementDuJeu() {
        this.pos = new Point2D(0,0);
    }
        //Getter et setter

    public static ElementDuJeu[][] getMap() {
        return map;
    }

    public static void setMap(ElementDuJeu[][] map) {
        ElementDuJeu.map = map;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    /**
     * Ajoute un pointeur dans map vers l'élément d'où la méthode est appellée, à la cordonnée this.pos de la matrice.
     */
        public void placeDansMap(){
        ElementDuJeu.map[this.pos.getX()][this.pos.getY()] = this;
    }
    
    /**
     * Permet d'effectuer des requêtes dans map à partir d'une position (Point2D) et non de coordonnées.
     * @param position
     * @return
     */
    public static ElementDuJeu trouveDansMap(Point2D position){
        return ElementDuJeu.map[position.getX()][position.getY()];
    }
    public void enregistre(BufferedWriter scripteur) throws IOException{
        
          scripteur.write(this.getClass().getSimpleName()+" ");
          if (this instanceof Creature){
            if (this instanceof Personnage){
                if (this instanceof Archer){
                    scripteur.write(((Archer)this).getNbFleches()+" ");
                }
                if (this instanceof Guerrier){
                    scripteur.write(((Guerrier)this).getViolence()+" ");
                }
                
                if (this instanceof Mage){
                    scripteur.write(((Mage)this).getPtMana()+" ");
                    scripteur.write(((Mage)this).getDegMag()+" ");
                    scripteur.write(((Mage)this).getPourcentageMag()+" ");
                }
                
                scripteur.write(((Personnage)this).getPourcentageAtt()+" ");
                scripteur.write(((Personnage)this).getPourcentagePar()+" ");
                scripteur.write(((Personnage)this).getPourcentageResistMag()+" ");
                scripteur.write(((Personnage)this).getDistAttMax()+" ");
                scripteur.write(((Personnage)this).getNom()+" ");
                }
            scripteur.write(((Creature)this).getPtVie()+" ");
            scripteur.write(((Creature)this).getDegAtt()+" ");
            scripteur.write(((Creature)this).getPtPar()+" ");
            scripteur.write(((Creature)this).getPourcentageAtt()+" ");
            scripteur.write(((Creature)this).getPourcentagePar()+" ");
            }
          else {
              if (this instanceof Mana){
                scripteur.write(((Mana)this).getPtMana()+" ");
              }
              if (this instanceof Soin){ 
                scripteur.write(((Soin)this).getPV()+" ");
              }
              if (this instanceof Nourriture){
                scripteur.write(((Nourriture)this).getBonusmalus()+" ");
                scripteur.write(((Nourriture)this).getName()+" ");
                scripteur.write(((Nourriture)this).getDuree()+" ");
              }
          }
          scripteur.write(this.getPos().getX()+" "+this.getPos().getY());
    }   


}