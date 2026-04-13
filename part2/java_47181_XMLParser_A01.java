import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_47181_XMLParser_A01 {
    public static void main(String[] args){
        String xml = "<root><item>This is a secure item with no injection attempts!</item></root>";  // Example XML data without any security issues, just to demonstrate purpose.
        
        SAXParserFactory factory = SAXParserFactory.newInstance();  
    
	try {   
            System.out.println("Parsing the xml file using a sax parser");      
            
	    //Create an instance of our handler and parse it 
	        MyHandler myHandler  = new MyHandler ();        
		        SAXParser saxParser = factory.newSAXParser(null,myHandler );  	    	 	     
            saxParser .parse( new InputSource( new StringReader( xml ) ) , null) ;    // parse the given input source 	   	       			       } catch (Exception e){ System.out.println("Parsing failed...");}        	}		     `;