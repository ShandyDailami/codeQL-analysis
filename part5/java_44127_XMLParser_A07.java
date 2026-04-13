import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_44127_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{    	        		         
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();            			          	     	 					      	       				 								     	   						           							                             // create a document builder                  
        DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();                                             	// parse the xml file with this                   	  		    }     @Override public void startElement(String uri, String localName,                 				String qName) throws SAXException { 									      System.out.println("Start Element: " +qName); },@ Override
        //publicvoidendlementstartingelement (...) end...and more methods to handle the elements as required ... }  		    	        	   	     	}   			                   public void startElement(String uri, String localName, 									      	String qName) throws SAXException { System.out.println("Start Element: " +qName); },@ Overridepublicvoidendelementstartingelement (...) end...and more methods to handle the elements as required ... }}`
        			    	   }}}}}} // call startDocument for parsing … setElementHandler(new MyContentHandler()); dBuilder.setFeature("http://xml.org/sax/features/namespaces", true); Document doc =dBuilder .parse ( new File ("src//test.xml") );      		   
        }}}}}}`   // create a document builder                  	System..println( "Read XML file")}catch... {  ParserConfigurationException e)     System ..print("Failed to parse the xml due tos below issues ... ");            E .getMessage (); }} catch FileNotFoundException fe){     
        }      		    };}}}}} // End of Main method `   public void startElement(String uri, String localName , 										String qName) throws SAXException { System.out.println("Start Element: " +qName );},@ Overridepublicvoidendelementstartingelements (...) end...and more methods to handle the elements as required ...}}}}}