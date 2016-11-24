/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author Justm
 */
public class Player {
    private String nombre;
    private String contrasena;
    public int puntos, malo, bueno;
    private int contplayers;
    static Player jugadores[] = new Player[10];
    static Player userlogged;
    
    public Player()
    {
    this.nombre="";
    this.contrasena="";
    this.puntos=0;
    }
    
    public Player(String nombre, String pswd) {
        this.nombre = nombre;
        this.contrasena = pswd;
        puntos=0;
        malo=0;
        bueno=0;
    }
    public void setNombre(String nomb){        
        this.nombre=nomb;
    }
    public void setPsswd(){
        String psswd= JOptionPane.showInputDialog(null, "Ingrese su contraseña actual");
        if (Player.userlogged.getPsswd().equals(psswd)){
            String pssw= JOptionPane.showInputDialog(null, "Ingrese su contraseña nueva");
            this.contrasena=pssw;
        }
    }
    public void setPuntos(int points){        
        this.puntos+=points;
    }

    public int getMalo() {
        return malo;
    }

    public void setMalo(int malo) {
        this.malo = malo;
    }

    public int getBueno() {
        return bueno;
    }

    public void setBueno(int bueno) {
        this.bueno = bueno;
    }
        
    public int getPuntos(){        
        return this.puntos;
    }    
    public String getNombre() {
        return this.nombre;
    }

    public String getPsswd() {
        return this.contrasena;
    }
       
    public void crearPlayer() {
        String name= JOptionPane.showInputDialog(null, "Ingrese su nombre");
        String psswd= JOptionPane.showInputDialog(null, "Ingrese su contraseña");
        if (psswd.length()<6){
        boolean existe=false;
        for (int i = 0; i < contplayers; i++) { 
            if (name.equals(jugadores[i].getNombre())) {
                existe=true;
            }
        }
        if (!(existe)){
        if (contplayers <10) {
            jugadores[contplayers]= new Player(name, psswd);
            contplayers++;
        } 
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese nombre. Pruebe de nuevo.");
            this.crearPlayer();
        }
        } else {
            JOptionPane.showMessageDialog(null, "El password es muy largo. Intente de nuevo");
            this.crearPlayer();
        } 
    }
    public boolean loginPlayer() {
        String name= JOptionPane.showInputDialog(null, "Ingrese su nombre");
        String pssw= JOptionPane.showInputDialog(null, "Ingrese su contraseña");
        boolean found= false;
        for (int i = 0; i < contplayers; i++) {
            if (name.equals(jugadores[i].getNombre()) && pssw.equals(jugadores[i].getPsswd())) {
               Player.userlogged=jugadores[i];
                found= true;
                break;
            } 
        }
        return found;
        
    } // maneja el login 
}