/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 *
 * @author Justm
 */
public class Player implements Serializable{
    private String nombre;
    private String contrasena;
    public String bando;
    public int puntos, malo, bueno;
    public static int contplayers;
    private RandomAccessFile players, pls; 
    private File pl;
    static ArrayList<Player> jugadores = new ArrayList<>();
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
            if (psswd.length()==5){
            this.contrasena=pssw;
            } else {
                JOptionPane.showMessageDialog(null, "El password debe tener exactamente 5 caracteres. Intente de nuevo");
                this.setPsswd();
            }
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
           
    public boolean crearPlayer1(String name, char[] psswd) {
        String pass="";
        for (char p : psswd){
            pass=pass+p;
        }
        boolean existe=false;
        pass=pass.substring(0);
        if (pass.length()==5){
            for (Player e: jugadores) { 
                if (name.equals(e.getNombre())) {
                    existe=true;
                }
            } 
            if (!(existe)){
                    Player e=new Player(name, pass);
                    jugadores.add(e);
                    contplayers++;
                    this.pl= new File(name); 
                    pl.mkdir();
                    try {
                        pls= new RandomAccessFile("players.ply", "rw");
                        pl=new File(name+"/partidas");
                        pl.mkdir();
                        
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Player.userlogged=e;
                    return true;
                    
                    //setVisible(true);
                    //setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese nombre. Pruebe de nuevo.");
                MenuInicial.m.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El password debe tener exactamente 5 caracteres. Intente de nuevo");
            MenuInicial.m.setVisible(true);
        } return false;
    }
       
       
    
    public boolean loginPlayer(String name, char[] pssw) {
        String pass="";
        for (char p : pssw){
            pass=pass+p;
        }
        boolean found= false;
        for (Player e: jugadores) { 
                if (name.equals(e.getNombre()) && pass.equals(e.getPsswd())) {
                    Player.userlogged=e;
                    found= true;
                    break;
                }
        } 
           
        return found;
        
    } 
    
    public void getPlayer2(String name){
        for (Player e: jugadores) { 
            if (name.equals(e.getNombre())) {
              Jugar.jugador2=e; }
        }
        
    }

// maneja el login 
    
    public void setFile(){
        try {
            FileOutputStream fo= new FileOutputStream("stratego_players.mar");
            ObjectOutputStream out = new ObjectOutputStream(fo);
            out.writeObject(jugadores);
        } catch (IOException e){
           System.out.println("Error set"+ e.getMessage());   
        } 
        
    }
    
    public void getFile(){
        try {
            FileInputStream fis = new FileInputStream("stratego_players.mar"); 
            ObjectInputStream in = new ObjectInputStream(fis);
            jugadores=((ArrayList<Player>)in.readObject());               
        } catch (IOException | ClassNotFoundException e){
                  
        } 
        
    }
    
    public void eliminarCuenta()
    {
     JPanel panel = new JPanel();
        JLabel label = new JLabel("Para confirmar, ingrese su contraseña");
        JPasswordField pass = new JPasswordField(6);
        panel.add(label);
        panel.add(pass);
        String[] options = new String[]{"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panel, "Eliminar Cuenta",
                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                         null, options, options[1]);
        if(option == 0) // pressing OK button
        {
            char[] psswd = pass.getPassword();
            String passd="";
            for (char p : psswd){
                passd=passd+p;
            } int index=-1;
            passd=passd.substring(0);
            for (Player e: jugadores) { 
                if (passd.equals(e.getPsswd())) {
                    index= jugadores.indexOf(e);
                }
            } 
            if( index!=-1){
            jugadores.remove(index);
            File f= new File(Player.userlogged.getNombre());
            eliminarArchivos(f);
            }
                
            }
    }
       
    public void eliminarArchivos(File f){
        if(f.isDirectory()){
             for(File child : f.listFiles()){
                eliminarArchivos(child);
             }
        }  f.delete();
    }

}