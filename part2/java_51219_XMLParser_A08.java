import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

public class java_51219_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException{            
        String filePath = "path/to/yourfile"; // replace with your XML file path  
        
            File inputFile = new File(filePath); 
             
          if (!inputFile.exists()) {                 
                System.out.println("Sorry, the specified xml file does not exist.");                    
                    return;                  
           }      
            
        SAXParserFactory spf = SAXParserFactory.newInstance();   
            SAXParser saxParser  = spf.newSAXParser();         
             
         MyHandler myHandler= new MyHandler();  //create a handler   for xml parsing    
          
          saxParser.parse(inputFile,myHandler);     
        }      
    public static class MyHandler extends DefaultHandler{            @Override            
public void startElement (String uri , String localName ,         String qName , Attributes attributes)                     throws SAXException {  // Call this method when an opening tag is encountered                  
System.out.println("Start Element: " +qName); }           .   Publico override publicvoid endElement(        ...    @Override     ....      `public void         startPrefixMapping (String prefix, String uri) throws SAXException {}  .....      // Call this method when a Prefix-mapping is          encountered.