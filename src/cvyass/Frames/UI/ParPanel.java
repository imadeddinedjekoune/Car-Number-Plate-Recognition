/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvyass.Frames.UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 *
 * @author Alif computer
 */
public class ParPanel extends JPanel{
    JLabel lh , ls , ld ;
    JCheckBox check1 = new JCheckBox("Oui"); 
    JCheckBox check2 = new JCheckBox("Non");
    JTextField f1 , f2 ;
    JButton save ;
    public ParPanel()
    {
        lh = new JLabel("Homogenie : ");
        ls = new JLabel("Seuil : ");
        ld = new JLabel("Distance : ");
        save = new JButton("Save");
        
        f1 =  new JTextField(""+cvyass.CVYASS.seuil);
        
        
        if(cvyass.CVYASS.homographie){
            check1.setSelected(true);
            f2 =  new JTextField(""+(float) cvyass.CVYASS.d2);
        }else{
            check2.setSelected(true);
            f2 =  new JTextField(""+(float) cvyass.CVYASS.d1);
        }
        
        
        lh.setBounds(20, 10, 80, 20);
        check1.setBounds(130, 10, 60, 20);
        check2.setBounds(190, 10, 60, 20);
        check1.setEnabled(true);
        
        
        ls.setBounds(20, 50, 80, 20);
        ld.setBounds(20, 90, 80, 20);
        f1.setBounds(120, 50, 150, 20);
        f2.setBounds(120, 90, 150, 20);
        save.setBounds(200, 150, 70, 30);
        
        ButtonGroup group = new ButtonGroup();
        group.add(check1);
        group.add(check2);
        setLayout(null);
        
        add(lh);
        add(ls);
        add(ld);
        add(f1);
        add(f2);
        add(check1);
        add(check2);
        add(save);
        
        
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cvyass.CVYASS.seuil = Integer.parseInt(f1.getText());
                if(cvyass.CVYASS.homographie)
                {
                    cvyass.CVYASS.d2 = Float.parseFloat(f2.getText());
                    
                }else{
                    cvyass.CVYASS.d1 = Float.parseFloat(f2.getText());
                    cvyass.CVYASS.d2 = 0;
                }
            }
        });
        
        
        check1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    cvyass.CVYASS.homographie = true;
                    f2.setText(""+(float) cvyass.CVYASS.d2);
                }else
                {
                    cvyass.CVYASS.homographie = false;
                    f2.setText(""+(float) cvyass.CVYASS.d1);
                }
            }
        });
    }
    
    
    
}
