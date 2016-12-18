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
public class FichaNM  extends Ficha{
    public FichaNM arrayheroes[][]= new FichaNM[4][10];
    String nombre;
    
    
    protected FichaTipo tipo;
    
    public FichaNM(int rango,String nomb,int jugador ) {
        super(rango,FichaTipo.HEROE,nomb,jugador);
        
    }

    @Override
    public void moverFicha() {
        JOptionPane.showMessageDialog(null, "Esta pieza no se puede mover");
    }

    @Override
    public void comerFicha() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean mepuedoMover() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
