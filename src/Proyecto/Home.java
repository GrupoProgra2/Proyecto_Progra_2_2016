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
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter a password:");
        JPasswordField pass = new JPasswordField(10);
        panel.add(label);
        panel.add(pass);
        String[] options = new String[]{"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, panel, "The title",
                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                         null, options, options[1]);
        if(option == 0) // pressing OK button
        {
            char[] password = pass.getPassword();
        }
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
