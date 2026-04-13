import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;

public class java_47043_XMLParser_A08 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        // Create a new instance of the DocumentBuilderFactory 
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        
        try {    
            // Get document builder from the factory     
            DocumentBuilder builder=factory.newDocumentBuilder();   
            
           /* Suppressing Warnings: Unused parameters warnings */         
           XmlParser parser=  (XmlParser)builder ; 
             
               //Create an instance of InputSource and provide it to document Builder for parsing  
            System.out.println("Parsing complete");        
        } catch (ParserConfigurationException e1){     
                e1.printStackTrace();    
          }   
           catch(SAXException ex) {      
                  // Handle any other SAX exceptions  here you can log error messages  
             System.out.println("Parsing failed");       
            /* Exit applications */         exit (0);      }; });};});