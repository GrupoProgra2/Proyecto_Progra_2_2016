/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto.imagenes;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
/**
 *
 * @author Justm
 */
    
public class PanelImagen extends javax.swing.JPanel {
ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/Background.jpg"));
    public PanelImagen(String image){
        imagenFondo = new ImageIcon(getClass().getResource(image));
        this.setSize(400,280);
    }
    @Override
    public void paintComponent (Graphics g){
        Dimension tamanio = getSize();

        g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }
}

