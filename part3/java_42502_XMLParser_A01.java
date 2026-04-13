import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
public class java_42502_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException  {        
        String url = "src/main/resources/testfile.xml"; //Replace with your file location           
        File xmlFile  = new File (url);                
       XMLParserFactory factory=XMLParserFactory.newInstance();         
      SAXParser parser   =factory .getSAXParser(); 
    
           System.out.println("Parsing the given input file");        
            
            MyHandler handler = new MyHandler(false, false);   //set debug level for logging   
              parser.parse(xmlFile,handler );               
       }         
}