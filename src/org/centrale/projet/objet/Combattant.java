/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Interface commune à toutes les créatures qui doivent pouvoir combattre
 * @author nico
 */
public interface Combattant {

    /**
     * La créature qui appelle la méthode attaque la créature en argument.
     * @param c
     */
    public abstract void combattre(Creature c);
}
