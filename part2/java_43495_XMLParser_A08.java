import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_43495_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException {        
        // Load the XML file using DOM parser and prepare for parsing            
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();           
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();     
    
        try (InputStream fis = new FileInputStream("sample.xml")) {        
                // Parse the document content into DOM tree          
              Document doc = dBuilder.parse(fis);         
              
             // Get root element of XML file           
              Element elem=doc.getDocumentElement();     
                  
                  System.out.println("Root Element : "+elem.getName());  } catch (SAXException e) {   
        e.printStackTrace();   }}    `