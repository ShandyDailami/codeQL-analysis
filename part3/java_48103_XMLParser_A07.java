import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_48103_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{      
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();            
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();           
        
        // Parse the xml file 
        try (FileReader fr = new FileReader("inputfilepath")) {              
          Document doc = dBuilder.parse(fr);   
          
          System.out.println("\nXML content:\n");  
               
          printElementList(doc, "\\");     // Print all elements of the document 
        } catch (SAXException e) {            
            e.printStackTrace();              
         }                        
    }}