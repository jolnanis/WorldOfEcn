package org.centrale.projet.objet;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Random ;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class World {
    //Attributs

    /**
     * Créatures présentes dans le monde (accès en liste pour permettre de mapper des actions sur toutes les créatures)
     */
       public LinkedList<Creature> creatures;
       public LinkedList<Potion> potions;
       public LinkedList<Nourriture> nourritures;
       public Joueur joueur1;
       public Joueur joueur2;
    
 
    //Constructeurs
    
    /**
     * Constructeur sans argument de World : Initialise avec 0 créatures.
     */
    public World() {
            this.creatures = new LinkedList<Creature>();
            this.nourritures = new LinkedList<Nourriture>();
            this.potions = new LinkedList<Potion>();
            this.joueur1 = new Joueur();
            this.joueur2 = new Joueur();
            
    }
    //Méthodes
    /**
     * Instancie un nombre nbCreatures de créatures positionnées aléatoirement.
     */
    public void creeMondeAlea(){
        Point2D position = new Point2D();
        Random generateurAleatoire = new Random();
        
        int nbCreatures = 150;
        int nbNourritures = 75 ;
        int nbPotions = 100 ;
        
        int idCreature;
        int idPotions;
        
        
        /*Soin s1 = new Soin();
        s1.pos.setX(2);
        s1.pos.setY(2);
        s1.placeDansMap();
        Soin s2 = new Soin();
        s2.pos.setX(1);
        s2.pos.setY(4);
        s2.placeDansMap();
        Soin s3 = new Soin();
        s3.pos.setX(4);
        s3.pos.setY(4);
        s3.placeDansMap();
        
        Mana m1 = new Mana();
        m1.pos.setX(3);
        m1.pos.setY(5);
        m1.placeDansMap();
        Mana m2 = new Mana();
        m2.pos.setX(4);
        m2.pos.setY(1);
        m2.placeDansMap();*/
        
        
        
        for (int i = 0; i<nbCreatures;i++) {
            idCreature = generateurAleatoire.nextInt(5);
            switch (idCreature) {
                    case 0 : creatures.add(new Lapin(50, 60, 30, 5, 5, new Point2D(0,0)));
                    break;
                    case 1 : creatures.add(new Archer(7,100, 50, 50, 70, 40, 50, 10, new Point2D(0,0), "Robin", new LinkedList<Nourriture>()));
                    break;
                    case 2 : creatures.add(new Paysan(80, 70, 10, 10, 60, 30, 1, new Point2D(0,0), "Aeon", new LinkedList<Nourriture>()));
                    break;
                    case 3 : creatures.add(new Guerrier(5, 100, 70, 50, 20, 60, 60, 1, new Point2D(0,0), "Arthur", new LinkedList<Nourriture>()));
                    break;
                    case 4 : creatures.add(new Loup(100, 60, 20, 60 , 30, new Point2D(0,0)));
                    break;
                    case 5 : creatures.add(new Mage(20, 50, 60, 100, 30, 80, 50, 50, 50, 10, new Point2D(0,0), "Merlin", new LinkedList<Nourriture>()));
                    break;
                    
                    
            }
        }
        /*
         * World.save dans le répertoire /shared/Documents/Cours/OBJET/TP1 or so. 
         */
        //On place les créatures
        // Copie par référence de la première créature de la liste, puis initialisation de sa position. 
        //Creature creaPrecedente = creatures.getFirst();
        ElementDuJeu.map = new ElementDuJeu[50][50];
        
        
        //position.setX(dx);

        //position.setY(dy);
        
        //creaPrecedente.setPos(position);
        //creaPrecedente.placeDansMap();
        
        //int k = 0;
        
        //long maintenant = System.nanoTime();
        for (Creature c : creatures) {
            // On tire une position parmi les cases à 5 cases autour de la créature précédente.
            //c.setPos(creaPrecedente.getPos());
            //On vérifie que cette position est bien sur le plateau
            //boolean b = true;
            int dx = generateurAleatoire.nextInt(50);
            int dy = generateurAleatoire.nextInt(50);
            //while (b) {
            while (ElementDuJeu.map[dx][dy] != null){
                dx = generateurAleatoire.nextInt(50);
                dy = generateurAleatoire.nextInt(50);
               
                }
            position.setX(dx);
            position.setY(dy);
            
            c.setPos(position);
            c.placeDansMap();
                
                
            }

            
        
        //On place les nourritures
        for (int i=0; i<=nbNourritures ; i++){
            nourritures.add(new Nourriture());
        }
        for (Nourriture n : nourritures){
            int dx2 = generateurAleatoire.nextInt(50);
            int dy2 = generateurAleatoire.nextInt(50);
            while (ElementDuJeu.map[dx2][dy2] != null){
                dx2 = generateurAleatoire.nextInt(50);
                dy2 = generateurAleatoire.nextInt(50);
            }
            n.pos.setX(dx2);
            n.pos.setY(dy2);
            n.placeDansMap();
        }
        
        //On place les potions
        for (int i=0; i<=nbPotions ; i++){
            idPotions = generateurAleatoire.nextInt(1);
            switch (idPotions){
                case 0 : potions.add(new Soin());
                    break;
                case 1 : potions.add(new Mana());
                    break;
            }
        }
        for (Potion p : potions){
            int dx3 = generateurAleatoire.nextInt(50);
            int dy3 = generateurAleatoire.nextInt(50);
            while (ElementDuJeu.map[dx3][dy3] != null){
                dx3 = generateurAleatoire.nextInt(50);
                dy3 = generateurAleatoire.nextInt(50);
            }
            p.pos.setX(dx3);
            p.pos.setY(dy3);
            p.placeDansMap();
        }
        
        
        
        }    

    /**
     * Effectue un tour de jeu (déplacement et attaques) pour un joueur. 
     * @param player
     */
    public void tourDuJeu(Joueur player){
        
        for (Creature c : creatures){
                //c.pos.affiche();
                c.deplace();
            }

            player.jDeplacer();
            player.p.afficherEnvirons();
            System.out.println("Légende :");
            System.out.println("Y = Joueur actif ; A = Archer ; G = Guerrier ; M = Mage ; L = Loup ; R = Lapin");
            System.out.println("N = nourriture ; V = potion vie ; W = potion mana");
            System.out.println("Position modifiée du joueur");
            player.p.pos.affiche();
            player.jCombattre();
            System.out.println("Vie du joueur après combat");
            System.out.println(player.p.ptVie);
            if (player.p.stock.size() != 0){
                for (int i=0; i<=player.p.stock.size(); i++){
                    if (player.p.stock.get(i).duree==0){
                        player.p.stock.remove(i);
                    }
                    else{
                        player.p.stock.get(i).duree --;
                    }
                }
            }
    }

public void charge(String ligne) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{

          StringTokenizer tokenizer = new StringTokenizer(ligne, " ");
          Class cl = Class.forName("org.centrale.projet.objet."+tokenizer.nextToken());
          Constructor ct = cl.getConstructor();
          Object el = ct.newInstance();
          if (el instanceof Creature){
              this.creatures.add(((Creature)el));
            if (el instanceof Personnage){
                if (el instanceof Archer){
                    ((Archer)el).setNbFleches(Integer.parseInt(tokenizer.nextToken()));
                }
                if (el instanceof Guerrier){
                    ((Guerrier)el).setViolence(Integer.parseInt(tokenizer.nextToken()));
                }
                if (el instanceof Mage){
                    ((Mage)el).setPtMana(Integer.parseInt(tokenizer.nextToken()));
                    ((Mage)el).setDegMag(Integer.parseInt(tokenizer.nextToken()));
                    ((Mage)el).setPourcentageMag(Integer.parseInt(tokenizer.nextToken()));
                }
                ((Personnage)el).setPourcentageAtt(Integer.parseInt(tokenizer.nextToken()));
                ((Personnage)el).setPourcentagePar(Integer.parseInt(tokenizer.nextToken()));
                ((Personnage)el).setPourcentageResistMag(Integer.parseInt(tokenizer.nextToken()));
                ((Personnage)el).setDistAttMax(Integer.parseInt(tokenizer.nextToken()));
                ((Personnage)el).setNom(tokenizer.nextToken());
            }
            
                ((Creature)el).setPtVie(Integer.parseInt(tokenizer.nextToken()));
                ((Creature)el).setDegAtt(Integer.parseInt(tokenizer.nextToken()));
                ((Creature)el).setPtPar(Integer.parseInt(tokenizer.nextToken()));
                ((Creature)el).setPourcentageAtt(Integer.parseInt(tokenizer.nextToken()));
                ((Creature)el).setPourcentagePar(Integer.parseInt(tokenizer.nextToken()));
          }
          else {
              if (el instanceof Mana){
                 ((Mana)el).setPtMana(Integer.parseInt(tokenizer.nextToken()));
              }
              if (el instanceof Soin){
                 ((Soin)el).setPV(Integer.parseInt(tokenizer.nextToken())); 
              }
              if (el instanceof Nourriture){
                 ((Nourriture)el).setBonusmalus(Integer.parseInt(tokenizer.nextToken()));
                 ((Nourriture)el).setName(tokenizer.nextToken());
                 ((Nourriture)el).setDuree(Integer.parseInt(tokenizer.nextToken()));
                this.nourritures.add(((Nourriture)el));
              }else{
                this.potions.add(((Potion)el));
              }
          }
          
          Point2D pos = new Point2D(Integer.parseInt(tokenizer.nextToken()),
          Integer.parseInt(tokenizer.nextToken()));
          ((ElementDuJeu)el).setPos(pos);
          ((ElementDuJeu)el).placeDansMap();
      
}    
}
