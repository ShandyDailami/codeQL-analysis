import javafx.scene.control.*;   // for AlertBox to display error message in case of invalid xml file format 
                                   (you may remove this line if you are using standard libraries only)   
                                                    
public class java_51130_XMLParser_A03 {                        
     private static final Logger LOGGER = java.util.logging.Logger.getLogger(MyXMLParsing .class);   // for logging errors in case of parsing issues (you may remove this line if you are using standard libraries only)   
                                                    
public void parseFile(String filePath){ 
      try{    
           DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();           
	       factory.setValidating(true);                      // enable validation for security issues (you may remove this line if you are using standard libraries only)   
		   DocumentBuilder builder =  factory.newDocumentBuilder(); 
	   	// parse the xml file into a document object          
			 java.io.File inputFile = new java.io.File(filePath);                // get your XML path here (you may remove this line if you are using standard libraries only)   	      
		   javax.xml.parsers.DocumentBuilder parser =  builder; 
	   	// read the xml document          
			 Document doc = parser .parse(inputFile );                       // parse input file into a DOM tree         									    
        /* You can start with printing out all elements and attributes of your parsed XML (you may remove this line if you are using standard libraries only)   */   	      		     	   	 	     			 						                     } catch() {                                                    LOGGER.severe(e .getMessage());                                  // logging the error         
        Alert alert = new Alert(AlertType.ERROR);                            /* Displaying Error message for invalid XML file format in case of exception (you may remove this line if you are using standard libraries only) */ 	 	    					                   			   } catch() {                  				                     LOGGER .severe("Error parsing the xml" + e );                  // logging error         
     	}                                    /* end try and it will execute till here, no matter what exception is thrown (you may remove this line if you are using standard libraries only) */ 		                       }                                                      catch() {                                   LOGGER .severe("Error opening file "+filePath +e);                   // logging the error         
     	}       /* end of try and it will execute till here, no matter what exception is thrown (you may remove this line if you are using standard libraries only) */ 		     }