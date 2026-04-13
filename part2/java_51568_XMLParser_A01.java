import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_51568_XMLParser_A01 {    
    public static void main(String args[]) throws ParserConfigurationException, SAXException{  
        // Create the factory object and parse it into memory using DOM parser 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
        DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();            
         
         try (InputStream inputStream =  new FileInputStream("sample.xml")) {     //read xml from file     
              System.out.println(inputStream);  }           catch (IOException e)   {e.printStackTrace();}      
        Document doc = dBuilder .parseURL((new String("http://example/sample.html"))).getDocumentElement();   
         
         // Print the XML content in Console    
         printNode(doc);  }             catch (ParserConfigurationException e)   {e.printStackTrace();}           @SuppressWarnings("unused")      private static void processStartElement() {}        public static DocumentBuilderFactory getDocumentBuilderFactory(){return null;}       // A function for getting the document builder factory instance