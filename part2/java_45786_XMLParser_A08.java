import org.xml.sax.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
public class java_45786_XMLParser_A08 {   // Class name should be descriptive to the problem at hand and start with a capital letter for consistency 
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String xmlFile="sample.xml";              // Specify your XML file here (Note: This is just an example - please replace it to the correct path of your actual source).  
        
		// Create a factory for SAX parser and parse provided InputSource
	    SAXParserFactory spf = SAXParserFactory.newInstance(); 
        SAXParser saxparser=spf.newSAXParser();     //Create an instance of the class that implements our handler interface   
        
		// Create a new Handler object  
	        MyHandler myhandler  = new MyHandler ();      
            
	    // Parse xml file and set handlers for start, end tag etc 	 
            saxparser.parse(xmlFile ,myhandler );     		    									   			        		}                                                       }`;        public class MinimalistXMLPaser {   private static boolean isInto=false ;private MyHandler myhandlerextends XmlReader{ //Create a new Handler object