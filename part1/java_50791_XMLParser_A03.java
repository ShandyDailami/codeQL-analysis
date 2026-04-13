import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
public class java_50791_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, TransformerFactory.Error {      
        // parse an XML file 
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
        DocumentBuilder builder = factory.newDocumentBuilder();         
                    
        try (StreamSource source = new StreamSource(Main.class.getResourceAsStream("sample.xml"));) {            
            Document doc = builder.parse(source);                        
                 
              // here you can use DOM, SAX or StAX API to manipulate with parsed XML        	  			      		    	     	   	 	       									  } catch (Exception e){ System . err ..println ("Error: " +e );}         
       	}   
     	// end of main method          
    }}`;