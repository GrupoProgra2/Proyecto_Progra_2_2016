/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import javax.swing.JButton;

/**
 *
 * @author Justm
 */
public class Jugar {
    static Player jugador2;
    static Player jugador1=Player.userlogged;
    static int villanos=2;
    static int heroes=1;
    protected static Ficha[][] casillas= new Ficha[10][10];      
    private boolean bando= heroes==1;
    static int turno=heroes;

    public Jugar() {
        this.putPlayer1();
        this.putPlayer2();
    }
    
    public void putPlayer1(){
         for(int fil = 0 ;fil < 4 ;fil++){
                    for( int col = 0 ; col < 10 ; col ++ ){
                       casillas[fil][col]= new FichaNV(1, bando, 1 );
                    }
         }
    }
    public void putPlayer2(){
        for(int fil = 6 ;fil < 10 ;fil++){
                    for( int col = 0 ; col < 10 ; col ++ ){
                         casillas[fil][col]= new FichaNV(1, !(bando), 2 );
                    }}
    }
    public static void verPlayer(){
        if (casillas[Tablero.ax][Tablero.ay].getJugador()==turno){
            mover();       
        }
    }
    
    public static void mover(){
        if (verificaJugador(Tablero.dx, Tablero.dy, turno)){
            casillas[Tablero.dx][Tablero.dy]=casillas[Tablero.ax][Tablero.ay];
            casillas[Tablero.ax][Tablero.ay]= new FichaNV();
        } else{
            Ficha f;
            f=casillas[Tablero.dx][Tablero.dy];
            casillas[Tablero.dx][Tablero.dy]=casillas[Tablero.ax][Tablero.ay];
            casillas[Tablero.ax][Tablero.ay]=f;
        }
    }
    public static boolean verificaJugador(int r, int c, int pl){
        boolean esFicha= false;
        if (casillas[r][c].getJugador()!=0 && (casillas[r][c].getJugador()!=turno)) {
            esFicha=true;
        }
        return esFicha;
    } 
}
