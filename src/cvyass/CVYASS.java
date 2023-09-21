/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cvyass;

import GUI.Utils;
import cvyass.Frames.UI.PrincipaleFrame;
import java.awt.Color;
import javax.swing.SwingUtilities;

/**
 *
 * @author Alif computer
 */
public class CVYASS {

    public static PrincipaleFrame F ;
    public static String pim = "";
    static int r = 26 , g = 188 , b = 156 ; 
    static int rh = 52 , gh = 152 , bh = 219 ; 
    public static float d1 = 0.7f;
    public static float d2 = 0.65f;
    public static int seuil = 2 ;
    public static boolean homographie = true;
    
    public static final Color c0 = new Color(r,g,b, 0);
    public static final Color c1 = new Color(r,g,b, 60);
    public static final Color c2 = new Color(rh,gh,bh, 180);
    public static final Color c3 = new Color(r,g,b, 100);
    public static final Color c4 = new Color(r,g,b, 180);
    
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                F = new PrincipaleFrame();
            }
        });
    }
    
}
