/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import static Proyecto.Player.jugadores;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Justm
 */
public class Marvel {
    public static int cuantosMalos=0, cuantosBuenos=0, userA=0, userH=0, partidas=0;
    public String message="";
    
    public Marvel(){
        this.ranking();
      this.batallas();
    }
    
    public void addpart(){
       partidas++;
    }
    
    public final void ranking(){
        ArrayList<Player> jugadore= Player.jugadores;
        for(int i=0;i<jugadore.size()-1;i++){
            for(int j=0;j<jugadore.size()-1;j++){
                if(jugadore.get(j)!=null && jugadore.get(j+1)!=null){
                if(jugadore.get(j).getPuntos() < jugadore.get(j+1).getPuntos()){
                    Player tmp=jugadore.get(j+1);
                    jugadore.set(j+1,jugadore.get(j));
                    jugadore.set(j, tmp);
                }
            
                }
            }
        }
        int ark=1;
        for (Player jugador : jugadore) {
            if (jugador != null) {
                message= message+(ark+". " + jugador.getNombre() + " Score: " + jugador.getPuntos())+"\n";
                ark++;
            }
        }
    }
    
    public void addBuenos(){
        Marvel.cuantosBuenos++;
    }
    public void addMalos(){
        Marvel.cuantosMalos++;
    }
    
    public void batallas(){
        Player p= new Player();
        ArrayList<Player> pl;
        try {
            FileInputStream fis = new FileInputStream("stratego_players.mar"); 
            ObjectInputStream in = new ObjectInputStream(fis);
            pl=((ArrayList<Player>)in.readObject());     
            userA=pl.size();
        } catch (IOException | ClassNotFoundException e){
        } 
        userH=Player.contplayers;
        
       
        
        
        
        
        
    }
    
}
