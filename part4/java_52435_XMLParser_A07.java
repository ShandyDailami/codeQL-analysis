import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_52435_XMLParser_A07 { 
    public static void main(String[] args) throws ParserConfigurationException, IOException{  
        // Load the xml file into a Document object    
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();     
        
        try (FileReader reader = new FileReader("src/main/resources/samplefile.xml")){  //Replace with your file location and name   
            Document doc = dBuilder.parse(reader);    
            
           doc.getDOCUMENT_NODE().getNodeName();  
         }     
        catch (Exception e){         
               System.out.println("Error in parsing XML: " +e );  //Handle exceptions appropriately   
            return;      
              });                     
     }}