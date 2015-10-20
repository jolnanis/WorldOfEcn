/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Antoine
 */
public class Joueur {
    //Attributs
    Personnage p;
    
    //Constructeurs
    public Joueur(){
            this.p = null;
    }
    

    public Joueur(Personnage p) {
        this.p = p;
    }
    
    //Accesseurs

    public Personnage getP() {
        return p;
    }
    
    //Modificateurs

    public void setP(Personnage p) {
        this.p = p;
    }
    
    //Méthodes
    public void bienvenue(){
        System.out.println("1 = Archer ; 2 = Guerrier ; 3 = Mage. Rentrez le chiffre correspondant au personnage souhaité");
        Scanner sc = new Scanner(System.in);
        int nb = sc.nextInt();
        switch(nb){
            case 1 : this.p = new Archer();
                break;
            case 2 : this.p = new Guerrier();
                break;
            case 3 : this.p = new Mage();
                break;
            default : this.p = new Paysan();
                System.out.println("Désolé, vous êtes un paysan, il fallait choisir un meilleur chiffre !");
                break;
                }
        System.out.println("Rentrez le nom de votre personnage");
        Scanner sc2 =  new Scanner(System.in);
        String baptise = sc2.nextLine();
        this.p.nom = baptise ;
        
        Random generateurAleatoire = new Random();
        switch (nb){
            case 1 :
                p.pos.setX(25);
                p.pos.setY(25);
                p.pourcentageAtt = generateurAleatoire.nextInt(10) + 55 ;
                p.pourcentagePar = generateurAleatoire.nextInt(5) + 70 ;
                p.ptVie = 100 ;
                p.degAtt = generateurAleatoire.nextInt(5) + 25 ;
                p.ptPar = generateurAleatoire.nextInt(5) + 50 ;
                p.setPourcentageResistMag(generateurAleatoire.nextInt(5) + 50) ;
                p.setDistAttMax(generateurAleatoire.nextInt(2) + 7) ;
                ((Archer)p).setNbFleches(generateurAleatoire.nextInt(3) + 10) ;
                break;
            case 2 :
                p.pos.setX(25);
                p.pos.setY(25);
                p.pourcentageAtt = generateurAleatoire.nextInt(10) + 75 ;
                p.pourcentagePar = generateurAleatoire.nextInt(5) + 40 ;
                p.ptVie = 100 ;
                p.degAtt = generateurAleatoire.nextInt(5) + 50 ;
                p.ptPar = generateurAleatoire.nextInt(5) + 60 ;
                p.setPourcentageResistMag(generateurAleatoire.nextInt(5)+10);
                p.setDistAttMax(1);
                ((Guerrier)p).setViolence(generateurAleatoire.nextInt(5) + 5);
                break;
            case 3 :
                p.pos.setX(25);
                p.pos.setY(25);
                p.pourcentageAtt = generateurAleatoire.nextInt(10) + 50 ;
                p.pourcentagePar = generateurAleatoire.nextInt(5) + 75 ;
                p.ptVie = 100 ;
                p.degAtt = generateurAleatoire.nextInt(5) + 30 ;
                p.ptPar = generateurAleatoire.nextInt(5) + 40 ;
                p.setDistAttMax(generateurAleatoire.nextInt(2)+10);
                p.setPourcentageResistMag(generateurAleatoire.nextInt(5)+70);
                ((Mage)p).setPtMana(generateurAleatoire.nextInt(10)+60);
                ((Mage)p).setDegMag(generateurAleatoire.nextInt(10)+60);
                ((Mage)p).setPourcentageMag(generateurAleatoire.nextInt(5)+40);
                break;
            default :
                p.pos.setX(25);
                p.pos.setY(25);
                p.degAtt = generateurAleatoire.nextInt(2) + 10 ;
                p.pourcentageAtt = generateurAleatoire.nextInt(5) + 70 ;
                p.pourcentagePar = generateurAleatoire.nextInt(5) + 20 ;
                p.ptPar = generateurAleatoire.nextInt(5) + 30 ;
                p.setDistAttMax(3);
                p.setPourcentageResistMag(generateurAleatoire.nextInt(5)+2);
                break;
        }
    }
    
