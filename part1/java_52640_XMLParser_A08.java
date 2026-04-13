import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_52640_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{    
        // Create a new parser factory 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
        
        try (XMLEventReader reader = DOMSource.newInstance(new File("sample.xml")).getReader()) {   
            // Parse the XML file  
           while (reader.hasNext()){                
                TextElement xmlEvent = (TextElement) reader;            
               System.out.println((String) xmlEvent); 
              }    
        } catch(Exception e1 ){      
          e1.printStackTrace();     
         //e2 .getLocalizedMessage());  
           /*Note: Please modify exception handling */   
           
	    }}`