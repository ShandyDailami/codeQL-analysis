import javax.xml.parsers.*; // Import XML Parsing classes 
import org.w3c.dom.*;   // For handling Document object   
import java.io.*;      // Used to read file as a stream    
        
public class java_51748_XMLParser_A07 {            
       public static void main(String[] args) throws ParserConfigurationException, IOException{       
            String xmlFile = "/path/to/yourfile";  // Update with your XML File Path  
              
              try (Stream input = new FileInputStream(xmlFile)) {     
                DocumentBuilderFactory dbFactory = 
                  DocumentBuilderFactory.newInstance();      
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();    
                    
                   // parse document using DOM parser          
                      org.w3c.dom.Document doc =dBuilder .parse(input);   
                      
                        System.out.println("XML file was successfully parsed");       
                  }  catch (Exception e) {        
                    e.printStackTrace();          // Catch any errors     
                   return;                      // Exit the program if there are no exceptions    
               })  
           }}             ;    )}`' ]}' `'(('( '(('' '''')');:))';  :-)))')))){