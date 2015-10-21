/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author nico
 */
public class Soin extends Potion {
    int pV;

    /**
     *
     */
    public Soin() {
        super();
        pV=15;
    }
    
    public int getPV() {
        return pV;
    }
    
    public void setPV(int pV) {
        this.pV = pV;
}
}
