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
    
    ChargementPartie(String fichier){
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
      sekai.charge(ligne);
      sekai.joueur1.p=(Personnage) sekai.creatures.getLast();
      ligne = lecteur.readLine();
      sekai.charge(ligne);
      sekai.joueur2.p=(Personnage) sekai.creatures.getLast();
      while (ligne != null) {
          sekai.charge(ligne);
          ligne = lecteur.readLine();
          
      }
      lecteur.close();
      return sekai;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
    
        
    }
    
}
