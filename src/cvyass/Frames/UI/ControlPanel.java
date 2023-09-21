/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvyass.Frames.UI;

import static cvyass.CVYASS.c1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alif computer
 */
public class ControlPanel extends JPanel {
    public PanelBorder pb ;
    JLabel close ;
    public ControlPanel(JFrame pf)
    {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File("./res/cl.png"));
        } catch (Exception e) {
        }
        ImageIcon imageIcon = new ImageIcon(bufferedImage.getScaledInstance(22, 22,
        Image.SCALE_SMOOTH));
        close = new JLabel("     ");
        close.setIcon(imageIcon);
        
        close.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                pf.dispatchEvent(new WindowEvent(pf, WindowEvent.WINDOW_CLOSING));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        setBackground(c1);
        pb = new PanelBorder(8);
        setPreferredSize(new Dimension(5, 32));
        setLayout(new BorderLayout());
        add(pb,BorderLayout.NORTH);
        add(close,BorderLayout.EAST);
        
    }
    

  


}
