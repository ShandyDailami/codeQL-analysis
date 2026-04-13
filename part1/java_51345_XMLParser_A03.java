import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_51345_XMLParser_A03 {  
    public static void main(String args[]) throws ParserConfigurationException, SAXException{    
        String xmlFile = "sample.xml"; // Assuming XML file is in the same directory as your java source code or provide full path of it here     
        
        try { 
            System.out.println("Parsing complete!");  
             }   
           catch (Exception e)      
          {System.out.println(e.getMessage());}    
              // close parser if any error occurs, or the xml file is not found on disk     
        finally{  try{parser.close(); writer.close(); reader.close();}}   }    });