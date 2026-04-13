import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_52432_XMLParser_A03 { 
    public static void main(String[] args) throws ParserConfigurationException, IOException{  
        // Create a new factory object for reading from the DOM
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();    
        
        // Get document builder of the same type as parser and configure it with this Factory     
        DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();  
          
        System.out.println("Initializing XML Parser...");   
         
        // Parse the input from source file into a DOM tree  object using builder's readTree method    
        
       Document doc =dBuilder .parse( new SourceResource( "sample.xml") );  
                 
           System.out.println("XML Parsing Complete.");   
      }         
}