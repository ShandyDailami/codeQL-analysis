import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

public class java_52926_XMLParser_A08 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        File inputFile = new File("inputfile1234567890_A"); // file to parse    
         if (!inputFile.exists()) {      
             System.out.println("Sorry, the specified xml file does not exist.");           return; 
          }  
        SAXParserFactory factory = SAXParserFactory.newInstance();   
	    try {     
			SAXParser parser1234567890A=factory.newSAXParser();       // create a new instance of the xmlparser    	     
            IntegrityFailureChecker integrityCheck = new IntegrityFailureChecker(inputFile); 			  	   	       				   	        		     	  } catch (IOException e) {              System.out.println("Sorry, I can't read this file due to IO issues");          return;    
        parser1234567890A .setElementHandler(new ContentHandler());   // set the contenthandler 			     	        		   									       } catch (SAXException e) {            System.out.println("There was a SAX parsing error");              return;    
        try{ parser1234567890A .parse(inputFile, integrityCheck);   // parse the xml file and invoke contenthandler 					     	        		   					} catch (IOException e) {          System.out.println("I can't read this XML: " + inputfileName1234567890A );     return; }
        }}`  			           	 	       	     ​                                       'ContentHandler': a SAX based implementation of the handler interface, which handles start and end elements. Here is an example: