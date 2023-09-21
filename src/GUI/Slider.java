/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Alif computer
 */
public class Slider extends JPanel{
    static JSlider b;
    
    public Slider()
    {
        
        b = new JSlider(0, 400, 100);
         // paint the ticks and tracks
        b.setPaintTrack(true);
        //b.setPaintTicks(true);
        //b.setPaintLabels(true);
        setBorder(BorderFactory.createEmptyBorder(0,100,0,100));
        // set spacing
        b.setMajorTickSpacing(25);
        b.setMinorTickSpacing(5);
        setLayout(new BorderLayout());
        add(b,BorderLayout.CENTER);
        setOpaque(false);
        add(new JLabel("               "),BorderLayout.WEST);
        add(new JLabel("               "),BorderLayout.EAST);
     
        b.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                
                cvyass.CVYASS.F.mp.fp.p.height =cvyass.CVYASS.F.mp.fp.p.iy*b.getValue()/100;
                cvyass.CVYASS.F.mp.fp.p.width =cvyass.CVYASS.F.mp.fp.p.ix*b.getValue()/100;
                cvyass.CVYASS.F.mp.fp.p.repaint();
                cvyass.CVYASS.F.mp.fp.rep();
                /*
                    if (!b.getValueIsAdjusting()) {
                    
                    CV.F.fp.p.height =CV.F.fp.p.ix*b.getValue()/100;
                    CV.F.fp.p.width =CV.F.fp.p.iy*b.getValue()/100;
                    CV.F.fp.p.repaint();
                    CV.F.fp.rep();
                }
                */
            }
        });
    }
    
}
