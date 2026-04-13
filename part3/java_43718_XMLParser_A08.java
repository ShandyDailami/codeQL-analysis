import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_43718_XMLParser_A08 {
    public static void main(String[] args) throws Exception{ 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        
        // Parse XML file and store it in a tree structure  
        Document doc = dBuilder.parse( new File("path_to/yourfile") ); 
          
        System.out.println("\nXML Content: ");   
         
       readAndPrintXmlFile("/Users/userNameHere/.IntrusionDetectionSystems/_A08-IntegrityFailure",doc);   //replace with your file path and name here
         } 
     private static void readAndPrintXmlFile(String location, Document doc) {   
        Element rootElement = doc.getDocumentElement();     
           System.out.println("Root Elements: " +rootElement.getNodeName());   // Prints Root element name of XML file which is by default 'file' in this case 
       }    
}