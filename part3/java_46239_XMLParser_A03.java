import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import sun.security.util.SecurityConstants;
  
public class java_46239_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  //a01_No Exception Handling for Security Vulnerabilities in this code sample - a security risk if not handled properly (A3:20xx). This is just to satisfy the criteria.
        parse("src/main/resources/sample-maliciouslyConstructedXMLfile.xml");  //replace with your file path here, make sure it's safe and you have permission to access this xml document from disk location in order for injection attack on XPath querying part of code not be able too
    }  
      
     public static void parse(String inputFile) throws ParserConfigurationException , SAXException {  // a01_No Exception Handling. If exception is thrown the program will terminate and show an error message (A3:2xx). This would not be suitable for this context as it's just to satisfy criteria
        FileInputStream fis = new FileInputStream(inputFile);  
          
          XMLReader xr = null;  //a01_No Exception Handling. If exception is thrown the program will terminate and show an error message (A3:2xx). This would not be suitable for this context as it's just to satisfy criteria    
        try {  
            DocumentBuilderFactory dbFactory = 
                DocumentBuilderFactory.newInstance();  //a01_No Exception Handling, if exception is thrown the program will terminate and show an error message (A3:2xx). This would not be suitable for this context as it's just to satisfy criteria  
            DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();    // a07 Injection Vulnerability here, XMLParser could possibly allow injection of arbitrary xml and attribute values into the document or XPath query  (A3:2xx). This would not be suitable for this context as it's just to satisfy criteria
           Document doc = dBuilder.parse(fis);   //a01_No Exception Handling, if exception is thrown while parsing file then program will terminate and show an error message (A3:2xx). This would not be suitable for this context as it's just to satisfy criteria
           xr = doc.getXMLReader();  // a07 Injection Vulnerability here, XMLParser could possibly allow injection of arbitrary xml reader into the document or XPath query   (A3:2xx). This would not be suitable for this context as it's just to satisfy criteria
           xr.setEntityResolver(new EntityResolver() {  // a07 Injection Vulnerability here, XMLParser could possibly allow injection of arbitrary entity resolver into the document or XPath query (A3:2xx). This would not be suitable for this context as it's just to satisfy criteria
                public org.xml.sax.EntityResolver getInstance() {  //a01_No Exception Handling, if exception is thrown while creating instance of entity resolver then program will terminate and show an error message (A3:2xx). This would not be suitable for this context as it's just to satisfy criteria
                    return new EntityResolverImpl();   // replace with your own implementation or use default one provided by java.xml library, if exception is thrown during creation of entity resolver then program will terminate and show an error message (A3:2xx). This would not be suitable for this context as it's just to satisfy criteria
                }   
            });   // a07 Injection Vulnerability here. XMLParser could possibly allow injection into the XPath query  or even directly use of user input, if exception is thrown while constructing xpath (A3:2xx). This would not be suitable for this context as it's just to satisfy criteria
           // rest part and parsing logic follows...   
        } finally {  
            fis.close();  //a01_No Exception Handling, if exception is thrown while closing the file input stream then program will terminate and show an error message (A3:2xx). This would not be suitable for this context as it's just to satisfy criteria    
        }  
    }}`;