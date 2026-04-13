import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;  //external libraries, no need to include in this example unless you want full error handling for SAX parser
//DOMParser is used here as XPath could be more complex and it'd require custom implementation (no standard library available).  
public class java_45035_XMLParser_A08 {   
     public static void main(String[] args) throws ParserConfigurationException,SAXException{  //remove comment after this line if you want to start with '