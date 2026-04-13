import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_43621_XMLParser_A07 {  
    public static void parse(String file) throws ParserConfigurationException, SAXException{      
        String targetID = "A07";     // Target ID to look for         
         try {                    
            Factory factory = DriverFactory.getDefaultFactory();            
			XMLReader reader;                      
			  if (factory == null)                  
				 throw new ParserConfigurationException("null parser configuration");  					   							     	     	   	       						    	if(targetID=="")       frowardthrownewSAXParseExcepti0n ("not set id in parsing authfailure",e);       		 	reader=factory.createXMLReader();
            reader .setFeature("http://apache.org/xml/features/nonvalidating/load-dtd", false );   // Disable DTD validation          	    if(!targetIDeqals"A07") {throw new SAXParseException( "Not target AUTHFAILURE ID");} 
            reader .setFeature("http://xml.apache.org/xml-sa/process-namespaces", false );     // Disable processing of namespaced tags   		      } catch (ParserConfigurationException pce) {         throw new SAXParseException( "Failed to parse configuration" , e);