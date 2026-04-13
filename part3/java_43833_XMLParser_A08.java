import javax.xml.*;
import org.w3c.dom.*;
import java.net.URL;
public class java_43833_XMLParser_A08 {  
    public static void main(String[] args) throws Exception{      
        URL url = new URL("http://example.com/sample.xml"); // Provide your XML file here 
        
        DocumentBuilderFactory dbFactory = 
          DocumentBuilderFactory.newInstance();     
                
        DocumentBuilder dBuilder = 
            dbFactory.newDocumentBuilder();  
              
           /* parse the document and use DOM for security sensitive operations */   
       Document doc =dBuilder.parse(url.openStream());  // Parse XML file from URL            
        
     }     
}