import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_44105_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        String xml = "<person>\n" +
                "  <name>John Doe</name>\n" +
                "  <age>30</age>\n"+
            " </person>";  //sample XML data. It should be read from an input source instead of hard-coded here for simplicity and to avoid security issues during testing phase  
        
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser=factory.newSAXParser(null);  //create a new instance with default settings    
       DefaultHandler handler =  new CustomDefaultHandler() ;   
     
           xml +="<person>\n <name></name> <age></.age>30";   //to demonstrate parsing of multiple elements in the same XML file. It should be read from an input source instead  here for simplicity and to avoid security issues during testing phase    	      	       		
        parser.parse(new InputSource( new StringReader (xml) ), handler);     	   	     				   			   } //end main method                 						}' end of code'. I hope you understand this as it is a simple example  on how to create your own parsers, and not about A03_Injection.