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
public abstract class Creature  extends ElementDuJeu implements Deplacable{
//Attributs
    /**
     * Points de vie
     */
    protected int ptVie;
    /**
     * Chances de succès d'une attaque
     */
    protected int pourcentageAtt;
    /**
     * Chances de succès d'une parade
     */
    protected int pourcentagePar;
    /**
     * Dégâts d'attaque
     */
    protected int degAtt;
    /**
     * Points de parade
     */
    protected int ptPar;

//Constructeurs
    /**
     * Constructeur sans argument de la classe créature
     */
    public Creature() {
        this.pos = new Point2D();
    }

    /**
     * Constructeur de la classe Créature.
     * @param ptVie
     * @param pourcentageAtt
     * @param pourcentagePar
     * @param degAtt
     * @param pos
     * @param ptPar
     */
    public Creature(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptPar, Point2D pos) {
        this.ptVie = ptVie;
        this.pourcentageAtt = pourcentageAtt;
        this.pourcentagePar = pourcentagePar;
        this.degAtt = degAtt;
        this.ptPar = ptPar;
        this.pos = pos;
    }
    /**
     * Constructeur de recopie de la classe Créature
     * @param c
     */
    public Creature(Creature c) {
        this.ptVie = c.ptVie;
        this.pourcentageAtt = c.pourcentageAtt;
        this.pourcentagePar = c.pourcentagePar;
        this.degAtt = c.degAtt;
        this.ptPar = c.ptPar;
        this.pos = new Point2D(c.pos);
    }
// Accesseurs
    /**
     * 
     * @return
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     * 
     * @return
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     * 
     * @return
     */
    public int getPourcentageAtt() {
        return pourcentageAtt;
    }

    /**
     * 
     * @return
     */
    public int getPourcentagePar() {
        return pourcentagePar;
    }

    /**
     * 
     * @return
     */
    public int getPtVie() {
        return ptVie;
    }
    
    /**
     *
     * @return
     */
    public int getPtPar(){
        return ptPar;
    }
    
//Modificateurs

    /**
     * 
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     * 
     * @param pos
     */
    public void setPos(Point2D pos) {
        this.pos = new Point2D(pos);
    }

    /**
     * 
     * @param pourcentageAtt
     */
    public void setPourcentageAtt(int pourcentageAtt) {
        this.pourcentageAtt = pourcentageAtt;
    }

    /**
     * 
     * @param pourcentagePar
     */
    public void setPourcentagePar(int pourcentagePar) {
        this.pourcentagePar = pourcentagePar;
    }

    /**
     * 
     * @param ptVie
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }
    
    /**
     *
     * @param ptPar
     */
    public void setPtPar(int ptPar){
        this.ptPar = ptPar;
    }
    
    /**
     * Déplacement selon un vecteur (représenté par la classe Point2D).
     * @param vecteur
     */
    public void deplace (Point2D vecteur){
        ElementDuJeu.map[this.pos.getX()][this.pos.getY()] = null ;
        if (ElementDuJeu.map[this.pos.getX()+vecteur.getX()][this.pos.getY()+vecteur.getX()] instanceof Potion){
            ((Personnage)this).boire((Potion)ElementDuJeu.map[this.pos.getX()+vecteur.getX()][this.pos.getY()+vecteur.getX()]);
        }
        if (ElementDuJeu.map[this.pos.getX()+vecteur.getX()][this.pos.getY()+vecteur.getX()] instanceof Nourriture){
            ((Personnage)this).manger((Nourriture)ElementDuJeu.map[this.pos.getX()+vecteur.getX()][this.pos.getY()+vecteur.getX()]);
            ((Personnage)this).stock.add((Nourriture)ElementDuJeu.map[this.pos.getX()+vecteur.getX()][this.pos.getY()+vecteur.getX()]);
    }
        this.pos.translate(vecteur);
        this.placeDansMap() ;
        
    }
    /**
     * Déplacement aléatoire vers une case adjacente.
     */
    @Override
    public void deplace() {
        ElementDuJeu.map[this.pos.getX()][this.pos.getY()] = null ;
        Random rng = new Random();
        int delta1 = rng.nextInt(2)-1;
        int delta2 = rng.nextInt(2)-1;
        while (((this.pos.getX()+delta1)<0) || ((this.pos.getX()+delta1)>50)|| 
               ((this.pos.getY()+delta2)<0) || ((this.pos.getY()+delta2)>50)||
               (ElementDuJeu.map[this.pos.getX()+delta1][this.pos.getY()+delta2] != null )){
            delta1 = rng.nextInt(2)-1;
            delta2 = rng.nextInt(2)-1;
     }
        this.pos.setX(this.pos.getX()+delta1);
        this.pos.setY(this.pos.getY()+delta2);
        this.placeDansMap() ;

    }
    
    /**
     *
     * @param c
     */
    public void combattre(Creature c) {
    
    }
    
    
    
    
}
