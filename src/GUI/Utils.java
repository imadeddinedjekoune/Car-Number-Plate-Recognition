/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Alif computer
 */
public class Utils {
    public static void Crop(Point p1 , Point p2 , Point p3 , Point p4) throws IOException
    {
        Point[] pts = {p1,p2,p3,p4};
        BufferedImage image = ImageIO.read(new File("test3.jpg"));
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                int alpha = 255;
                int red = 255; 
                int green = 0; 
                int blue = 0; 
                int color = (alpha << 24) | (red << 16) | (green << 8) | blue;
                Point p = new Point(x, y);
                if (InPoly(pts, p))
                {
                    image.setRGB(x, y, color);
                }
                
            }
        }
        ImageIO.write(image, "png", new File("computed.png"));
    }
    
    public static String WrapPerspective(String args)
    {
        String commande = "\""+System.getProperty("user.dir")+"/python/test.py\" "+args;
        commande = commande.replace("\\\\", "/");
        commande = commande.replace("\\", "/");
        
        ProcessBuilder builder = new ProcessBuilder(
            "cmd.exe", "/c", commande);
        System.out.println("commande : "+commande);
        builder.redirectErrorStream(true);
        Process p = null;
        try {
            p = builder.start();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        String res = "";
        while (true) {
            try {
                line = r.readLine();
            } catch (IOException ex) {
                System.out.println(ex);
            }
            if (line == null) { break; }
            res += line;
        }
        return res;
    }
    
    
    public static String CropAsSelected(String args)
    {
        String commande = "\""+System.getProperty("user.dir")+"/python/test2.py\" "+args;
        commande = commande.replace("\\\\", "/");
        commande = commande.replace("\\", "/");
        
        ProcessBuilder builder = new ProcessBuilder(
            "cmd.exe", "/c", commande);
        System.out.println("commande : "+commande);
        builder.redirectErrorStream(true);
        Process p = null;
        try {
            p = builder.start();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        String res = "";
        while (true) {
            try {
                line = r.readLine();
            } catch (IOException ex) {
                System.out.println(ex);
            }
            if (line == null) { break; }
            res += line;
        }
        return res;
    }
    
    public static String Sift1(float d1,float d2, int s)
    {
        String commande = "\""+System.getProperty("user.dir")+"/python/sift.py\" "+d1+" "+d2+" "+s;
        commande = commande.replace("\\\\", "/");
        commande = commande.replace("\\", "/");
        
        ProcessBuilder builder = new ProcessBuilder(
            "cmd.exe", "/c", commande);
        System.out.println("commande : "+commande);
        builder.redirectErrorStream(true);
        Process p = null;
        try {
            p = builder.start();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = null;
        String res = "";
        while (true) {
            try {
                line = r.readLine();
            } catch (IOException ex) {
                System.out.println(ex);
            }
            if (line == null) { break; }
            res += line;
        }
        return res;
    }
    
    public static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
    
    public static boolean InPoly(Point [] points , Point test)
    {
        Polygon polygon = new Polygon();
        for (int i = 0 ; i < points.length ; i++ )
        {
            polygon.addPoint(points[i].x,points[i].y);
        }
        return polygon.contains(test.x, test.y);
        
    }
}
