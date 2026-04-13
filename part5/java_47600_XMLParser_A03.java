import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;    // Import Input/Output Exceptions      
public class java_47600_XMLParser_A03 {    
        public static void main(String[] args) throws ParserConfigurationException, IOException{        
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
            DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();    // Create a new DocumentBuilder Factory         
            
           try (InputStream fis = Main.class.getResourceAsStream("/samplefile1638452_709x831-removebg-preview(1).xml")) { 
            Document doc = dBuilder.parse(fis);     // Parse the document from file          
            
              doc.getDocumentElement().normalize();   
               System.out.println("Root Element : " +doc.getElementsByTagName("Books").item(0).getTextContent());  } catch (SAXException e) {                
                // TODO Auto-generated method stub    
                  e.printStackTrace();      }}