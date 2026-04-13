import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
public class java_50472_XMLParser_A03 {    
    public static void main(String[] args) throws Exception{        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();            
       // Setting it to true ensures that the DOM parser is capable of load external DTD / XML declaration (like SVG, MathML etc.).         
        factory.setValidating(true);          
           
        try {                
              URL url= new Class().getResource("/sampleFileForTestingInjectionAttacks.xml");  // path to your xml file        
             DocumentBuilder builder = factory.newDocumentBuilder();               
               System.out.println("Loading the XML document.......");                   
            Document doc =  builder.parse(url.openStream());                
                   DocType docType= new DocType("sample", "");                      // sample name and public identifier for defining type of xml file     	            	   		  			   				    	} 	        catch (Exception e) {         System.out . println ("Error: Unable to parse the XML document, Reason:" +e);          }       
            docType=null;                  // Disabling DOCTYPE declartion as we are done with xml file                     	   		  			   				    	} 	        catch (Exception e) {         System.out . println ("Error: Unable to parse the XML document, Reason:" +e);          }
        }}`	            in your case replace `/sampleFileForTestingInjectionAttacks.xml with path of actual file you are going to use for testing injection attacks A03_SecuritySensitiveOperations   .  Also make sure that the Java version being used supports these features (dom, xmlparser)