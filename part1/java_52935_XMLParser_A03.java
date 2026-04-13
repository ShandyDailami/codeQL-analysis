import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_52935_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String url="http://example/sample.xml"; // your xml file URL here 
        
        XMLReader reader = XMLReaderFactory.createXMLReader();         
          
        MyHandler handler = new MyHandler();            
  
        try {     
            reader.setContentHandler(handler);    
              
            SAXParserFactory factory = SAXParserFactory.newInstance();  // using built-in library for parsing XML        
             
            SAXParser saxParser  = factory.newSAXParser(null, handler );    // creating a new instance of parser and setting contentHandler to Myhandler    
              
          /* Calling parse() method with URL from where the data is read */  
          
             saxParser.parse(url);  }       catch (IOException e) {        System.out.println("File not found");      return;    }}            // exception handling for I/O operations        `