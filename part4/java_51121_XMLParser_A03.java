import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.*;

public class java_51121_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String inputFile = "/path/to/your_file"; // replace with your file path          
      
	    try (SAXParserFactory factory = SAXParserFactory.newInstance();            
	         SAXParser saxParser = factory.newSAXParser(true)) {                        
		    Handler myHandler= new MyHandler();             
            XMLReader reader =  saxParser.getXMLReader();         
	        reader.setContentHandler(myHandler);           // set content handler            
	        
	        saxParser.parse(new File(inputFile), myHandler );        // parse the file   		      			    	 	    } catch (IOException e) {                     System.out.println("Error while parsing XML: " +e ) ;  }}         `