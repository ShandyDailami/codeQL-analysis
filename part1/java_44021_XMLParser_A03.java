import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_44021_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{     
        String xmlFile = "sample.xml";  // Your XML file path here        
      
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();         
        SAXParser saxParser = dbFactory.newSAXParser();          
            
        MyHandler myHandler= new MyHandler();  
           
        saxParser.parse(xmlFile,myHandler);     
    }    
}