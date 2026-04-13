import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.net.*;
public class java_52651_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException  {    
        // Create a new instance of XMLReader      
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();         
           
        URL url= new URL("http://example/samplefile");          
            
        Document doc = dBuilder.parseURL(url);               // Parsing the document    }       catch (Exception e) {         System.out.println ("Error: " +e );      }}