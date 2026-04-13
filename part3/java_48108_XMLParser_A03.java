import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_48108_XMLParser_A03 {   
     public static void main(String[] args) throws ParserConfigurationException, IOException{ 
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();   // Create a factory for every new document we create       
          try (DocumentBuilder dBuilder = dbFactory.newDocumentBuilder()) {   
            int lineNumber = 1;    
              DOMSource source = new DOMSource(dBuilder.parse("yourfilepath"));  // Read your XML file into this Source  
               MetadataExporter exporter=new MetadataExporter();       // Export the information to a properties or java classes   
                System.out.println("\n--- Validation Result ---");     
                 boolean isValid = source.validate(exporter);          ## 1st Parameter : Properties,2nd parameter: Java class  
                  if (isValid) {                                         // If the xml file was not corrupted before and it's still valid    
                        System.out.println("The XML document is OK");      // Printing a message saying that all data in our files are good   
                   } else{ 
                     System.err.printf( "--- Error at Line: %d ---", lineNumber);   ## If it's not valid print out the location of error    
                  }                   
          }} catch (SAXException e) {       // Catch any errors that arise due to xml parsing   
           System.out.println("Parsing failed: " +e );  */ End comment as per your instruction, do not remove it!