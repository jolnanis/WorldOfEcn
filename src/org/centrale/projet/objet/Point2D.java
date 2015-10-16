/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe représentant un point du plan.
 * @author Nicolas Sirletti
 */
public class Point2D {
    /**
     * Abcisse.
     */
    private int x;
    /**
     * Ordonnée
     */
    private int y;
    /**
     * Constructeur sans argument de la classe Point2D.
     * Initialise le point à l'origine (0,0)
     */
    public Point2D(){
        this.x=0;
        this.y=0;
    }
    /**
     * Constructeur général de la classe Point2D (à privilégier).
     * @param x
     *      Abcisse
     * @param y 
     *      Ordonnée
     */
    public Point2D(int x, int y){
        this.x=x;
        this.y=y;
    }
    /**
     * Constructeur de recopie de la classe Point2D
     * @param p Instance de Point2D à copier
     */
    public Point2D(Point2D p){
        x=p.x;
        y=p.y;
    }
    /**
     * Setter du champ x (abcisse) de la classe Point2D.
     * @param x Nouvelle abcisse.
     */
    public void setX(int x){
        this.x=x;
    }
    /**
     * Setter général de la classe Point2D.
     * @param x Nouvelle abcisse
     * @param y Nouvelle ordonnée
     */
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
     /** 
     * Setter du champ y (ordonnée) de la classe Point2D.
     * @param y Nouvelle ordonnée.
     */
    public void setY(int y){
        this.y=y;
    }
    /**
     * Getter du champ x (abcisse) de la classe Point2D
     * @return Abcisse x du point.
     */
    public int getX(){
        return this.x;
    }
    /**
     * Getter du champ y (ordonnée) de la classe Point2D
     * @return Ordonnée y du point.
     */
    public int getY(){
        return this.y;
    }
    /**
     * Opère une translation de vecteur (dx,dy)
     * @param dx Abcisse du vecteur de translation
     * @param dy Ordonnée du vecteur de translation
     */
    public void translate(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }
    /**
     * Opère une translation de vecteur k.
     * @param k Vecteur de la translation
     */
    public void translate(Point2D k){
        this.x += k.x;
        this.y += k.y;
    }
    /**
     * Effectue une symétrie par rapport à l'origine
     */
    public void oppose(){
        this.x *= -1;
        this.y *= -1;
    }
    
    /**
     * Surcharge de la méthode equals pour la classe Point2D. Attention : méthode hashCode non modifiée 
     * 
     * @param p 
     * @return true si cet objet est identique à l'objet en argument, faux sinon
     */
    public boolean equals(Point2D p){
        if(p==null){return false;}
        else{return(x==p.x && y==p.y);}
    }
    /**
     * Affiche les coordonnées du point sous la forme [x,y]
     */
    public void affiche(){
        System.out.println("[" + x + "," + y + "]");
    }
    /**
     * Retourne true ssi la distance au point en argument est inférieure à 5.
     * @param pnew
     * @return
     */
    public boolean distancecinq(Point2D pnew){
        
            return (this.distance(pnew) < 5);
        
            
    }
    /**
     * Donne la distance associée à la norme 1 : p1.distance(p2) = |x1-x2|+|y1-y2|
     * @param p
     * @return
     */
    public int distance(Point2D p){
        return(Math.abs(p.x-this.x)+Math.abs(p.y-this.y));
    }
    
    
}
