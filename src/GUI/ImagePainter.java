/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import static cvyass.CVYASS.c4;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author Alif computer
 */
public class ImagePainter extends JPanel  implements MouseMotionListener
{
    BufferedImage image = null;
    
    JLabel subImage ;
    int width, height;
    public String path = "";
    public int ix , iy ;
    Point p = new Point(-1, -1);
    public ArrayList<Point> clicked = new ArrayList<>();
    public ArrayList<Point> clicked2 = new ArrayList<>();
    
    public ImagePainter(String path)
    {
        setBorder(BorderFactory.createLineBorder(c4, 10));
        setOpaque(false);
        this.path = path ;
        try {                
            this.image = ImageIO.read(new File(path));
        } catch (IOException ex) {
        }
        
        subImage = new JLabel();
        subImage.setBounds(0,0,200,100);
        subImage.setVisible(false);
        
        this.width = image.getWidth();
        this.ix = image.getWidth();
        this.height = image.getHeight() ;
        this.iy = image.getHeight();
        this.addMouseMotionListener(this);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Point rn = new Point(p.x,p.y);
                if (!clicked.contains(rn) && clicked.size() < 4)
                {
                    clicked.add(rn);
                     Graphics2D g2d = image.createGraphics();
                    g2d.setRenderingHint (RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2d.setPaint(Color.green);
                    int coord [] = test(rn.x,rn.y);
                    clicked2.add(new Point(coord[0], coord[1]));
                    g2d.drawRect(coord[0]-5, coord[1]-5, 10, 10);
                    g2d.setPaint(Color.red);
                    g2d.drawRect(coord[0], coord[1], 1, 1);
                    
                    
                    if(clicked.size() == 1)
                    {
                        cvyass.CVYASS.F.mp.fp.cp.l1.setText("p1 : ("+coord[0]+","+coord[1]+")");
                    }
                    if(clicked.size() == 2)
                    {
                        cvyass.CVYASS.F.mp.fp.cp.l2.setText("p2 : ("+coord[0]+","+coord[1]+")");
                        g2d.drawLine(clicked2.get(0).x,clicked2.get(0).y,coord[0],coord[1]);
                        
                    }
                    if(clicked.size() == 3)
                    {
                        cvyass.CVYASS.F.mp.fp.cp.l3.setText("p3 : ("+coord[0]+","+coord[1]+")");
                        g2d.drawLine(clicked2.get(1).x,clicked2.get(1).y,coord[0],coord[1]);
                    }
                    if(clicked.size() == 4)
                    {
                        cvyass.CVYASS.F.mp.fp.cp.l4.setText("p4 : ("+coord[0]+","+coord[1]+")");
                        g2d.drawLine(clicked2.get(2).x,clicked2.get(2).y,coord[0],coord[1]);
                        g2d.drawLine(clicked2.get(0).x,clicked2.get(0).y,coord[0],coord[1]);
                        
                    }
                    g2d.dispose();
                    repaint();
                }else
                {
                    Point c1 = cvyass.CVYASS.F.mp.fp.p.clicked2.get(0);
                    Point c2 = cvyass.CVYASS.F.mp.fp.p.clicked2.get(1);
                    Point c3 = cvyass.CVYASS.F.mp.fp.p.clicked2.get(2);
                    Point c4 = cvyass.CVYASS.F.mp.fp.p.clicked2.get(3);

                    String val = " "+c1.x+" "+c1.y;
                    val += " "+c2.x+" "+c2.y;
                    val += " "+c3.x+" "+c3.y;
                    val += " "+c4.x+" "+c4.y;

                    int w = 0 ;
                    if (Math.abs((c1.x-c2.x)) > Math.abs((c3.x-c4.x))){
                        w = Math.abs((c1.x-c2.x));
                    }else{
                        w = Math.abs((c3.x-c4.x));
                    }

                    int h = 0 ;
                    if (Math.abs((c3.y-c1.y)) > Math.abs((c4.y-c2.y))){
                        h = Math.abs((c3.y-c1.y));
                    }else{
                        h = Math.abs((c4.y-c2.y));
                    }

                    if(cvyass.CVYASS.homographie)
                    {
                        Utils.WrapPerspective("\""+cvyass.CVYASS.pim+"\""+val+" "+h+" "+w);
                    }else
                    {
                        System.out.println("crop ");
                        Utils.CropAsSelected("\""+cvyass.CVYASS.pim+"\""+val);
                    }
                    
                    cvyass.CVYASS.F.mp.fp.p.repaint();
                    cvyass.CVYASS.F.mp.fp.p.subImage.setVisible(true);
                    cvyass.CVYASS.F.mp.fp.p.subImage.setIcon(new ImageIcon(new ImageIcon("out.png").getImage().getScaledInstance(cvyass.CVYASS.F.mp.fp.p.subImage.getWidth(),cvyass.CVYASS.F.mp.fp.p.subImage.getHeight(), Image.SCALE_DEFAULT)));
                    cvyass.CVYASS.F.mp.fp.p.subImage.setBorder(new LineBorder(Color.black,2));
                }
                
               
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
        
        
        setLayout(null);
        add(subImage);
        
        
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g;
        int x = (this.getWidth() - width) / 2;
        int y = (this.getHeight() - height) / 2;
        g2d.drawImage(image, x, y, width,height,null);
        g2d.setColor(Color.red);
        g2d.fillOval(p.x-6/2, p.y-6/2, 6, 6);

        
    }

    
    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        p.setLocation(e.getPoint().x, e.getPoint().y);
        test(p.x,p.y);
        this.repaint();
    }

    
    public int[] test(int x,int y)
    {
        int xprime = (int)((float)x/(float)this.getWidth()*image.getWidth());
        int yprime = (int)((float)y/(float)this.getHeight()*image.getHeight()); 
        /*
        int dx = (this.getWidth() - width)/2;
        dx = (int)((float)dx/(float)this.getWidth()*image.getWidth()); 
        System.out.println("xprime : "+xprime);
        System.out.println("yprime : "+yprime);
        System.out.println("dx : "+dx);
        
        System.out.println("dx : "+(this.getWidth()- width)/2);
        System.out.println("dy : "+(this.getHeight()- height)/2);
        System.out.println("");
        
*/
        int dx = (this.getWidth()- width)/2;
        int dy = (this.getHeight()- height)/2;
        
        if (dx != 0 )
        {
            xprime = (int) ((x-dx));
            float sc = (float)image.getWidth()/(float)cvyass.CVYASS.F.mp.fp.p.width;
            xprime = (int)(xprime*sc);
        }
        if (dy != 0 )
        {
            yprime = (int) ((y-dy));
            float sc = (float)image.getHeight()/(float)cvyass.CVYASS.F.mp.fp.p.height;
            yprime = (int)(yprime*sc);
        }
        
        
        int[] newCord = {xprime,yprime};
        return  newCord;
    }

}
