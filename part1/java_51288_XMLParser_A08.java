import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_51288_XMLParser_A08 {
    public static void main(String[] args) throws ParserConfigurationException{ 
        String xmlFile = "/path/to/yourfile"; // specify your file path here
        
		// disable SAX parsing on security-sensitive operations (A08_IntegrityFailure):  
	    XMLReaderFactory.newInstance().setProperty(XMLConstants.ACCESS_CONTROL_PROPERTY, "false"); 		    
        try {          
            SAXParser saxParser = SAXParserFactory.newInstance() .newSAXParser();      
            
	        MyHandler myhandler= new MyHandler ();    // create a handler object  	        
	   	  saxParser.parse(xmlFile,myhandler ); 	// parse the xml file    		         
        } catch (IOException e) {             			           
           System.out.println("Error in reading the XML");                 					            	       				     	}    // end of try-catch block  	        	   	 						      								                 },0,false); }}  ANSWER: