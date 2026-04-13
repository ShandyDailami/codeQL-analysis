import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_44503_XMLParser_A08 {  
    public static void main(String args[]) throws ParserConfigurationException, IOException{ 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();             // Create a factory for reading the XML file             
        
        try (FileReader reader = new FileReader("legacy_xmlfile")) {   /* Open and read your xml */   
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder(); 
               
           int lineNumber = 0;          // variable to store current parse location            
              
                  DOMSource source = new DOMSource(dBuilder.parse(reader));       
                   
                   SimpleXMLExtractor myParser=   new SimpleXMLExtractor();         // Creating an instance of the parser                     
                        
                       myParser.startElement("root", null);           /* Call start_element method to print tag and namespace */   
                                                          
                            } catch (Exception e) {                       
                    System.out.println(e.getMessage());                  
                } 
             });    
        }}