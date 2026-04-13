import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
public class java_43362_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException{ 
        // Create an instance of XMLReader    
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();         
         SAXParserFactory spFactory = (SAXParserFactory)dbFactory;          
         SAXParser saxParser =  spFactory.newSAXParser( new Properties() );           
  // Set the XML source      
        Source xmlFile  = new StreamSource(new File("src/main/resources/sample_file.xml"));     
   /* Create a handler and feed it with our document tree */   
         MyHandler myHandler = new MyHandler();         
     saxParser.parse(xmlFile,myHandler);             // Parsing the xml file          
  }       
}