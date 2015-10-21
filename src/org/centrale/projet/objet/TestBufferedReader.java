/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jean-Marie Normand (jean-marie.normand@ec-nantes.fr)
 */
import java.io.*;
import java.lang.reflect.Constructor;
import java.util.StringTokenizer;

public class TestBufferedReader {
  protected String source;
  
  public TestBufferedReader(String source) {
    this.source = source;
    lecture();
  }

  public static void main(String args[]) {
      TestBufferedReader testBufferedReader = new TestBufferedReader("Sauvegarde-WoE.txt");
  }

  private void lecture() { 
    try {
      String ligne ;
      BufferedReader fichier = new BufferedReader(new FileReader(source));
      ligne = fichier.readLine();
      while (ligne != null) {
          StringTokenizer tokenizer = new StringTokenizer(ligne, " ");
          Class cl = Class.forName(tokenizer.nextToken());
          Constructor ct = cl.getConstructor();
          Object el = ct.newInstance();
          if (el instanceof Creature){
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
            
                ((Personnage)el).setPtVie(Integer.parseInt(tokenizer.nextToken()));
                ((Personnage)el).setDegAtt(Integer.parseInt(tokenizer.nextToken()));
                ((Personnage)el).setPtPar(Integer.parseInt(tokenizer.nextToken()));
                ((Personnage)el).setPourcentageAtt(Integer.parseInt(tokenizer.nextToken()));
                ((Personnage)el).setPourcentagePar(Integer.parseInt(tokenizer.nextToken()));
                ((Personnage)el).setPtVie(Integer.parseInt(tokenizer.nextToken()));
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
              }
          }
          
          Point2D pos = new Point2D(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()));
//            while(tokenizer.hasMoreTokens()) {
//            // nextToken() retourne la prochaine unite lexicale decoupee par les delimiteurs
//            String mot = tokenizer.nextToken();
//            // pour l'exemple, on transforme 'mot' en lettres minuscules
//            mot = mot.toLowerCase();
//            // on affiche 'mot' qui est maintenant en minuscules
//            System.out.println(mot);
//            } 
      }

      fichier.close();
    } catch (Exception e) {
      e.printStackTrace();
    }     
  }    
}