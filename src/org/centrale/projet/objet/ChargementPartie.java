/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.StringTokenizer;

/**
 *
 * @author nico
 */
public class ChargementPartie {
    String fichier;
    BufferedReader lecteur;
    
    public void ChargementPartie(String fichier){
        try{
        this.fichier = fichier;
        lecteur = new BufferedReader(new FileReader(fichier));
    
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public World ChargerPartie(){
      try{
      World sekai = new World();
      String ligne ;
      ligne = lecteur.readLine();
      while (ligne != null) {
          StringTokenizer tokenizer = new StringTokenizer(ligne, " ");
          Class cl = Class.forName(tokenizer.nextToken());
          Constructor ct = cl.getConstructor();
          Object el = ct.newInstance();
          if (el instanceof Creature){
              sekai.creatures.add(((Creature)el));
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
                ((Creature)el).setPtVie(Integer.parseInt(tokenizer.nextToken()));
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
                sekai.nourritures.add(((Nourriture)el));
              }else{
                sekai.potions.add(((Potion)el));
              }
          }
          
          Point2D pos = new Point2D(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()));
          ((ElementDuJeu)el).setPos(pos);
          ((ElementDuJeu)el).placeDansMap();
      }
      lecteur.close();
      return sekai;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    
        
    }
    
}
