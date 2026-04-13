import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_46370_XMLParser_A03 { 
    public static void main(String[] args) throws ParserConfigurationException, IOException{  
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();    
        
        // Parse the XML file into a document object (DOM). 
        Document doc=dBuilder.parse( new File("src/inputFilePath") );  
         
        System.out.println("\nRoot element : "+doc.getElementsByTagName("tag_name").item(0).getTextContent()); //replace tag name and path with actual values 
        
    }      
}