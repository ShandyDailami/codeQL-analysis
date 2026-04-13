import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
  
public class java_53572_XMLParser_A08 {
    public static void main(String[] args) throws ParserConfigurationException, IOException{    
        // Step1: Load the W3C DocumentBuilderFactory and set it as parser configuration 
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
          
        try (XMLEventReader reader = 
                factory.newXMLEventReader( new FileInputStream("inputfilepath"))) {            
            // Step3: Parse the XML file and create a DOM tree representation of it 
            Document doc = builder().parse(reader);   
              
           /* Here you can write your security-sensitive operations such as checking for integrity failure, etc.   */     
        } catch (SAXException | ParsingException e) {            
          System.out.println("Parsing failed: " + e.getMessage());             
         // Step4 : Handle the exceptions in a creative and realistic way                    
       } finally{    
           factory = null;   
        }}   /* End of main method */ 
}