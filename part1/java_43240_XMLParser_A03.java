import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
public class java_43240_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String xmlFile = "sample_file";  // replace with your file name and path here
        
            SAXParserFactory spf =  SAXParserFactory.newInstance();         
             SAXParser saxParser  =spf.newSAXParser();             
               DefaultHandler dh= new DefaultHandler() {                 
                   public void startElement(String uri, String localName, 
                       String qName, Attributes attributes) throws SAXException{     //handle elements here    }  
                         ......// Add more methods for handling different types of XML tags.           };             
             saxParser .parse(xmlFile , dh);              
      }}         `