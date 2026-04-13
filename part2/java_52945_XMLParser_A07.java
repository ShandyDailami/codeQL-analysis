import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_52945_XMLParser_A07 {
    public static void main(String[] args) throws ParserConfigurationException, IOException{  
        // Create a new factory for the XML parser
            XmlFactory xmlFactoryObj = Xml.newFactory();      
        
           try (FileReader reader = new FileReader("input.xml")) {    
               // create an instance of the DOM based Parser  object   
             DocumentBuilderFactory dbFactoryObject =  DocumentBuilderFactory .newInstance();  
           
              /* Create a builder for handling XML file */     
                DocumentBuilder documentBuilderObj=dbFactoryObject.newDocumentBuilder(reader);    
        // parse the input xml to save in DOM model of each tag   
             org.w3c.dom.Document docData =documentBuilderObj .parse( );  
            System.out.println("Root element : " +docData.getDocumentElement().toString());  }      catch (Exception e) {         // Catching any errors for handling exception     try/catch blocks   
             throw new RuntimeException ("Error parsing the XML file",e);          };   });        }}`;