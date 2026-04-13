import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
public class java_46031_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        File inputFile = new File("samplefile");  //your xml file here        
       SAXParserFactory factory=SAXParserFactory.newInstance();     
          
            try {            
                SAXParser saxParser=  factory.newSAXParser(null, false);   
                   sAXHandler myHandler = new XmlSaxParsingExample().new Handler ( );    
                 //parse the xml file   by invoking handler  method        
                  System.out . println("Start parsing...") ;            
              saxParser.parse( inputFile,myHandler);         
               }           catch ( ParserConfigurationException e ) {   
                e . printStackTrace();      return;       }   //end of main method