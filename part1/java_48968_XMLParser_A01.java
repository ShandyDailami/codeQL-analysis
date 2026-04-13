import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_48968_XMLParser_A01 extends DefaultHandler {  // Create your own handler if you want to add specific error handling mechanism like logging, exception throwing etc.   
    
   public static void main(String[] args) throws ParserConfigurationException{     
       String xmlFile = "inputfilepath";          
        SAXParserFactory spf  = SAXParserFactory.newInstance();            // Create a new instance of the factory 
        
        try {            
          System.out.println("Parsing XML file using Simple SAX Parser");     
    	  SPF =spf.newSAXParser();             
           DocumentBuilder dbuilder=SPF.getDocumentBuilder();            // Create a new document builder  
	       org.w3c.dom.Document doc  =dbuilder.parse(xmlFile);        // Parse the xml file into DOM 
    	   
         parseElementContent (doc, "");              
      }           catch (SAXException e){           
          System.out.println("Parsing failed: Reason :"+e.getMessage());      
	   return;                                                                       
    }}                        finally{                                        // Ensuring the close connections                                                         
    	if(SPF != null) SPF =null ; if (doc !=  null ) doc  =null;}             try {         }catch (ParserConfigurationException e){          System.out.println("Error configuration parser " +e.getMessage());} catch   ... omitted for brevity