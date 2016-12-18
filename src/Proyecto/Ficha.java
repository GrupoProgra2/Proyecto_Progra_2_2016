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
public abstract class Ficha {
    private int rango;
    private boolean bando;
    int jugador;
    private String nom;
    private FichaTipo tipo;

    public Ficha(int rango,FichaTipo tipo,String nombre, int jugador) {
        this.rango = rango;
        this.bando = bando;
        this.nom = nombre;
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
    public abstract boolean mepuedoMover();
    
    public abstract void moverFicha();
    
    public abstract void comerFicha();
    
}
