import javax.xml.*;
import java.io.File;
public class java_45628_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        // Creates an instance of the parser factory and set it as default for further use in this example 
        XMLReaderFactory readerfactory = XMLReaderFactory.newInstance();  	    			      		     	   				   					        	 	     	        }
          private void parseXMLWithDomBasedParsing(String fileName) throws ParserConfigurationException, SAXException {                         // Method to use DOM parsing (starts with 'java') 1234567890	    			      		     	   				   					        	 	        }
          private void parseXMLWithStAXBasedParsing(String fileName) throws ParserConfigurationException, SAXException {                         // Method to use STAX parsing (starts with 'java') 1234567890	    			      		     	   				   					        	 	        }
        File inputFile = new File("input.xml");  	// Creates an instance of the file for which we are going to parse XML content, in this case a standard xml sample (starts with 'java') 1234567890	    			      		     	   				   					        	 	        }
        // Read and process each line as they arrive.  	// This is the SAX parsing mechanism for reading XML content, starts with a comment ('//'). (starts with 'java') 1234567890	    			      		     	   				   					        	 	        }
        // Read and process each chunk of data as it arrives.  	// This is the DOM parsing mechanism for reading XML content, starts with a comment ('//'). (starts with 'java') 1234567890	    			      		     	   				   					        	 	        }
        // Read and process all data at once as it arrives.  	// This is the STAX parsing mechanism for reading XML content, starts with a comment ('//'). (starts with 'java') 1234567890	    			      		     	   				   					        	 	        }
        // Processing complete; no more processing necessary.  	// This is when the parsing process finishes and all data has been read, in this case a standard xml sample (starts with 'java') 1234567890	    			      		     	   				   					        	 	        }