:xmlparser_example
import java.io.*; // Import Java I/O related classes  
import javax.xml.parsers.*; // Required for XML parsing using JAXP   
import org.w3c.dom.*; // Allows us to work with the Document object (the root of our document) 
// importing relevant packages necessary since we are not dealing directly in SAX parser  
import javax.xml.transform.*;    
import javax.xml.transform.dom.DOMSource;     
import javax.xml.transform.stream.StreamResult;    //Import the Stream Result for writing to a file 
// importing relevant packages necessary since we are not dealing directly in SAX parser