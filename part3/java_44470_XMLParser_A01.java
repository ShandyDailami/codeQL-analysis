import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_44470_XMLParser_A01 {
    public static void main(String[] args) throws Exception{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(true); //Use default handler and disable namespaces, true for strict mode (errors if found in the XML file).  
            
           /* The input is an example of a broken access control document */ 
          File xmlFile =  new File("src/main/resources/brokenAccessControl.xml");    
            SAXHandler handler = new SAXHandler();    //SAX Handler implementation to handle the XML Document content  
            
           parser.parse(xmlFile,handler);      //Parse and listen for events from parsing engine (startElement etc)  } catch... block} */;       
             
          System.out.println("Completed Parsing..." );    	      	   		   	     	       									  	 			        	}// end of main() method          						              															      //End FileReadException,IllegalArgumentException ,SAXException  and others as per exception handling in real world applications
}