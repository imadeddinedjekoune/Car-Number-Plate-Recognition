package cvyass.Frames.UI;

import GUI.MultiPanel;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import static cvyass.CVYASS.c4;
import cvyass.Frames.UI.FrameDragListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Alif computer
 */
public class PrincipaleFrame extends JFrame {
    public static int width = 1000;
    public static int height = 600;
    public MultiPanel mp ;
    
    
    public PrincipaleFrame()
    {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
            UIManager.put( "Button.arc", 999 );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        mp = new MultiPanel();
        
        setTitle("TP SIFT");
        setSize(width,height);
        setUndecorated(true);
        setBackground(c4);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-width)/2, (Toolkit.getDefaultToolkit().getScreenSize().height-height)/2-10);
        setResizable(true);
        
        
        setLayout(new BorderLayout());
        add(new ControlPanel(this),BorderLayout.NORTH);
        add(new PanelBorder(8),BorderLayout.SOUTH);
        add(new PanelBorder(11),BorderLayout.EAST);
        add(new PanelBorder(11),BorderLayout.WEST);
        add(new MainPanel(mp),BorderLayout.CENTER);
        
        FrameDragListener frameDragListener = new FrameDragListener(this);
        addMouseListener(frameDragListener);
        addMouseMotionListener(frameDragListener);
        
        //pack();
        setLocationRelativeTo(null);
    }
    
    
    public void ChangeSize(int w , int h)
    {
        Point oldSize = new Point(getSize().width, getSize().height);
        setSize(w,h);
        setShape(new RoundRectangle2D.Double(0, 0, this.getWidth(),this.getHeight(), 30, 30));
    }
    
  
    
    
}
