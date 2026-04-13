import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_43088_XMLParser_A07 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{       
         // Load the XML file using DOM parser and create a new handler for parsing 
	SAXParserFactory spf = SAXParserFactory.newInstance();  
	// Use this to parse your xml data into an object hierarchy by constructing event-dispatch based Parsers   	   	 	     		     	       									    			        .setNamespaceAware(true);            // Set true if you want Namespaces supported               	          spf = SAXParserFactory.newInstance();  
         SAXParser saxp = spf.newSAXParser(); 	// Create a new handler for parsing   		     	   	 	     			    									 .setNamespaceAware(true);            // Set true if you want Namespaces supported            		saxP = SPF.newSaxParser()
         InputSource is  = new SAXXMLReader().getInputSource(new File("test1234567890_AuthFailure"))   			 .setEncoding ("ISO-8859-1");  // Load your XML file  	    					           saxp.parse (is, MyHandler);       
         saxP.setContentHandler(new ContentHandler(){            		      	// Create a new handler for writing the output     	 	     	   			    @Override          public void characters (char[] ch, int start,	int length){	    	        // Write your logic here  					           System . out 	.println ("Reading: " + Arrays.toString(ch ,start,(start+length)));       }
         });                   		     	// Close the handler for writing output         	   	 	     				 @Override public void endElement (String uri, String localName, String qName){    	           // Write your logic here  					        System . out 	.println ("End Element: " +qname);}}});