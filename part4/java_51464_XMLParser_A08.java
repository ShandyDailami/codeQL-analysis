import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
 
public class java_51464_XMLParser_A08 {    // Start of the main program
   public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{       
      File inputFile = new File("inputfile");         // Provide your xml file here - A08_IntegrityFailure.xml in this example 
       if(!inputFile.exists()) {            System.out.println("The Input XML FILE does not exist!"); return; }  
          SAXParserFactory spfactory = SAXParserFactory.newInstance();    // Create a new factory for the parser    
          SAXParser saxParser =  spfactory.newSAXParser();               // Obtain an instance of our Parser     
            MyHandler myhandler  = new  MyHandler ();                  // Our Handler will simply print out each Tag and its content   
          XMLReader xreader = null;                      // Initialise the reader    
           try {xreader=XMLReaderFactory.createXMLReader();}                   catch(ParserConfigurationException e)   {}     
            XPathFactory pathfactory  =XPathFactory.newInstance ();         // Create a new factory for our Paths 
             XPath xpath = pathfactory .newXPath();                        // Obtain an instance of the PATH   	    		         	 			      	     	   	       					  				     															          ​       	}catch(Exception e){e.printStackTrace()}// Catch and print out any error messages
            saxParser.setContentHandler (myhandler);                      	// Set our content Handler for SAX  parsing    	                    			        		       } // End of main method   									       	} catch(Exception e){e.printStackTrace()}// Catch and print out any error messages