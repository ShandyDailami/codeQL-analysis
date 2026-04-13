import javax.imageio.ImageIO;   // for reading image files, you need to import this class java_46161_FileScanner_A07 required below in the method getImages() using try-catch block and exception handling mechanism   
import java.awt.*;                //for getting color of images or videos (e.g., RGB value) 
//...and other necessary classes too....  
public static void main(String[] args){    
try{          
         FileScanner();             // calling the method file scanner to start program   
}catch(Exception e ) {            // catching exception and handling it      
e.printStackTrace() ;              // printing error message     
}} 
//...and other necessary methods too....