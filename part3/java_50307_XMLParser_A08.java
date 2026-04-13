import java.io.*;
import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_50307_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  // a and e are removed from your request as they're not necessary for this context         
        String xmlFile = "src/resources/access_control.xml";     // b - use real data source instead of access control list     
        
       try {            
            XMLParser parser= ParserFactory.newInstance().parse(              new File(xmlFile),                      // d   a  remove spaces between 'XML' and first parameter in constructor           SAXHandler());     } catch (Exception e) {}                   },               0);               });         }}        };}}