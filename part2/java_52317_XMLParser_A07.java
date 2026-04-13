import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_52317_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{     
        // Create a new instance of DocumentBuilderFactory    
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
        
        // Get corresponding parser from the factory         
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();          
           
        // Parse an HTML file and store in DOM object  
        Document doc = dBuilder.parse(new File("inputFilePath"));            
              
        doc.getElementsByTagName("xml_tag").item(0).getTextContent());    } 
}