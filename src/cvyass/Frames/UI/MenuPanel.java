/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvyass.Frames.UI;

import GUI.ImagePainter;
import static cvyass.CVYASS.c0;
import static cvyass.CVYASS.c2;
import static cvyass.CVYASS.c3;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Alif computer
 */
public class MenuPanel extends JPanel{
    JButton Menu ;
    JButton OpenImage ;
    JButton Parametres ;
    
    Timer timer , timer2;
    Thread t1 , t2 ;
    int moving = 0;
    int animate = 0 ;
    public MenuPanel()
    {
        setPreferredSize(new Dimension(200,200));
        setOpaque(false);
        setBorder( new MatteBorder(0, 0, 0, 1, c3));
        Menu = new JButton("Menu");
        OpenImage = new JButton("Ovrire Image");
        Parametres = new JButton("Parametres");
        
        Parametres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action2();
            }
        });
        
        /*
        Menu.setBounds(0,10,130,50);
        
        Menu.setFont(new Font("Verdana", Font.ITALIC, 28));
        Menu.setForeground(Color.white);
        Menu.setBorder(new RoundedBorder(new Color(0, 0, 50, 70), 50));
        */
        Menu.setFont(new Font("Verdana", Font.ITALIC, 18));
        Menu.setBounds(10,10,100,30);
        Menu.setOpaque(false);
        Menu.setBackground(c0);
        
        
        OpenImage.setFont(new Font("Verdana", Font.ITALIC, 15));
        OpenImage.setBounds(10,20,150,30);
        OpenImage.setOpaque(false);
        OpenImage.setBackground(c0);
        OpenImage.setVisible(false);
        
        Parametres.setFont(new Font("Verdana", Font.ITALIC, 15));
        Parametres.setBounds(10,20,150,30);
        Parametres.setOpaque(false);
        Parametres.setBackground(c0);
        Parametres.setVisible(false);
        
        setLayout(null);
        
        listn();
        add();
        
    }
    
    public void rep(){
        removeAll();
        add();
        revalidate();
        repaint();
    }
    
    
    void add()
    {
        add(Menu);
        add(OpenImage);
        add(Parametres);
        /*
        
        timer2 = new Timer(5, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(animate == 0 )
                        {
                            
                        }else
                        {
                            
                            Parametres.setBounds(10,33+animate,150,30);
                            animate += 10 ;
                            if(animate > 90)
                            {
                                animate = -1;
                                timer2.stop();
                            }

                        }
                    }
                });
        */
    }

    private void listn() {
        
        Menu.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Thread t = new Thread() {
                    public void run() {
                        if (moving == 0)
                        {
                            moving = 1;
                            OpenImage.setVisible(true);
                            int min = 200 , max = 260 ;
                            
                            for (int i = min ; i < max ; i++ )
                            {
                                int y = (int)(((Math.log(i)-Math.log(min))/(Math.log(max)-Math.log(min)))*60);
                                OpenImage.setBounds(10,20+y,150,30);
                                try {
                                    sleep(1);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            min = 200 ;
                            max = 280 ;
                            Parametres.setVisible(true);
                            for (int i = min ; i < max ; i++ )
                            {
                                int y = (int)(((Math.log(i)-Math.log(min))/(Math.log(max)-Math.log(min)))*100);
                                Parametres.setBounds(10,20+y,150,30);
                                try {
                                    sleep(1);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            
                            moving = -1;
                        }else
                        {
                            if(moving == -1)
                            {
                                int old = OpenImage.getLocation().y;
                                moving = 1 ;
                                int min = 200 , max = 260 ;
                                for (int i = min ; i < max ; i++ )
                                {
                                    int y = (int)(((Math.log(i)-Math.log(min))/(Math.log(max)-Math.log(min)))*60);
                                    OpenImage.setBounds(10,old-y,150,30);
                                    try {
                                        sleep(1);
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                OpenImage.setVisible(false);
                                
                                min = 200 ;
                                max = 280 ;
                                old = Parametres.getLocation().y;
                                
                                for (int i = min ; i < max ; i++ )
                                {
                                    int y = (int)(((Math.log(i)-Math.log(min))/(Math.log(max)-Math.log(min)))*100);
                                    Parametres.setBounds(10,old-y,150,30);
                                    try {
                                        sleep(1);
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(MenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                Parametres.setVisible(false);

                                moving = 0;
                            }
                        }
                        
                        
                    }
                };
                t.start();
                /*
                OpenImage.setVisible(true);
                
                timer = new Timer(5, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(animate >= 0)
                        {
                            OpenImage.setBounds(10,20+animate,150,30);
                            animate += 10 ;
                            if(animate > 60)
                            {
                                timer.stop();
                                animate = -1;
                                timer2.start();
                                Parametres.setVisible(true);
                            }
                        }else
                        {
                            OpenImage.setBounds(10,20+33+animate,150,30);
                            animate -= 10;
                            if(animate < -40)
                            {
                                timer.stop();
                                animate = 0;
                                OpenImage.setVisible(false);
                                Parametres.setVisible(false);
                                Parametres.setBounds(10,20,150,30);
                            }
                        }
                    }
                });
                timer.start();
                
                */
                
            }

            
            
            
            
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
                Menu.setBackground(c2);
                rep();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Menu.setBackground(c0);
                
            }
        });
        
        
        OpenImage.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                action1();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
                OpenImage.setBackground(c2);
                rep();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                OpenImage.setBackground(c0);
                
            }

        });
        
        
        
        Parametres.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("yes");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
                Parametres.setBackground(c2);
                rep();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Parametres.setBackground(c0);
                
            }
        });
    }
    
    public void action1() 
    {
        cvyass.CVYASS.F.mp.rep(0);
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")+"\\Documents\\NetBeansProjects\\CV"));
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    cvyass.CVYASS.F.mp.fp.p = new ImagePainter(selectedFile.getAbsolutePath());
                    cvyass.CVYASS.F.mp.fp.rep();
                    System.out.println("open "+selectedFile.getAbsolutePath());
                    cvyass.CVYASS.pim = selectedFile.getAbsolutePath();
                }
    }
    
    public void action2() 
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ParFrame();
            }
        });
    }
}
