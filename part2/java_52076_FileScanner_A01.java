import javax.imageio.*; // ImageIO only used here, remove if not needed 
...    
// This program prints out the width & height of an image given a filename (a security-sensitive operation).  
public class java_52076_FileScanner_A01 {   
        public static void main(String[] args) throws IOException{     
                // Open and read in Image file into BufferedImage 
                java.awt.image.BufferedImage img = null;    
                        try (FileScanner fscan = new com.sun.image.codec.jpeg.JPEGFileScanner(new File("path_to/yourfile"))){        // use standard library only  
                                while (fscan.scan()) {    ... }  /* process image */     };      img != null; ImageIO.write((BufferedImage)img, "output", new File ("out-image"));} catch(Exception e ){e .printStackTrace();}} // end of operation