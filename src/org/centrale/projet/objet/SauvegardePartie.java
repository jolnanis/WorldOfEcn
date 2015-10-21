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
      
      sekai.joueur1.p.enregistre(scripteur);
      scripteur.newLine();
      sekai.joueur2.p.enregistre(scripteur);
      scripteur.newLine();
      
      
      LinkedList<ElementDuJeu> liste = new LinkedList<ElementDuJeu>();
      liste.addAll(sekai.creatures);
      liste.remove(sekai.joueur1.p);
      liste.remove(sekai.joueur2.p);
      liste.addAll(sekai.nourritures);
      liste.addAll(sekai.potions);
      for (ElementDuJeu el : liste) {
          el.enregistre(scripteur);
          scripteur.newLine();
      }
      scripteur.close();
    } catch (Exception e) {
      e.printStackTrace();
    }    
    }
    
    
}
