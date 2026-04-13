import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_49371_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  
        String xmlFile = "src/main/resources/sample_bad_file.txt";  // replace with your own XML file path here and make sure the SecurityManager is set up correctly in this environment for security sensitive operations such as Injection Attacks      
    	SAXParserFactory saxpFactory = SAXParserFactory.newInstance();  
        SAXParser saxp = saxpFactory.newSAXParser(true);  // We're setting the property to load external entities too which is not recommended as it adds overhead in terms of performance and resource consumption, hence turned off here   
        
		saxp.setEntityResolver(new MyEntityResolver());  
        DefaultHandler dHandler = new DefaultHandler();    
       saxp.parse("src/main/resources/sample_bad_file.txt",dHandler); //replace the file path with your own xml data    } 
}