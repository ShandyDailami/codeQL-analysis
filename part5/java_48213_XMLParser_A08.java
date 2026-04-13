import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
  
public class java_48213_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();            
        DocumentBuilder builder =  factory.newDocumentBuilder();          
             
        // Parse the document and get a DOM tree of it         
        Document doc = builder.parse( new SourceResource("sampleFile.xml") );   
        
        // Get root element  (this is same as <element> in XML)  
       Element elem  =doc.getDocumentElement();     
             
           System.out.println("\nNode Name : " +elem.getNodeName());           
             }    
}