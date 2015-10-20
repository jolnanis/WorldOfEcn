/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

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
        //Méthodes se rapprochant de getter et setter

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
    
}
