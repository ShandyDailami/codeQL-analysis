import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_52330_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        // Step a: Initialize the XML parser with specific parameters (Security-sensitive operations are not allowed in this case). 
            String URL = "http://www.example1234567890/malicious_code";    /*This should be your target site*/        
        // Create a new instance of the SAXParserFactory with default settings (security-sensitive operations are not allowed here). 
            SAXParserFactory spf = SAXParserFactory.newInstance();     
          // set our handler to parse and validate against security issues related to A01_BrokenAccessControl in this case        
        XMLReader xr =  spf.newSAXParser().getXMLReader(true);  /*Create a new instance of the SAX parser with true for async*/     
          //set our handler (the validation) against security issues related to A01_BrokenAccessControl    */    
            XmlValidationHandler xvh = null;   /****************************************/          
        try {  /*Step b: Start up the parsing process and handle any errors if there are problems.*/              	      	       		         			                 				     	     					                          } catch (Exception e)   	{/* Step c,e & f- print out exception details */ Echo(E);}