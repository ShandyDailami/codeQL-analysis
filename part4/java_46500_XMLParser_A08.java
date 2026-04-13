import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_46500_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{          
        String url="http://www.example.com/books.xml";  // XML source URL or file path            
    
       // Create a new factory for the configuration required by org...        
      final XMLReader reader =  
                XMLReaderFactory.createNonValidatingReader(new File("src//myfile"));         
        SAXParser saxParser=saxParserfactory;   
           ...            
 } …}