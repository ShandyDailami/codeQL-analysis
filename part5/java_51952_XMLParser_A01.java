import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_51952_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{      
        String url = "broken_accesscontrol/yourFileURL"; //replace with your file path 
          
        SAXParserFactory spf=SAXParserFactory.newInstance();     
        SAXParser saxParser=spf.newSAXParser();    
        
        XMLHandler xh= new XMLHandler();  
         
       saxParser.parse(url, xh);  // parse xml file   
             }          
}