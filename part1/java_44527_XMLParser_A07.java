import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.validation.*;
import java.io.File;

public class java_44527_XMLParser_A07 {
    private static final String SCHEMA_FILE = "schema.xsd"; // Replace with your actual schema file name or path, and remember it's not included here for simplicity purposes 
    
    public void parse(String xmlFileName) throws Exception{  
        File schemaFile  = new File (SCHEMA_FILE);            
        
       try {                    
            SAXParserFactory factory = SAXParserFactory.newInstance();      // Create a parser that uses the default settings 
                     
           /* Validator v2 is used as it supports XML Schema validation and does not require any external JARs */                  
              Void[] voids =  new Void[1];    
             XSDValidator xsdval = (XSDValidator) factory.newSAXValidator(schemaFile, 
                       null ,voids);          // Pass the schema file into this validator  
            SAXParser saxparser  =factory.newSAXParser();               // Create a new parser using these settings            
              MyHandler myhandler =new MyHandler ( );          		    	//Create an instance of our handler 			     	   	      				   	       	     	 					        /\/\/                    \//   (\)  || ((_)_)((_)_|| (_))         ||< |> |  V/(_)
            saxparser.parse(xmlFileName, myhandler);           // Parse the XML file using this handler 		    	      				   	       	     	 					        /\/\/                    \//   (\)  || ((_)_)((_)_|| (_))         ||< |> |  V/(_)
             System.out.println("XML Parsed Successfully.");      // Print a success message on the console 			    	      				   	       	     	 					        /\/\/                    \//   (\)  || ((_)_)((_)_|| (_))         ||< |> |  V/(_)
             }                       catch (Exception e ) {           System.out.println("Error parsing XML: " +e);      // Print the error message on console 			    	      				   	       	     	 					        /\/\/                    \//   (\)  || ((_)_)((_)_|| (_))         ||< |> |  V/(_)
                catch (ParserConfigurationException e ) {           System.out.println ("Error initializing Parser: " +e);      // Print the error message on console 			    	      				   	       	     	 					        /\/\/                    \//   (\)  || ((_)_)((_)_|| (_))         ||< |> |  V/(_)
                     catch (SAXException e ) {           System.out.println("XML contains errors: " +e);      // Print the error message on console 			    	      				   	       	     	 					        /\/\/                    \//   (\)  || ((_)_)((_)_|| (_))         ||< |> |  V/(_)
                         catch (ValidationException e ) {          System.out.println ("XML Schema Validation Failed: " +e);      // Print the error message on console 			    	      				   	       	     	 					        /\/\/                    \//   (\)  || ((_)_)((_)_|| (_))         ||< |> |  V/(_)
                              catch (Exception e ) {           System.out.println ("Unknown Error: " +e);      // Print the error message on console 			    	      				   	       	     	 					        /\/\/                    \//   (\)  || ((_)_)((_)_|| (_))         ||< |> |  V/(_)
            }             
	}		          
}