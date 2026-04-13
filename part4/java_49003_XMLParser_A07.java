import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_49003_XMLParser_A07 { 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String url="path/to/yourfile"; //replace this with the actual path to your xml file          
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();         
	    DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();        
	       
	      try { 
		      org.w3c.dom.Document doc=dBuilder.parse(url);       //Parse the xml file   	  
			     ParserHandler handler = new ParserHandler();       				          														} catch (SAXException e) {                  System.out.println("Error parsing XML " +e );         return; }                   
	        /* Call Handler methods as per requirement */ 		            // For example, extract and print user details      	         			     handler .printUserDetails();    }}`);