package org.centrale.projet.objet;

import java.util.LinkedList;
import java.util.Random;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public abstract class Personnage extends Creature {
    //Attributs 

    private int pourcentageResistMag ;
    private int distAttMax ;

    /**
     * Nom du personnage.
     */
    protected String nom ;

    /**
     * Stock de nourriture apportant des bonus/malus.
     */
    protected LinkedList<Nourriture> stock;
    //Constructeurs

    /**
     * Constructeur sans argument de la classe Personnage.
     */
    public Personnage() {
        super();
        this.stock = new LinkedList<Nourriture>();
    }


    /**
     * Constructeur simple de la classe Personnage.
     * @param ptVie
     * @param pourcentageAtt
     * @param pourcentagePar
     * @param pourcentageResistMag
     * @param degAtt
     * @param ptPar
     * @param distAttMax
     * @param pos
     * @param nom
     * @param stock
     */
    public Personnage(int ptVie, int pourcentageAtt, int pourcentagePar, int pourcentageResistMag, int degAtt, int ptPar, int distAttMax, Point2D pos, String nom, LinkedList<Nourriture> stock) {
        super(ptVie,pourcentageAtt, pourcentagePar,  degAtt, ptPar, pos);
        this.pourcentageResistMag = pourcentageResistMag;
        this.distAttMax = distAttMax;
        this.nom = nom ;
        this.stock = stock ;
    }
    
    /**
     * Constructeur de recopie de la classe Personnage.
     * @param p
     */
    public Personnage(Personnage p){
        super(p);
        this.pourcentageResistMag = p.pourcentageResistMag;
        this.distAttMax = p.distAttMax;
        this.nom = p.nom ;
        this.stock = p.stock ;
    }
    
    //Accesseurs



    /**
     * 
     * @return
     */
    public int getPourcentageResistMag() {
        return pourcentageResistMag;
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return
     */
    public LinkedList<Nourriture> getStock() {
        return stock;
    }

    /**
     *
     * @param stock
     */
    public void setStock(LinkedList<Nourriture> stock) {
        this.stock = stock;
    }


    /**
     * 
     * @return
     */
    public int getDistAttMax() {
        return distAttMax;
    }

    
    //Modificateurs


    /**
     * 
     * @param pourcentageResistMag
     */
    public void setPourcentageResistMag(int pourcentageResistMag) {
        this.pourcentageResistMag = pourcentageResistMag;
    }



    /**
     * 
     * @param distAttMax
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    /**
     * Boire une potion p donnée en argument.
     * (Attribue les effets au personnage et détruit la potion)
     * @param p
     */
    public void boire(Potion p){
        if (p instanceof Soin){
            this.ptVie = this.ptVie + ((Soin)p).pV;  
        }
        else {
            if (this instanceof Mage){
                ((Mage)this).setPtMana(((Mage)this).getPtMana() + ((Mana)p).ptMana);
            }
        }
    }
    
    /**
     * Manger de la nourriture (fonctionnement similaire à Boire(Potion p))
     * @param n
     */
    public void manger(Nourriture n){
        Random generateurAleatoire = new Random();
        int carac = generateurAleatoire.nextInt(3);
        switch (carac){
            case 0 :
                int k = this.pourcentageAtt;
                System.out.println("Votre pourcentage d'attaque était :" + k);
                this.pourcentageAtt = k + n.bonusmalus ;
                this.stock.add(n);
                if (k < this.pourcentageAtt){
                    System.out.println("Bien joué, c'était un gâteau au chocolat. Votre pourcentage attaque est maintenant" + this.pourcentageAtt + " pendant 10 tours");
                }
                else {
                    System.out.println("Ha, pas de chance, c'était une soupe de jus de chaussette.Votre pourcentage attaque est maintenant" + this.pourcentageAtt + "pendant 10 tours ");
                }
                break;
            case 1 :
                int l = this.pourcentagePar;
                System.out.println("Votre pourcentage de parade était :" + l);
                this.pourcentagePar = l + n.bonusmalus ;
                this.stock.add(n);
                if (l < this.pourcentagePar){
                    System.out.println("Bien joué, c'était un gâteau au chocolat. Votre pourcentage parade est maintenant" + this.pourcentagePar + " pendant 10 tours");
                }
                else {
                    System.out.println("Ha, pas de chance, c'était une soupe de jus de chaussette.Votre pourcentage parade est maintenant" + this.pourcentagePar + "pendant 10 tours ");
                }
                break;
            case 2 :
                int m = this.degAtt;
                System.out.println("Votre attaque était :" + m);
                this.degAtt = m + n.bonusmalus ;
                this.stock.add(n);
                if (m < this.degAtt){
                    System.out.println("Bien joué, c'était un gâteau au chocolat. Votre attaque est maintenant" + this.degAtt + " pendant 10 tours");
                }
                else {
                    System.out.println("Ha, pas de chance, c'était une soupe de jus de chaussette. Votre attaque est maintenant" + this.degAtt + "pendant 10 tours ");
                }
                break;
            case 3 :
                int o = this.distAttMax;
                System.out.println("Votre pourcentage de parade était :" + o);
                this.distAttMax = o + n.bonusmalus ;
                this.stock.add(n);
                if (o < this.distAttMax){
                    System.out.println("Bien joué, c'était un gâteau au chocolat. Votre distance maximale d'attaque est maintenant" + this.distAttMax + " pendant 10 tours");
                }
                else {
                    System.out.println("Ha, pas de chance, c'était une soupe de jus de chaussette. Votre distance maximale d'attaque est maintenant" + this.distAttMax + "pendant 10 tours");
                }
                break;
        }
    }
    
    /**
     * Cherche les créatures à une distance n du personnage et renvoie une liste.
     * (Distance définie par la norme 1)
     * @param n
     * @return
     */
    public LinkedList<Creature>  chercherAttaquables(int n){
    LinkedList attaquables = new LinkedList<Creature>();
    int x = this.getPos().getX();
    int y = this.getPos().getY();
    for (int i = Math.max(0,x-n) ; i <= Math.min(x+n,50) ; i++ ){
        for (int j = Math.max(0,x-n) ; j <= Math.min(x+n,50); j++ ){
                if ((Personnage.map[i][j] instanceof Creature)&&!(i==x&&j==y)){
                        attaquables.add(Personnage.map[i][j]);
                }
        }
    }
    attaquables.remove(Personnage.map[x][y]);
    return attaquables;
    }

    /**
     * Affiche en fait toute la carte du jeu avec des lettres pour représenter les elements.
     */
    public void afficherEnvirons(){
        int N = 12;
        this.pos.affiche();
        int x = this.getPos().getX();
        int y = this.getPos().getY();
        System.out.println(x+" "+y);
        for (int i = 49; i >= 0; i--) {
            for (int j = 0; j < 50; j++) {
                this.afficherCase(i, j);
            }
            System.out.println();
        }
    }

    /**
     * Print le contenu de la case avec le code suivant :
     * Y pour le personnage (You)
     * P pour Paysan
     * L pour Lapin
     * L pour Loup (aussi)
     * A pour Archer
     * G pour Guerrier
     * M pour Mage
     * O pour les Objets (Nourriture ou Potion)
     * @param i
     * @param j
     */
    public void afficherCase(int i, int j){
        ElementDuJeu contenuCase = Personnage.map[i][j];
        if (contenuCase == null){
            System.out.print(". ");
        }
        else if (contenuCase.equals(this)){
            System.out.print("Y ");
        }
        else if (contenuCase instanceof Loup){
            System.out.print("L ");
        }
        else if (contenuCase instanceof Archer){
            System.out.print("A ");
        }
        else if (contenuCase instanceof Paysan){
            System.out.print("P ");
        }
        else if (contenuCase instanceof Guerrier){
            System.out.print("G ");
        }
        else if (contenuCase instanceof Mage){
            System.out.print("M ");
        }
        else if (contenuCase instanceof Objet){
            System.out.print("O ");
        }
        else if (contenuCase instanceof Lapin){
            System.out.print("R ");
        }
        else {
            System.out.print("* ");
        }
        
    }

    /**
     * Recherche les créatures pouvant attaquer le personnage et renvoie une liste.
     * @return
     */
    public LinkedList<Creature> chercherPeutAttaquer(){
        LinkedList peutAttaquer = new LinkedList<Creature>();
        int x = this.getPos().getX();
        int y = this.getPos().getY();
        for (int i = Math.max(0, x-10) ; i <= Math.min(x+10, 50); i++){
            for (int j = Math.max(0, x-10); j<= Math.min(x+10,50); j++){
                if (((Personnage.map[i][j] instanceof Archer) || (Personnage.map[i][j] instanceof Mage)) && !(i==x && j==y)){
                    peutAttaquer.add(Personnage.map[i][j]);
                }
            }
        }
        for (int i = Math.max(0, x-1) ; i <= Math.min(x+1, 50); i++){
            for (int j = Math.max(0, x-1); j<= Math.min(x+1,50); j++){
                if (((Personnage.map[i][j] instanceof Guerrier) || (Personnage.map[i][j] instanceof Loup)) && !(i==x && j==y)){
                    peutAttaquer.add(Personnage.map[i][j]);
                }
            }
        }
        peutAttaquer.remove(Personnage.map[x][y]);
        return peutAttaquer;
    }
    
}
