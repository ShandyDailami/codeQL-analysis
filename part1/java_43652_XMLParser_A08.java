import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_43652_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{ 
        String xmlFileName = "sample_file.xml"; // replace with your file name and path     
        
       File inputFile =  new File (xmlFileName);           
         
           DocumentBuilderFactory dbFactory =  
                DocumentBuilderFactory.newInstance();    
             
             DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();   
              
        // parse using the builder to construct DOM tree from parsed source 
         Documents document =  dBuilder .parse(inputFile);     
          
          readXMLContents (document );   }      
            private static void readXMLContents(Documents doc) {     throw new UnsupportedOperationException();}    /* placeholder for actual operation */             public static String sanitizeStringForXmlEntities(final  InputSource in){throw new IOException("This function should not be called"); return null;}        }