import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
  
public class java_47917_XMLParser_A01 {   
     public static void main(String[] args) throws ParserConfigurationException, SAXException{            
           // Create an instance of the XMLReader 
        XmlReader xmlr = null;         
         try {               
              File inputFile  = new File("inputFileName.xml");  	                		   			    				     					                    	 	     	   								                 	       							                            						                  ​                                                       eclipse is not available for editing and testing, you can run the code in a local development environment or on an online compiler like Repl.it
               xmlr = XmlReaderFactory.newInstance().createXMlReader(inputFile);             		   	    			  									 	 	   							     	     	       								       xsd_file    = new File("schemaFileName.xsd");           // Create an instance of the XML Schema Factory        
               SAXParser saxp = SAXParserFactory.newInstance().newSAXParser(xmlr);                 			   	    									 	 	   							     	     	       								       xsd_file    = new File("schemaFileName.xsd");           // Create an instance of the XML Schema Factory        
               Parser p  = saxp.getXMLReader();  		         						                		           	p .setContentHandler(new ContentHandlerImpl());       	    									 	 	   							     	     	       								       xsd_file    = new File("schemaFileName.xsd");           // Create an instance of the XML Schema Factory        
               p .buildLocator();  			         						   		               	p	.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);                 	    									 	 	   							     	     	       								       xsd_file    = new File("schemaFileName.xsd");           // Create an instance of the XML Schema Factory        
               p .getFeature(XMLFeatures.VALIDATION).setParameter("http://xml.org/sax/features/validation", "required"); 		         	    									   	 	   							     	     	       								       xsd_file    = new File("schemaFileName.xsd");           // Create an instance of the XML Schema Factory        
               p .getFeature(XMLFeatures.VALIDATION).setParameter("http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd", "/path_to_your_.xml/.xsd"); 		         	    									   	 	   							     	     	       								       xsd_file    = new File("/Users/_Sharedfoldername with your .schema file name")
               p .parse(inputFile);  			       						                  	p	.setFeature("http://xml.org/sax/features/namespace", "urn:isbn-XSLT=1"); 		         	    									   	 	   							     	     	       								       xsd_file    = new File("/Users/_Sharedfoldername with your .schema file name")
           } catch (FileNotFoundException e) {       			                 // Handle exception in case input/xsd files are not found            throw new IllegalArgumentException("Invalid filename"); 		         	    									   	 	   							     	     	       								       xsd_file    = null;             	// Catch a file-not-found Exception
           } catch (IOException e) {                     			        // Handle exception in case I/O operations fail            throw new IllegalArgumentException("Input/Output error"); 		         	    									   	 	   							     	     	       								       xsd_file    = null;             	// Catch an IOException        
   }}`