/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Alif computer
 */
public class FramePanel extends JPanel{
    public ImagePainter p ;
    public Slider s ;
    public CoordPanel cp ;
    
    public FramePanel()
    {
        setOpaque(false);
        p = new ImagePainter("./sift.png");
        s = new Slider();
        cp = new CoordPanel();
        setLayout(new BorderLayout());
        JScrollPane jsp = new JScrollPane(p);
        jsp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jsp.setOpaque(false);
        add(jsp,BorderLayout.CENTER);
        
        add(s,BorderLayout.SOUTH);
        add(cp,BorderLayout.NORTH);
        
    }
    public void rep()
    {
        removeAll();
        JScrollPane jsp = new JScrollPane(p);
        jsp.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jsp.setOpaque(false);
        add(jsp,BorderLayout.CENTER);
        
        
        add(s,BorderLayout.SOUTH);
        add(cp,BorderLayout.NORTH);
        
        revalidate();
        repaint();
    }
}