    public void peutSeDeplacer(Point2D position){
        if (((p.pos.getX() + position.getX() >= 0) && (p.pos.getX() + position.getX() <= 50) && 
             (p.pos.getY() + position.getY() >= 0) && (p.pos.getY() + position.getY() <= 50)) &&
             ((ElementDuJeu.map[this.p.pos.getX()+position.getX()][this.p.pos.getY()+position.getY()] == null) || 
             (ElementDuJeu.map[this.p.pos.getX()+position.getX()][this.p.pos.getY()+position.getY()] instanceof Objet))){
              p.deplace(position);
              p.placeDansMap();
        }
        else{
           System.out.println("Eh non petit garnement. Tu sors de la map, ou t'écrases un de tes compagnons. Allez, file donc ailleurs");
        }
        
    }
    
    public void jDeplacer(){
        System.out.println("Les déplacements se font de la manière suivante :"
                           + " Haut : 5 "
                           + " Bas : 2 "
                           + " Gauche : 1 "
                           + " Droite : 3 "
                           + " Et diagonales en conséquence");
        Scanner sc3 =  new Scanner(System.in);
        int deplacement = sc3.nextInt();
        switch (deplacement){
            case 5 : 
                Point2D Direction5 = new Point2D(1,0);
                this.peutSeDeplacer(Direction5);
                break;
            case 2 :
                Point2D Direction2 = new Point2D(-1,0);
                this.peutSeDeplacer(Direction2);
                break;
            case 1 : 
                Point2D Direction1 = new Point2D(0,-1);
                this.peutSeDeplacer(Direction1);
                break;
            case 3 :
                Point2D Direction3 = new Point2D(0,1);
                this.peutSeDeplacer(Direction3);
                break;
            case 51 : case 15 :
                Point2D Direction52 = new Point2D(1,-1);
                this.peutSeDeplacer(Direction52);
                break;
            case 53 : case 35 :
                Point2D Direction53 = new Point2D(1,1);
                this.peutSeDeplacer(Direction53);
                break;
            case 21 : case 12 :
                Point2D Direction21 = new Point2D(-1,-1);
                this.peutSeDeplacer(Direction21);
                break;
            case 23 : case 32 :
                Point2D Direction32 = new Point2D(-1,1);
                this.peutSeDeplacer(Direction32);
                break;
            default : 
                System.out.println("Les autres boutons ne permettent pas de voler, désolé");
                break;
        
                
        }
    }
    
    //Choix d'un combat.
    public void jCombattre(){
        LinkedList attaquables = new LinkedList<Creature>();
        if (this.p instanceof Guerrier) {
            //On charge une liste de créatures adjacentes attaquables
            attaquables = this.p.chercherAttaquables(1);
        }
        else if (this.p instanceof Archer || this.p instanceof Mage){
            //On charge une liste de créatures à distance attaquable
            attaquables = this.p.chercherAttaquables(this.p.getDistAttMax());
        }
        Scanner sc3 =  new Scanner(System.in);
        String scanner;
        for (Object a : attaquables){
            System.out.println("Voulez vous attaquer le "+((Creature)a).getClass().getName()+" qui se trouve en "+((Creature)a).getPos()+" ? (Y/n)");
            scanner = sc3.nextLine();
            if (scanner.equals("y")){
                System.out.println("Vie de l'adversaire avant attaque :");
                System.out.println(((Creature)a).ptVie);
                ((Combattant)this.p).combattre((Creature)a);
                if ((this.p instanceof Archer) || (this.p instanceof Mage)){
                    if (this.p.pos.distance(((Creature)a).pos) > 1){
                        if (((Creature)a) instanceof Archer || ((Creature)a) instanceof Mage){
                            ((Creature)a).combattre(p);
                        }
                    }
                    else{
                        ((Creature)a).combattre(p);
                    }
                }
                else{
                    ((Creature)a).combattre(p);
                }
                System.out.println("Vie de l'adversaire après attaque :");
                System.out.println(((Creature)a).ptVie);
            }
        }
    }
}
