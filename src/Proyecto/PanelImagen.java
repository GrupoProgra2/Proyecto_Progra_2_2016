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
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
public class PanelImagen extends javax.swing.JPanel {
 private Image imagen;
    public PanelImagen(String image){
         imagen = new ImageIcon(getClass().getResource(image)).getImage();
    this.setSize(400,300);
    }
 
@Override
    public void paint(Graphics g) {
        Dimension tamanio = getSize();    
        g.drawImage(imagen, 0, 0, tamanio.width, tamanio.height,this);
        setOpaque(false);
        super.paint(g);
    }    
}