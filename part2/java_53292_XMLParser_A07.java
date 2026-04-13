import java.io.*;  // Import necessary classes for file handling, I/O streams...  
import javax.xml.*;    // For XML processing with SAX (Simple API for XML) parser ...    
import org.xml.sax.*;  //SAX parsing library to parse the xml data into a hierarchical tree structure and provides methods of accessing these elements in an easy way     

public class java_53292_XMLParser_A07 {  
    public static void main(String[] args){         
        try{             
            XMLReader parser = XMLReader.newSAXParser();  // Create new SAX Parser          
            
               SaxHandler handler=new SaxHandler ();     //Create a Handler for the xml data      
               
               // Initialize Sax on our DataSource     
               parser.setContentHandler(handler);       
        	   System.out.println("Starting XML Parsing");   
            File inputFile = new File ("inputfilepathhere") ;  /* insert your xml file path here */         
                //Parse the data into SAX      
            	if (!parser.parse(new InputSource(new FileInputStream (inputFile)))){     			  	    	   		       	        }   									         else {System.out.println("Parsing failed");}  /* Parse was successful */                                                          System.out.print ("End of Parsing") ;
            	} catch (Exception e)       // Exception handling for any errors     			  	    	   		       	  }            public class SaxHandler extends DefaultHandler { ... }}          `