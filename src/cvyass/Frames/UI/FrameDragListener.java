/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvyass.Frames.UI;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author Alif computer
 */
public class FrameDragListener extends MouseAdapter {

    private final PrincipaleFrame frame;
    private Point mouseDownCompCoords = null;
    private int borederSelected = 0 ;
    private Point savedLen , savedCursor ;

    public FrameDragListener(PrincipaleFrame frame) {
        this.frame = frame;
    }

    public void mouseReleased(MouseEvent e) {
        mouseDownCompCoords = null;
        borederSelected = 0;
    }

    public void mousePressed(MouseEvent e) {
        mouseDownCompCoords = e.getPoint();
        borederSelected = isCursorInBorders(e.getPoint());
        
        savedCursor = new Point(e.getLocationOnScreen());
        savedLen = new Point(frame.getWidth(),frame.getHeight());
        Point currCoords = e.getLocationOnScreen();
    }

    public void mouseDragged(MouseEvent e) {
        Point currCoords = e.getLocationOnScreen();
        
        if (borederSelected != 0 )
        {
            if (borederSelected == 1)
            {
                int dx = savedCursor.x-currCoords.x;
                int newWidth = savedLen.x+dx;
                
                frame.setLocation(currCoords.x - mouseDownCompCoords.x, frame.getLocation().y);
                frame.ChangeSize(newWidth,frame.getHeight());
                
            }
            if (borederSelected == 2)
            {
                int dx = savedCursor.x-currCoords.x;
                int newWidth = savedLen.x-dx;
                
                frame.ChangeSize(newWidth,frame.getHeight());
            }
            
            if (borederSelected == 3)
            {
                int dy = savedCursor.y-currCoords.y;
                int newHeight = savedLen.y+dy;
                
                frame.ChangeSize(frame.getWidth(),newHeight);
                frame.setLocation(frame.getLocation().x, currCoords.y - mouseDownCompCoords.y);
            }
            
            if (borederSelected == 4)
            {
                int dy = savedCursor.y-currCoords.y;
                int newHeight = savedLen.y-dy;
                frame.ChangeSize(frame.getWidth(),newHeight);
            }
            
        }else
        {
            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
        }
        
    }
    
    public int isCursorInBorders(Point p)
    {
        if (p.x<5)
        {
            return 1 ;
        }
        
        if (p.x>frame.getWidth() - 7)
        {
            return 2 ;
        }
        
        if (p.y<5)
        {
            return 3 ;
        }
        
        if (p.y>frame.getHeight()- 7)
        {
            return 4 ;
        }
        
        return 0;
    }
    
}