/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvyass.Frames.UI;

import GUI.MultiPanel;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

/**
 *
 * @author Alif computer
 */
public class ParFrame extends JFrame {
    public static int width = 300;
    public static int height = 225;
    ParPanel pr = new ParPanel();
    
    public ParFrame()
    {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
            UIManager.put( "Button.arc", 999 );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        
        setTitle("TP SIFT");
        setSize(width,height);
        
	setVisible(true);
	setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-width)/2, (Toolkit.getDefaultToolkit().getScreenSize().height-height)/2-10);
        setResizable(true);
        
        
        setLayout(new BorderLayout());
        add(pr,BorderLayout.CENTER);
    }
    
    
    
}
