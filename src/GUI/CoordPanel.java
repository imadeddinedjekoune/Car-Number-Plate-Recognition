/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import static cvyass.CVYASS.c0;
import static cvyass.CVYASS.c2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Alif computer
 */
public class CoordPanel extends JPanel {
    public JLabel l1 ;
    public JLabel l2 ;
    public JLabel l3 ;
    public JLabel l4 ;
    public JButton b;
    public JButton clear;
    public JButton save;
    public JButton search;
    
    
    
    public CoordPanel()
    {
        setOpaque(false);
        l1 = new JLabel("p1 : ");
        l2 = new JLabel("p2 : ");
        l3 = new JLabel("p3 : ");
        l4 = new JLabel("p4 : ");
        
        b =new JButton("Done");
        clear=new JButton("Clear");
        save = new JButton("Save");
        search = new JButton("Search");
                
        setLayout(new GridLayout(1, 7));
        
        clear.setOpaque(false);
        clear.setPreferredSize(new Dimension(90,30));
        clear.setBackground(c0);
        
        save.setOpaque(false);
        save.setBackground(c0);
        
        search.setOpaque(false);
        search.setBackground(c0);
        
        
        add(new JLabel());
        add(clear);
        add(new JLabel());
        add(save);
        add(new JLabel());
        add(search);
        add(new JLabel());
        
        
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {                
                    cvyass.CVYASS.F.mp.fp.p.image = ImageIO.read(new File(cvyass.CVYASS.F.mp.fp.p.path));
                } catch (IOException ex) {
                    // handle exception...
                }
                cvyass.CVYASS.F.mp.fp.p.clicked = new ArrayList<>();
                cvyass.CVYASS.F.mp.fp.p.clicked2 = new ArrayList<>();
                cvyass.CVYASS.F.mp.fp.p.subImage.setVisible(false);
            }
           
        });
        
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                        int nb = new File(System.getProperty("user.dir")+"/Matricules").list().length;
                        Utils.copyFileUsingStream(new File("./out.png"), new File(System.getProperty("user.dir")+"/Matricules/matricule"+(nb+1)+".png"));
                        cvyass.CVYASS.F.mp.fp.p = new ImagePainter("./sift.png");
                        cvyass.CVYASS.F.mp.fp.rep();
                        cvyass.CVYASS.pim = "./sift.png";
                    } catch (IOException ex) {
                        Logger.getLogger(ImagePainter.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        });
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res = Utils.Sift1(cvyass.CVYASS.d1,cvyass.CVYASS.d2,cvyass.CVYASS.seuil);
                   if (!res.equals("True")){
                       JOptionPane.showMessageDialog(null, "Matricule Inexistant");
                   }
            }
        });
        
        mlist();
        
    }
    
    public void rep(){
        removeAll();
        add(new JLabel());
        add(clear);
        add(new JLabel());
        add(save);
        add(new JLabel());
        add(search);
        add(new JLabel());
        revalidate();
        repaint();
    }

    private void mlist() 
    {
        save.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
                save.setBackground(c2);
                rep();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                save.setBackground(c0);
                
            }
        });
        
        clear.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
                clear.setBackground(c2);
                rep();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                clear.setBackground(c0);
                
            }
        });
        
        search.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
                search.setBackground(c2);
                rep();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                search.setBackground(c0);
                
            }
        });
        
    }
    
}
