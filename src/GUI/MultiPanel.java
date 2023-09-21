/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Alif computer
 */
public class MultiPanel extends JPanel {
    
    public FramePanel fp ;
    public FinalRenderer fd ;
    
    public MultiPanel()
    {
        setOpaque(false);
        fp = new FramePanel();
        fd = new FinalRenderer();
        
        setLayout(new BorderLayout());
        add(fp,BorderLayout.CENTER);

        
    }
    
    public void rep(int cpt)
    {
        
        if (cpt == 1)
        {
            removeAll();
            add(fd,BorderLayout.CENTER);
            revalidate();
            repaint();
        }else
        {
            removeAll();
            add(fp,BorderLayout.CENTER);
            revalidate();
            repaint();
        }

    }
    
}
