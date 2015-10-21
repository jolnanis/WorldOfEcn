/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

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
        Scanner sc2 =  new Scanner(System.in);
        ElementDuJeu.map = new ElementDuJeu[50][50];
        World sekai = new World();
        System.out.println("Bienvenue dans ce jeu à 2 joueurs :");
        System.out.println("Voulez-vous charger une partie ? (y/n)");
        if(sc2.nextLine().equals("y")){
            System.out.print("Nom du fichier de sauvegarde : ");
            
            ChargementPartie file = new ChargementPartie(sc2.nextLine());
            sekai = file.ChargerPartie();
        }
        else{
        sekai.joueur1.bienvenue();
        sekai.joueur2.bienvenue();
        System.out.println("Position intiale du joueur 1");
        sekai.joueur1.p.pos.affiche();
        System.out.println("Position intiale du joueur 2");
        sekai.joueur2.p.pos.affiche();
        //sekai.creatures = new LinkedList<Creature>();
        //sekai.creatures.add(new Guerrier(10, 100, 50, 60, 30, 60, 1, new Point2D(0,1),"YOLO"));
        sekai.creeMondeAlea();
        }
        String veutjouer = "y";
        while (!(veutjouer.equals("y")) && !(veutjouer.equals("n"))){
            System.out.println("Rentrez une réponse valide ! y pour jouer, n pour ne pas jouer");
            veutjouer = sc2.nextLine();
        }
        while (veutjouer.equals("y")){
            sekai.tourDuJeu(sekai.joueur1);
            sekai.tourDuJeu(sekai.joueur2);
            System.out.println("Continuer à jouer ? (y/n)");
            veutjouer = sc2.nextLine();
        }
        System.out.println("Sauvegarder la partie ? (y/n)");
        if (sc2.nextLine().equals("y")){
            
            System.out.println("Nom du fichier à écrire : : ");
            SauvegardePartie fichier = new SauvegardePartie(sc2.nextLine()+".save");
            fichier.SauvegarderPartie(sekai);
        }
        
        
    }

}
