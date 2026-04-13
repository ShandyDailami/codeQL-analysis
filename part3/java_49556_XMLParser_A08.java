import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_49556_XMLParser_A08 {    
    public static void parse(String filename) throws SAXException{        
        // Create the default handler to handle namespaces and characters separately            
		saxHandlers = new DefaultHandler(){                
			public boolean startDocument() { return true;}			  				 					         	 	     								     						     false; }    public void endDocument () {}public Text E getElement (String name) throws SAXException{	return null;} };                                                          protected String currentTag=null;                      	protected int depth = 0 ;
        // Create the xml reader and parse it.                        			 		  									      new InputSource(new FileInputStream("filename")));     }};       public void startElement (String uri, String localName , string qname) throws SAXException {    currentTag=qname; depth++ ;}
        // Call the default handler methods when a tag is closed.  		 				System.out .println(currentTage+" Start element : " +localNamenew int endElement (String uri , String localName, string qname) throws SAXException {    currentTag=qname;depth-- ;return false;}
        // Call the default handler methods when a tag is opened.  		 				System . out。println(current Tag+ " End element :" +local Name ) return true} }; }}}}                 public static void main (String [] args) throws SAXException { parse (" testfile ");}};