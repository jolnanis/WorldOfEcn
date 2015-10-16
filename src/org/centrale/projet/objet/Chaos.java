/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author nico
 */
public class Chaos {
    
    public static void main (String[] args){
        ElementDuJeu.map = new ElementDuJeu[50][50];
        World sekai = new World();
        //NullPointerException
        (ElementDuJeu.map[1][2]).pos.affiche();
        //ArrayIndexOutOfBoudsException
        System.out.println(ElementDuJeu.map[-1][-1]);
        //ArithmeticException
        int i = 0;
        i = i /i;
        //ClassCastException
        Guerrier georges = new Guerrier();
        georges.deplace(new Point2D(10,5));
        georges.placeDansMap();
        ((Lapin)ElementDuJeu.map[10][5]).deplace();
        //NumberFormatException
        int a = Integer.parseInt("Pas un nombre");
        //StackOverflowError
        Chaos.main(args);
        
    }
    
}
