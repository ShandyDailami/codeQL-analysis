import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;

public class java_51330_XMLParser_A07 {  
    public static void main(String args[]) throws ParserConfigurationException, SAXException{ 
        // Create a new instance of the DocumentBuilderFactory
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        
        // Retrieve parser/builder for the DOM
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();      
  
        try {            
            /* parse an XML file */ 
           InputSource is = new SAXSource(new MyContentHandler(), true);   
          DTDHandler handler= (DTDHandler)dBuilder; // not needed for XSD validation, it's optional.     
         Document doc =  dBuilder.parse(is ,handler );  
        }  catch (Exception e1){             
            System.out.println("Parsing the XML has failed with error : " +e1);    
           return;                  
          // end of try                 system out println                 
         };//end parse xml                     
       /* not needed for XSD validation, it's optional  */       
      System.out.println("XML file parsed successfully.");  
    }              
}                            ## End Of Main Method