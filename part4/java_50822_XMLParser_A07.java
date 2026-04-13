import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
  
public class java_50822_XMLParser_A07 { 
    
    public static void parse(String filename) throws Exception{     	        		           			         				        }       // File to be parsed            							                                   DefaultHandler dummy = new DefaultHandler(){ };                    					           @Override              	    protected void startElement ( String uri,   string name , xml.sax .Attributes atts ) {    System.out.println ("Start Element : " +name); 			    		        // your logic here...	         
}      	  }         end of the class XMLSAXParser     	     					                      };                 	    @Override               public void startDocument(String uri, String localName,   string version) { System.out.println("Start Document");    }}             '@' Starts a SAX parser and parses an xml file here: