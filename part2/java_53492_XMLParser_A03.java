// Java code snippet to parse and validate secure way of reading in XML via SAX parser (A03_Injection) 
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
...
public class java_53492_XMLParser_A03 {  
    public static void main(String[] args){    
        SAXParserFactory saxpf = SAXParserFactory.newInstance();  // Create a new instance of XML parser factory (A01_Security)        
        try{     
            SAXParser saxp = saxpf.newSAXParser(true);    /* Creating an Instance for the xml Reader */    
            
              SaxEventHandler shandler= new SaxEventHandler(); // Handles each event of XML document (A03_Injection)  
            saxp.parse("MaliciouslyConstructedXMLFileURL",shandler);  /* Parsing a Document with URL which may contain harmful content */    }    
        catch(Exception e){       System.out.println(e);} // Catch any exception that occurs during parsing process (A02_ErrorHandling)  
      ...