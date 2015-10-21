/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author nico
 */
public class SauvegardePartie {
    String fichier;
    BufferedWriter scripteur;

    SauvegardePartie(String fichier ){
    try{
    this.fichier = fichier;
    scripteur = new BufferedWriter(new FileWriter(fichier));
    
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    }
    public void SauvegarderPartie(World sekai) {
      try{
      LinkedList<ElementDuJeu> liste = new LinkedList<ElementDuJeu>();
      liste.addAll(sekai.creatures);
      liste.addAll(sekai.nourritures);
      liste.addAll(sekai.potions);
      for (ElementDuJeu el : liste) {
          scripteur.write(el.getClass().getSimpleName()+" ");
          if (el instanceof Creature){
            if (el instanceof Personnage){
                if (el instanceof Archer){
                    scripteur.write(((Archer)el).getNbFleches()+" ");
                }
                if (el instanceof Guerrier){
                    scripteur.write(((Guerrier)el).getViolence()+" ");
                }
                
                if (el instanceof Mage){
                    scripteur.write(((Mage)el).getPtMana()+" ");
                    scripteur.write(((Mage)el).getDegMag()+" ");
                    scripteur.write(((Mage)el).getPourcentageMag()+" ");
                }
                
                scripteur.write(((Personnage)el).getPourcentageAtt()+" ");
                scripteur.write(((Personnage)el).getPourcentagePar()+" ");
                scripteur.write(((Personnage)el).getPourcentageResistMag()+" ");
                scripteur.write(((Personnage)el).getDistAttMax()+" ");
                scripteur.write(((Personnage)el).getNom()+" ");
                }
            scripteur.write(((Creature)el).getPtVie()+" ");
            scripteur.write(((Creature)el).getDegAtt()+" ");
            scripteur.write(((Creature)el).getPtPar()+" ");
            scripteur.write(((Creature)el).getPourcentageAtt()+" ");
            scripteur.write(((Creature)el).getPourcentagePar()+" ");
            }
          else {
              if (el instanceof Mana){
                scripteur.write(((Mana)el).getPtMana()+" ");
              }
              if (el instanceof Soin){ 
                scripteur.write(((Soin)el).getPV()+" ");
              }
              if (el instanceof Nourriture){
                scripteur.write(((Nourriture)el).getBonusmalus()+" ");
                scripteur.write(((Nourriture)el).getName()+" ");
                scripteur.write(((Nourriture)el).getDuree()+" ");
              }
          }
          scripteur.write(el.getPos().getX()+" "+el.getPos().getY());
          scripteur.newLine();
      }
      scripteur.close();
    } catch (Exception e) {
      e.printStackTrace();
    }    
    }
    
    
}
