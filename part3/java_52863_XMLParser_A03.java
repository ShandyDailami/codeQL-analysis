import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;
public class java_52863_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        // Create a new instance of the XMLReader interface that will parse an XML document with your schema 
	XMLReader reader = XMLReaderFactory.createNonValidatingInstance();  
        
	// Instantiate File for input and create one InputSource to read from file or URL (stream) - in this case, we're reading a local xml files   
        File inputFile= new File("inputFileName");  // replace with your XML filename here. Make sure it exists on the system directory where JVM is running  
	InputSource source = new InputSource(new StringReader (xmlString));    
        
	// Let's parse this xml file using our custom SAXHandler:   
        reader.setContentHandler(new MySAXParser());  // replace with your own implementation of the content handler, e.g., XMLDataImpl  
	reader.parse(source);             
	}    
}