import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_48247_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{     
        // Create a new XMLReader    
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
         
         try (XMLReader reader =  factory.newDocumentReader(new File("inputfile.xml"))){  
            for (;reader.hasNext();) {   
                Node node;     
                  while ((node= reader.nextNode()) != null);     // Loop through XML document  and get next child or sibling nodes        
              }         
        } catch (ParserConfigurationException e1){  
            System.out.println("Caught exception parsing configuration: " + e1.getMessage());   
       };     
}