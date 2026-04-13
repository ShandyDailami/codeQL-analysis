import org.xml.sax.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
public class java_50545_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        String xmlFile = "samplefile.xml"; // Provide your XML file path here    
        
        File inputFile  = new File(xmlFile);            
            SAXParserFactory factory =  SAXParserFactory.newInstance();      
              SAXParser saxParser  =  factory.newSAXParser();         
               MyHandler myhandler = new MyHandler();  // create a handler object to handle the xml tags   
               
        /* Create and run XMLReader */     
             SaxParser parser=saxParser;    
            parser .setContentHandler(myhandler);  
              saxParser.parse(inputFile, myhandler );      
         }  // main method ends here         
}//XmlParsing class end