/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author nico
 */
public class TestSeance2 {

    /**
     *
     * @param args
     */
    public static void main (String[] args){
        ElementDuJeu.map = new ElementDuJeu[50][50];
        World sekai = new World();
        Joueur player1 = new Joueur();
        Joueur player2 = new Joueur();
        player1.bienvenue();
        player2.bienvenue();
        System.out.println("Position intiale du joueur 1");
        player1.p.pos.affiche();
        System.out.println("Position intiale du joueur 2");
        player2.p.pos.affiche();
        //sekai.creatures = new LinkedList<Creature>();
        //sekai.creatures.add(new Guerrier(10, 100, 50, 60, 30, 60, 1, new Point2D(0,1),"YOLO"));
        sekai.creeMondeAlea();
           
        System.out.println("Commencer à jouer ? (Y/N)");
        Scanner sc2 =  new Scanner(System.in);
        String veutjouer = sc2.nextLine();
        while (!(veutjouer.equals("y")) && !(veutjouer.equals("n"))){
            System.out.println("Rentrez une réponse valide ! y pour jouer, n pour ne pas jouer");
            veutjouer = sc2.nextLine();
        }
        while (veutjouer.equals("y")){
            sekai.tourDuJeu(player1);
            sekai.tourDuJeu(player2);
            System.out.println("Continuer à jouer ? (y/n)");
            veutjouer = sc2.nextLine();
        }
        
        
    }

}
