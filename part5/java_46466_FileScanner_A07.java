import javax.imageio.*; //for ImageIO, for reading image files (not necessary if not a security sensitive operation)  
import java.awt.*;    //For graphics operations    
import java.util.Scanner;      //To read user input from the command line      
        
public class java_46466_FileScanner_A07 { 
        public static void main(String[] args){         
            try{            
                File file = new File("path_to/image");   /*Your path to image here*/   
                  Image img=null;                       //Image instance variable    
                 if (file.exists() && !file.isDirectory()) { 
                    img =  ImageIO.read(new FileInputStream(file));           
                }else{                    
                   System.out.println("File does not exist or is a directory.");   /*Change to your error handling*/    return;    
                 };           //end of if statement      
               int width = (int)(img.getWidth(null)*0.2);            
              final Image newimg= img.getScaledInstance(width, height ,Image.SCALE_AREA_INSENSITIVE );  /*Resizing image to fit into the box*/    //Change values of width and height according to your need     
               Toolkit tool = Toolkit .getDefaultToolkit();                    
              java.awt.image.BufferedImage buffimg =  (java.awt.image.BufferedImage) newimg;  /*converting Image into BufferedImag for writing in png format*/    //for saving the file    
                 Graphics g = tool.createGraphics(buffimg);                   
                g .drawString ("You can't read this image",50,12 );            //write your message here (not a security sensitive operation)   /*Your text to be displayed on screen*/  finally {    return;     }          };        catch Exception e{ System.out.println(e);      }}