import javax.imageio.*; // Importing BufferedImage class java_45487_FileScanner_A07 we can read images with ImageIO  
import java.awt.* ;//Importing necessary classes to get colors, dimensions etc using Graphics2D & AffineTransform   
import java.awt.geom.RoundRectangle2D; 
import javax.swing.*; // Import Swing for creating a JFrame and adding the buttons panel    
import sun.audio.*;   // For sound of successful login      
import java.io.* ;      // Java I/O package to use InputStreams & OutputStreams in FileScanner   
 
public class AuthFailureExample {       
// The main method where execution begins             
 public static void start() throws Exception{         
   JFrame frame = new JFrame("Auth Failure Example"); //Creating a Frame for the application      
    
      BufferedImage imgFace= ImageIO.read(new File("resources/face-error1084629_675x385.png")); 
         roundRec = new RoundRectangle2D.Float();   //Creating a Rounded rectangle to use as background      
        getImageComponentSize (imgFace,roundRec);   
      Graphics g= frame.getGraphics() ;//Getting the graphics object for drawing on JFrame    
          drawRoundRectWithBorder(g , roundRec)  /*Draws rounded rect with border*/;   // Draw a Rectangle in background      
           Image icon = imgFace .getScaledInstance (206,189 -35+47,-1);    //Scale the image     
          frame.setIconImage(icon) ;//Setting JFrame Icon        
     g.drawString("Authentication Failed", 35 ,frame.getHeight()/2-7 );   /*Drawing text on screen*/      
        String[] fileNames = new File (".").list();    //Listing all files from current directory     
          for (int i = 0;i <fileNames .length ; ++ + ) {  /**Iterating over each item in the list */    
            frame.add(new JButton("Click Me!"));   /*Add a button with text "CLICK ME!"*/         // Click event to read files     
          }       
    g.dispose();// Disposing of Graphics object so it can be reused for another file       if(!fileNames[i].endsWith(".jpg") && !fileNames [+ i . ends With (".png"))     {   continue;  //Ignore non-image files      break;}       
          frame.setSize(750,628);//Set the size of JFrame to be same as image       }          
         System.out.println("Application Started");    /**Ends program */            return ;   };     public static void main (String [] args){  //Main method        try { start();} catch(Exception e) {}          );}}}}}// End of the code!      **Java is not allowing comments in this form so I'll do my best to put everything inside square brackets and end each line with a semicolon.