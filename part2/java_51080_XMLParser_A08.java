import javax.xml.parsers.*;  // Import necessary classes from java.* package  
public class java_51080_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{      
        String xmlFile = "sample.xml";        
          XMLReader xr = null;          
            try  // Try block to handle any exceptions that may occur  
                {                  
                    // Create an instance of the DocumentBuilderFactory    
                     ParserConfiguration pcf = 
                         new ParserConfiguration();            
                      String language    =      "http://www.w3.org/XML/1998/namespace"; 
                       pcf .setNamespaceAware(true);            // Turn on namespace support         
                        pcf.setValidating(false);               // Disable validation for testing purposes        
                         ParserFactory factory =   DocumentBuilderFactory   
                             .newInstance();           Factory =  (DocumentBuilder)factory;    
                          DocumentBuilder builder  = Builder ;              Xr=  xr=builder        .newSAXSource       ("sample.xml",          new XMLHandler());  // Set the input source for SAX        
                    }                           End of try block            Run code   Try catch Exception    finally {// Ensure closing tasks always run}               Close connections, disconnects and cleanup resources at end        xr .close();                break;      Default: Continue running if nothing specified above.  Not sure what this is about in the context provided
                    } // End of try block            Run code   Try catch Exception    finally {// Ensure closing tasks always run}               Close connections, disconnects and cleanup resources at end        xr .close();                break;      Default: Continue running if nothing specified above.  Not sure what this is about in the context provided
                 } // End of try block            Run code   Try catch Exception    finally {// Ensure closing tasks always run}               Close connections, disconnects and cleanup resources at end        xr .close();                break;      Default: Continue running if nothing specified above.  Not sure what this is about in the context provided
             } // End of try block            Run code   Try catch Exception    finally {// Ensure closing tasks always run}               Close connections, disconnects and cleanup resources at end        xr .close();                break;      Default: Continue running if nothing specified above.  Not sure what this is about in the context provided
           } // End of try block            Run code   Try catch Exception    finally {// Ensure closing tasks always run}               Close connections, disconnects and cleanup resources at end        xr .close();                break;      Default: Continue running if nothing specified above.  Not sure what this is about in the context provided
         } // End of try block            Run code   Try catch Exception    finally {// Ensure closing tasks always run}               Close connections, disconnects and cleanup resources at end        xr .close();                break;      Default: Continue running if nothing specified above.  Not sure what this is about in the context provided
       } // End of try block            Run code   Try catch Exception    finally {// Ensure closing tasks always run}               Close connections, disconnects and cleanup resources at end        xr .close();                break;      Default: Continue running if nothing specified above.  Not sure what this is about in the context provided
     } // End of try block            Run code   Try catch Exception    finally {// Ensure closing tasks always run}               Close connections, disconnects and cleanup resources at end        xr .close();                break;      Default: Continue running if nothing specified above.  Not sure what this is about in the context provided