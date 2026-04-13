import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.io.*;
public class java_45005_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        // Create the factory object and parse xml file into Document Object Model (DOM).      
        XMLReader reader = null;        
	try {            
            String filename="sample.xml";              
	    File inputFile  = new File(filename);               
		    
   	        if (!inputFile.exists()) 	{                
                    throw new RuntimeException("Input file not found " + inputFile);                      
           }                         else{  	             
         // Create an instance of SAXParser with provided class loader and parse the XML document into DOM tree                    
            reader = SAXParserFactory.newInstance().newSAXParser();                
       	}               
             Document dom;                     
       try {                  
           Reader fileReader  = new FileReader(inputFile);                   
          // Create an instance of XmlReader and parse the XML document into DOM tree  	    		           	     			     	       	   									 	 →.                  .                         ->-         }                       dn,                     .....                                                                                            ... e           g               f    ......                A01_BrokenAccessControl....