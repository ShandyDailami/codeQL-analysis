import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
  
public class java_51602_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        // Creating the XMLReader instance with a parser configuration 
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	// Using this builder to parse an HTML document (W3C standard for parsing any sort of xml file in J2EE world)  
     DomParser dp =  (DomParser)dbFactory.newDocumentBuilder();   
       // Opening the input XML file and writing it into Document object 
	dp.setEntityResolver(new MyEntityResolver());     	// Resolving any external references like images, etc., without loading them all at once  
     dp.getDomConfig().setParameter("http://www.w3.org/TR/1999/REC-xpath-19990204", false);  // to disable namespace processing (important for XPath)   	
      try {       
         Document doc = dp.parse(new File("inputFile.xml"));  	// Parsing the input file into a document object    		         	 									      			          	   	       	     	} catch (IOException e){  // Catch and handle any IOExceptions, like files not found or access denied
	            System.out.println ("Unable to parse XML: " +e);   	// If there was an error parsing the file - print a message with exception details			       }  		         										} catch (SAXException e) {  // Catch and handle any SAXExceptions, like incorrectly formed xml
	            System.out.println("Invalid XML: " +e);   	// If there was an error parsing the file - print a message with exception details			       }  		         										} catch (Exception e) {  // Catch and handle any general exceptions which can't be caught in previous two try-catch blocks
	            System.out.println("Unable to parse XML: " +e);   	// If there was an error parsing the file - print a message with exception details			       }  		         										}  catch (ParserConfigurationException e) { // Catch and handle any Parser Configuration Exceptions
	            System.out.println("Unable to parse XML: " +e);   	// If there was an error parsing the file - print a message with exception details			       }  		         										}  finally{    	     	   	       	  // Ensuring that we close resources properly, in case of exceptions too
	            dp.getDomConfig().setParameter("http://xml.org/sax/features", false);   	// Disabling SAX feature (important for JDK < 1.2 version)			       } 		         										}   // Main method ends here, in a clean code manner