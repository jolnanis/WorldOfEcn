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
    protected static ElementDuJeu[][] map;
    protected Point2D pos;
    
    public ElementDuJeu() {
        this.pos = new Point2D(0,0);
    }
        //Méthodes se rapprochant de getter et setter
    public void placeDansMap(){
        ElementDuJeu.map[this.pos.getX()][this.pos.getY()] = this;
    }
    
    public static ElementDuJeu trouveDansMap(Point2D position){
        return ElementDuJeu.map[position.getX()][position.getY()];
    }
    
}
