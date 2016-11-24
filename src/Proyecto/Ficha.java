/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

/**
 *
 * @author Justm
 */
public class Ficha {
    private int rango;
    private boolean bando;
    private int jugador;

    public Ficha(int rango, boolean bando, int jugador) {
        this.rango = rango;
        this.bando = bando;
        this.jugador = jugador;
    }
    
    public int getRango() {
        return rango;
    }

    public boolean isBando() {
        return bando;
    }

    public int getJugador() {
        return jugador;
    }
   
    public void moverFicha(){
        
    }
    
    public void comerFicha(){
        
    }
    
}
