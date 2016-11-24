/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;
import javax.swing.*;
/**
 *
 * @author Justm
 */
public class Home {
    
    public static void main(String[] args) {
        JFrame menuI= new JFrame("ESTRATEGO MARVEL");
        menuI.setSize(500, 500);
        menuI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        JPanel panel = new JPanel();
		menuI.add(panel);
		placeComponents(panel);
         
                menuI.setVisible(true);
    }
    
    private static void placeComponents(JPanel panel) {

		panel.setLayout(null);

		JButton loginButton = new JButton("LOGIN");
		loginButton.setBounds(30, 300, 100, 50);
		panel.add(loginButton);
		
		JButton registerButton = new JButton("REGISTER");
                loginButton.setLocation(500, 500);
		registerButton.setBounds(180, 80, 80, 25);
		panel.add(registerButton);
	}

}
