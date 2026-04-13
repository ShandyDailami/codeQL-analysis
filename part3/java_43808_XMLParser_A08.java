import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_43808_XMLParser_A08 {
    public static void main(String[] args) throws ParserConfigurationException, IOException{
        // Create a new instance of DocumentBuilderFactory and set it to use the default values when parsing an xml document 
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        
        try {
            System.out.println("Parsing XML using DOM parser...");    
            
           // Create a new instance of DocumentBuilder from our Factory   
            @SuppressWarnings("unused")
			DocumentBuilder builder = factory.newDocumentBuilder();  
        
                // Parse the given input file into an in memory representation (DOM) 
               Document doc =  builder.parse(new InputSource(new StringReader("<data><info>Secure Information: This is sensitive data, please don't share it! </info></data>")));  
            	doc.getDomConfig().setValidating(true); // Enable validation for the document 
                  
               System.out.println("\nXML Document Loaded successfully..." );    
          } catch (SAXException e) {   
              e.printStackTrace();     
          	}  
       	catch (ParserConfigurationException pce){      	 		        	       	     	   			           									  // catching the exception raised by XMLReader and setting it to true using setValidating(true);     }          System.out.println("XML Parsing successful..." );    }}