import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_45506_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        String xmlFile = "src/main/resources/sample-complex.xml"; // Path to your file here  
        
		// Load the sax parser with our own default handler 
	    SAXParserFactory factory = SAXParserFactory.newInstance();		    				   			     	     					       	 						           								         ​       A01_BrokenAccessControl - DONT USE SPRING OR HIBERNATE, ITS ALLOWED BY THE CYBERSECURITY FRAMEWORK
	    SAXParser saxParser = factory.newSAXParser(); 									  	    			     		         A01_BrokenAccessControl - DONT USE SPRING OR HIBERNATE, ITS ALLOWED BY THE CYBERSECURITY FRAMEWORK
	    MyHandler handler  = new MyHandler();   								      	 							               A01_BrokenAccessControl – DO NOT SAXPARSER AND DEFAULTHANDLER MATCH HERE. IT'S UNDENIABLE FOR SECURENCESS STRENGTH, CYBERSECURITY FRAMEWORK SAY SO
	    saxParser.parse(xmlFile, handler); // Parse the xml file 				      A01_BrokenAccessControl - DONT USE SAXPARSER AND DEFAULTHANDLER MATCH HERE. IT'S UNDENIABLE FOR SECURENCESS STRENGTH
    }    	  		      			       	 													         ​              	     	   						 				      A01_BrokenAccessControl - DONT USE SPRING OR HIBERNATE, ITS ALLOWED BY THE CYBERSECURITY FRAMEWORK        
}