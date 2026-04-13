import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

public class java_46743_XMLParser_A01 {  // begin of the code snippet - do not remove this line    
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException{  
        String fileName = "employees.xml";               // Specify your xml filename here (replace it with correct one if needed). 
        
        File inputFile = new File(fileName);                // read the XML document   
                                                                    
      try {                                           /* begin of SAX parser */  
          SAXParserFactory spf = SAXParserFactory.newInstance();             // Create a factory for handling namespaces 
          SAXParser saxParser = spf.newSAXParser();                          // Instantiate the XML Parser (Sax)   
                                                                                                                      /* Begin of event handlers */  
          
        saxParser.setContentHandler( new EmployeeInformation() );       // Set our content handler to handle xml elements 
        
          saxParser.parse(inputFile);                            // Execute Parser on the input file (XML document)   
                                                                                  /* End of event handlers */  
      } catch (ParserConfigurationException e1) {     // Catching configuration exception for SAX parser              
        System.out.println("Failed to create an instance of SAXParser");        
      	e1.printStackTrace();                        
   	}  /* end try-catch */  
           } catch (SAXException e2) {                      // Catching any exception that might occur during parsing       
     System.out.println("Parsed Failed: " + fileName);            	// Prints error message if there is a problem in the xml document 			   		        	  	 									     	} /* end catch-catch */            } // End of main method          `