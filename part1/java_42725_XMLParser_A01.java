import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_42725_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{    
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();                
            
        // parse the document  with DOM parser (not recommended if you need to support multiple documents at once)         
        Document doc =dBuilder .parse( new SourceResource("sampleFilePath") );  
                    
         // get all 'item' nodes in this XML file   
       NodeList nodeList=doc.getElementsByTagName("Item"); 
                        
      for (int temp = 0; temp <nodeList.getLength();temp++) {         
           Element element =(Element) nodeList.item(temp);  
                    // Accessing and printing data of an item                 
                   String name=element .getElementsByTagName("name").item(0).getTextContent() ;   
                ...  rest logic for security sensitive operations related to A01_BrokenAccessControl goes here...        }    
       }}