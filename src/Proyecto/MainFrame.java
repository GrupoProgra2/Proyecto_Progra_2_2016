/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author Justm
 */
public class MainFrame extends JFrame {
    
    public static Tablero tab = new Tablero();
    
    ImageIcon tabback;
    JLabel jbackimage;
    Image marvel;
    

    public MainFrame() {
        try {
            jbInit();
        } catch (Exception e) {
            System.out.println("Error solamente de Esther: " + e.getMessage());
        }
    }
    

    private void jbInit() throws Exception {

        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(700, 600));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.add(tab, BorderLayout.CENTER);

        
        

    }
    
}
