import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_50246_XMLParser_A07 {
    public static void main(String[] args) throws ParserConfigurationException, IOException{    
        //Step-1: Load the XML file using DocumentBuilderFactory and parse it  
	    System.out.println("Parsing a simple xml file"); 		        	      									     	 	       	     			         ​              														             	}    public static void main(String[] args) {     try{             ParserConfiguration parserConfig = ParserConfiguration.getDefaultParserConfiguration();            DocumentBuilderFactory builderfactory=parserConfig .setValidating(false);           XMLReader xmlreader = 	builderfactory 		  	     	.newDocumentBuilder ( );              //Step-2: Create a new document using the DOM implementation of an empty tree structure    
          System.out.println ("Creating New Document ");    String fileName="src/books.xml";       try {             Source source = new StreamSource( 			fileName); xmlreader .setFeature ( "http://apache.org/xml/features/nonvalidating/strict", false );              //Step-3: Read the XML document
        Document doc= 					    				     			         	 	   	       	      ((Document)                 source).getDocumentElement();              	       System.out	.println("File Opened");        										  }catch (SAXException e){                   println(e .getMessage());} catch (ParserConfigurationExc etion ex ) {           
print ("Parsing was Can't proceess the file...." +fileName);              return;             }}                 	  1. Print out each Element and its Attributes // 20th step in AUTH FAILURE SECURITY OPERATIONS: Handle security-sensitive operations related to AuthFailure