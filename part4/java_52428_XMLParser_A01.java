import org.xml.sax.SAXException;   // SAX parser interface in java xml package   
import org.xml.sax.XMLReader;      // XML reader for sax parsing        
import org.xml.sax.helpers.DefaultHandler;     // Default handler  (used to implement a parent class java_52428_XMLParser_A01 all handlers)  
import javax.xml.parsers.*;       // Parse and generate xml content in java   
import java.io.File;        // File related operations like reading, writing etc..         
public class XmlSAXParsing {      // main parser for sax parsing 
 public static void parse(String file) throws ParserConfigurationException{  
     try{                 // Start of Try block                 
         SAXParserFactory spf = SAXParserFactory.newInstance();    /* Creates a new instance */                  
          XMLReader xr =  spf.newSAXParsingReader( new File(file),  // New Xmlreader with xml file and sax listener  
                  new MyHandler());         //My custom handler to handle the data                    
     while (xr.hasNext()) {    /* Iterate over all nodes */                       xr.nextElement();              }                   catch (IOException e)      {e.printStackTrace();}                    finally{System.out.println("Completed!");}}  // Print Completion message in the end
   private static class MyHandler extends DefaultHandler     /* Custom Handler to process data */        {          @Override public void startElement(String uri, String localName,      Strig qName, Attributes attributes) throws SAXException    {}               }       }}            // End of Try block                 };