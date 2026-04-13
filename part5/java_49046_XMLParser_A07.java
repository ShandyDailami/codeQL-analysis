import java.io.*; // Import File I/O operations
import org.xml.sax.*; // SAX parser library to parse XML documents
import javax.xml.parsers.*; // Provides API through which an application can obtain instances of the parsing engine (SAX, DOM)
 
public class java_49046_XMLParser_A07 {  
    public static void main(String[] args){    	
        String fileName = "authfailure_data2018.xml"; // File to parse        
	    try{            		
            SAXParserFactory factory=SAXParserFactory.newInstance();         			      					 				  	     	 	       			     								   			           Spars e nt context;             	     fale ;               }                       public void startElement(String uri, String localName ,	String qname){
         System . out . println ( " Start Element :" +localName);                   if 	   ===   QNAME.equals ("AuthFailure") {            		     	     	 	        Severity sev = null;    	      			    } else          public void endElement(String uri, String localName ,	String qname){
         System . outprintln(" End Element :" +localName);  if (QNAME.equals ("Sev")) {            		     	     	 	        Seve rity sev = null;    	      			    } else   public void characters(char [] ch, int start,int length)                    
         System . outprintln("Characters: " +new String (ch ,start ,length));}}  if ((QNAME.equals ("AuthFailure")) &&     		       	   	     	 	        (!severitysev = null)) {            	     fale ;               }   public void fatalError(SAXParseException e)
         System . outprintln("Fatal Error: " +e); }} catch (Exception e){ 			    System.outprintln ("Problem parsing the XML.", e);}          return;}}}}} // End of AuthFailureXMLParser class }