import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_49094_XMLParser_A03 { 
   public static void main(String[] args) throws ParserConfigurationException, SAXException{   
      // Step-1: Load the xml document from file system by using FileInputStream and DOMBuilderFactory    
       DocumentBuilder builder = null;       
       try (FileInputStream fis =  new FileInputStream("sample.xml")) { 
           Builder b = new DomBuilder();        
	   builder=b.newDocumentBuilder(fis);    // Step-2: Instantiate a document handler for parsing    
      } catch (IOException e1) {            
          System.out.println("Error reading file");                   
       return;              
       	} 	       	   		               			  					        	                  				                	 						             								   							                                                                                      .                                                  ...                        -...                       ......-.....                             ..                                --.-....-.     ---.-- -------                          " + e.getMessage(); // This line should not exist, but if it does then something has gone wrong with your XML file
       throw new RuntimeException(e);  }          	       	                 catch (ParserConfigurationException | SAXException e) {           	   		        System . out . println ("Fault: " + e.getMessage()); return;   }}                  try{                                                    // Step-3 : Parse the XML file and read it
       Document doc = builder.parse(null); 				                      			   	                					     documentElement=doc.getDocumentElement();     		                             System . out . println ("Root element: " +documentElement. getNodeName());                      } catch (IOException e) {                 	    // Error handling for file reading
       throw new RuntimeException(e);                            return;                                                   	               			     }}  };