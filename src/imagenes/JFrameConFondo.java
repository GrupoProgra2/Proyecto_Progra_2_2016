/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto.imagenes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Justm
 */
public class JFrameConFondo extends JFrame {
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
@Override
public void run() {
try {
JFrameConFondo frame = new JFrameConFondo();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
public JFrameConFondo() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 450, 300);
PanelImagen p = new PanelImagen();
p.setBorder(new EmptyBorder(5, 5, 5, 5));
p.setLayout(new BorderLayout(0, 0));
setContentPane(p);
}
}
