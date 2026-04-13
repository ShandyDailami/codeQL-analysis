import javafx.scene.control.*;
  
public class java_47720_XMLParser_A08 {    
    public static void main(String[] args) throws Exception{        
        try (InputStream is = new FileInputStream("sampleFileForIntegrityFailureCheck_A08")) {            
            XMLParser parser=new XMLParser();  //Create an instance of the xmlparser.  
              
              if(!isValidXML(xml)){               
                  throw new SecurityException ("The file seems to be not a valid or corrupted!");      }                     
                   else{                             printDetail (doc,"/bookstore");}                       endif;       //end try-catch block     return 0;}         @Test    public static int main(String[] args) {        FileChooser filechooser = new   FileChooser();      while(!filechooser.showOpenDialog().isPresent()){ThreadingUtilities .sleepMilliseconds (1); }       //Get the selected files from user