/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author bgera
 */
public class putplayer extends JButton implements Serializable{
     
    boolean turnplayerHeroe;
    public int f,c;
    Ficha ficha;
   
    public putplayer(int f, int c, Ficha ficha) {
        this.f = f; this.c = c; this.ficha = ficha;
        this.setOpaque(true);
     
  
    }
 
}
