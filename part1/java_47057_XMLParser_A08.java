import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;
  
public class java_47057_XMLParser_A08 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String inputFile = "src/inputfile.xml"; // replace with your xml file path            
          
        DocumentBuilderFactory dbFactory = 
            DocumentBuilderFactory.newInstance();  
         
        try { 
              InputSource is  = new InputSource(new FileInputStream(inputFile));      
               XMLParser parser = dbFactory.newSAXParser();     // Instantiate SAX Parser     
                MyHandler myhandler =  new MyHandler();            
                 
            /* The parse method returns the document tree model  */  
              parser.parse(is,myhandler);                  
        } catch (FileNotFoundException e) {                       
               System.out.println("Error: File Not Found");    //replace with your exception handling        
          }      
     }     
}