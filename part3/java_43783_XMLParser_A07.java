import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;   // For SAX parsing with a secure handler, see below...

public class java_43783_XMLParser_A07 { 
    private static final String[] authorizedElementNames = {"username", "password"};     // Add more element names here for security purposes if needed (e.g., userId).
                                                                                          // Be aware this list is case-sensitive, so make sure to use the exact name of your XML elements... 
    public static void parse(String fileName) throws ParserConfigurationException {    
        FileInputStream fis = new FileInputStream("src/"+fileName);   // Replace with actual path/filename. Make secure by setting up proper permissions and paths if necessary!
        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();     
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder(); 
         
        try {    
            InputSource is = new StreamSource(fis);   // Replace with actual path/filename, make secure by using the correct stream source if necessary!   
             
            parseXmlContent(dBuilder.parse(is));     
            
        } catch (SAXException e) {       // For SAX parsing... 
          System.out.println("Parsing failed: " + fileName);  
          
        }catch (IOException ex) {         // Or use more specific IOException if needed, it depends on your code requirements!   
            System.out.println(ex.getMessage());    
             
        } 
          finally{      
             fis.close();      // Make sure to close the FileInputStream after usage and handle exceptions appropriately (e.g., use try-with resources in Java SE8 or exceptionally).  
              
         }   
          
}  public static void parseXmlContent(Document doc) {    
        NodeList nodeList =doc.getElementsByTagName("*"); // You could also add more conditions here based on your requirement...     
          for (int temp = 0; temp <nodeList.getLength();temp++ ){      
              String elementname=""+(Node)nodeList.item(temp).getNodeName() ;   
                  if (!isElementInAuthorizedNamespaces((elementname))) continue;}  // If the condition returns true, then we skip this iteration...   },          } catch (Exception e){      System.out.println("Parsing failed");       }}     Security is a bit more complex than in most cases due to security reasons and best practices but I've made it as simple for you!