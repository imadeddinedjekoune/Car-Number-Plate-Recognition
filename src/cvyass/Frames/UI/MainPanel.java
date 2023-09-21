/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvyass.Frames.UI;

import GUI.MultiPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Alif computer
 */
public class MainPanel extends JPanel {
    
    MenuPanel mp ;
    
    public MainPanel(MultiPanel mmp)
    {
        //setBackground(Color.red);
        setOpaque(false);
        mp = new MenuPanel();
        setLayout(new BorderLayout());
        add(mp,BorderLayout.WEST);
        add(mmp,BorderLayout.CENTER);

        
    }
    
    
}
