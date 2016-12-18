/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author bgera
 */
public class Tablero extends javax.swing.JFrame  implements ActionListener {
    public Ficha[][] fichas=new Ficha[10][10]; 
   // String PLAYER_HEROE,PLAYER_VILLANO;
    int villanosmax=40;
    static putplayer celda[][]=new putplayer[10][10];
    Ficha heroes[][]=new FichaNM[4][10];
    int heroesmax=40;
    putplayer primerCasilla=null,segundaCasilla=null;
    boolean turnoPlayerHeroes=true, primerclic=false;
    FichaTipo miTipoFicha = turnoPlayerHeroes? FichaTipo.HEROE:FichaTipo.VILLANO;
    int turno=0;//MODO_JUEGO=MenuPrincipal.modojuego; 
    FichaTipo fichaContraria= turnoPlayerHeroes?FichaTipo.VILLANO:FichaTipo.HEROE;
    Ficha villanos[][]=new FichaNV[4][10];
    String turnoplayer=(turno==1?"HEROES":"VILANOS");
    

    /**
     * Creates new form Tabl
     */
    public Tablero() {
       initComponents();
         initComponents();
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        close();
        
    
        Panel.setSize(500, 700);
        Panel.setLocation(this.getHeight()/2,this.getWidth()/2+200);
        formularioInicial();
        modoJuego();
        obtenerHeroes();
        obtenerVillanos();
        tablero(); //IMPLEMENTA EL TABLERO EN PANTALLA\
        generarAchivosdeTexto();
        cambiarTurno();
    }
    public void Tabl(){
         Panel.setLayout(new GridLayout(10,10));
            for (int i=0;i<celda.length;i++ ){
                for (int e=0;e<celda[i].length;e++){
                    if (fichas[i][e] instanceof FichaNM || fichas[i][e] instanceof FichaNV){
                        celda[i][e]=new putplayer(i,e,fichas[i][e]);
                        celda[i][e].setIcon(obtenerImagen(fichas[i][e]));
                    }else{
                        celda[i][e]=new putplayer(i, e,null);
                    }
                    celda[i][e].setName(i+""+e);
                    celda[i][e].addActionListener(this);
                    Panel.add(celda[i][e]);
                }
            }   
        

    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }
 private void close() {
      try{
           this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
              public void windowClosing(WindowEvent e)  {
                 Exitmesage(); 
            }});
            this.setVisible(true);
        }catch(Exception e){
            System.out.println("culpa de esther");
        }
    }
    public void Exitmesage(){
        int valor=JOptionPane.showConfirmDialog(this, "¿Está seguro de cerrar el juego?", "Se perderán los cambios no guardados", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (valor==JOptionPane.YES_OPTION){
            this.dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void formularioInicial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void modoJuego() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void obtenerHeroes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void obtenerVillanos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void tablero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void generarAchivosdeTexto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void pintarZonaSegura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cambiarTurno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    // End of variables declaration//GEN-END:variables

    private Icon obtenerImagen(Ficha ficha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}