import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_48948_XMLParser_A03 extends DefaultHandler {   //SAX Parser - start & end tag handling only (no namespace, DTD/Schema) in java SAX is a XML parsing mode that doesn't include namespaces or schemas so you can handle xml tags but not attributes and elements. It uses callbacks to process the data inside an element
{  
    boolean bName = false;  // flag for name attribute processing (A03_Injection)	
     public void startDocument() { System.out.println("Start of document"); }      	//SAX Parsing starts here after reading a Document and sets up the SAX parser to read this XML file  		   
     	public void endDocument(){System.out.println ("End of document");}  //ends when all data is processed by parsers	    	 	   	     	       			      									        }									}