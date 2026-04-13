import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_49401_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        String xmlFile = "/path/to/yourxmlfile"; // Replace with your actual XML file path here      
         parseXmlDocument(xmlFile);     
     }         
          
   private static void parseXmlDocument(String filename) throws ParserConfigurationException, SAXException { 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();   
        DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();      
        
        // Enable XPath and Namespaces     
        dBuilder.setFeature("http://xml.org/sax/features/namespaces", true); 
          System.out.println(dBuilder.getNamespaceSupport());   
           if (filename != null) {    
              Document doc = dBuilder.parseURL(new URL("file:" + filename));   // Parse the file     
               printDocumentInfo(doc, "FileBased");  } else{       
                  System.out.println ("Null File Path!");    return;      
           }           
     }}