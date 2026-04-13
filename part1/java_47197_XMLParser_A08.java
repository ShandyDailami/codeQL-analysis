import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_47197_XMLParser_A08 {    
    public static void parse(String fileName) throws SAXException, ParserConfigurationException{        
        // Create a new instance of the DefaultHandler  
        MySAXHandler myHandler = new MySAXHandler();         
          
        // Parse XML using this handler      
        SAXParserFactory factory = SAXParserFactory.newInstance();             
        SAXParser parser=factory.newSAXParser(null);     
              
        try {    
            System.out.println("Parsing Complete: "+fileName );  // Prints filename if successful  
                  
             } catch (IOException e)      
                  {} finally{   	        		         	       	 			                                                         	   	     									                      ,e);     	}          `