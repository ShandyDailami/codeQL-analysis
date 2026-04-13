import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_53781_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        String xml = "<document><title>Tutorial Point</title></document>"; // This should be your real XML data from a secure source. 
        
        SAXParserFactory factory = SAXParserFactory.newInstance();    
	SAXParser saxParser= factory.newSAXParser( new Properties());  		   				     			      					         																// Provide the correct file name of xml resource (XML) here for real time parsing  // Assumption is done as per your requirement in minimalist style above mentioned
	     DefaultHandler handler = new Myhandler();                          // Handler to handle parsed data.   You can use any default handling mechanism provided by SAXParser if you don't want a custom one           				     			      					         		 	 							// Assumption is done as per your requirement in minimalist style above mentioned
	     
        saxParser.parse(new InputSource( new StringReader (xml)), handler);     // Passing the xml and Handler to parse  	Assumption here - I am assuming you want a real time parsing, if not then pass source as file inputstream 				     			      					         		
    }       	 	     	   							// Assumption is done according requirement in minimalist style above mentioned.     This should be your own code for handling the parsed data based on requirements and use cases	   // Here you can add any custom processing or error reporting mechanism as per needs 				     			      					         		
}