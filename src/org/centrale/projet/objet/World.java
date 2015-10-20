package org.centrale.projet.objet;

import java.util.Random ;
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
public class World {
    //Attributs
   public LinkedList<Creature> creatures;
    
 
    //Constructeurs
    
    /**
     * Constructeur sans argument de World : Initialise avec 0 créatures.
     */
    public World() {
            this.creatures = new LinkedList<Creature>();
    }
    //Méthodes
    /**
     * Instancie un nombre nbCreatures de créatures positionnées aléatoirement.
     */
    public void creeMondeAlea(){
        Point2D position = new Point2D();
        Random generateurAleatoire = new Random();
        
        int nbCreatures = 20;
        
        int idCreature;
        
        
        Soin s1 = new Soin();
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
        m2.placeDansMap();
        
        
        
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
                    case 4 : creatures.add(new Loup(false, 100, 60, 20, 60 , 30, new Point2D(0,0)));
                    break;
                    case 5 : creatures.add(new Mage(20, 50, 60, 100, 30, 80, 50, 50, 50, 10, new Point2D(0,0), "Merlin", new LinkedList<Nourriture>()));
                    break;
                    
                    
            }
        }
        /*
         * World.save dans le répertoire /shared/Documents/Cours/OBJET/TP1 or so. 
         */
        
        // Copie par référence de la première créature de la liste, puis initialisation de sa position. 
        Creature creaPrecedente = creatures.getFirst();
        ElementDuJeu.map = new ElementDuJeu[50][50];
        
        int dx = generateurAleatoire.nextInt(50);
        position.setX(dx);
        int dy = generateurAleatoire.nextInt(50);
        position.setY(dy);
        
        creaPrecedente.setPos(position);
        creaPrecedente.placeDansMap();
        
        int k = 0;
        
        long maintenant = System.nanoTime();
        for (Creature c : creatures) {
            // On tire une position parmi les cases à 5 cases autour de la créature précédente.
            c.setPos(creaPrecedente.getPos());
            //On vérifie que cette position est bien sur le plateau
            boolean b = true;
            
            while (b) {
                dx = generateurAleatoire.nextInt(20)-10;
                position.setX(c.getPos().getX() + dx);
                dy = generateurAleatoire.nextInt(20)-10;
                position.setY(c.getPos().getY() + dy);
                if (((position.getX() > 0) && (position.getX() < 50) && (position.getY() > 0) && (position.getY() < 50))){
                    if (ElementDuJeu.map[c.getPos().getX() + dx][c.getPos().getY() + dy] == null) {
                        b = false;
                    }
                }
                
                
            }
            position.setX(c.getPos().getX() + dx);
            position.setY(c.getPos().getY() + dy);
            
            c.setPos(position);
            c.placeDansMap();
            k++;
            
            

            
            
            
        }
        

        
 
    }
    
    public void tourDuJeu(Joueur player){
        
//        for (Creature c : creatures){
//                c.pos.affiche();
//                c.deplace();
//            }
            player.p.afficherEnvirons();
            player.jDeplacer();
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

    
}
