/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvyass.Frames.UI;

import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Alif computer
 */
public class PanelBorder extends JPanel{
    
    public PanelBorder(int val)
    {
        setOpaque(false);
        setPreferredSize(new Dimension(5, 5));
        setCursor(new Cursor((val)));
    }
    
}
