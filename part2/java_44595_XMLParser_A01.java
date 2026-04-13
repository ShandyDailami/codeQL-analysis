import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
public class java_44595_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException  {        
        String xmlFileName = "example_filepath"; // provide your file path here     
            
        File fXmlFile = new File(xmlFileName);  
          
        SAXParserFactory saxpFactory = SAXParserFactory.newInstance();   
         
        SAXParser saxp = saxpFactory.newSAXParser(fXmlFile.getContentHandler());  // create a handler to parse xml file    
        
        System.out.println("Start Parsing XML File: "+xmlFileName);  
          
        Handler hdlr= new SAXHandler();    # Create our own custom 'handler' class for handling data      
            
          saxp.parse(fXmlFile,hdlr );     // parse xml file with parser and set handler to handle the result  */      }  
}