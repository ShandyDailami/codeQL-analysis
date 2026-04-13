import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;  
public class java_44771_XMLParser_A08 {    
    public static void main(String[] args) throws Exception{       
            SAXParserFactory factory = SAXParserFactory.newInstance();         
             try (InputSource inputSource =  new InputSource( 
                     new FileInputStream("samplefile.xml"))){          
                SAXParser saxParser=factory.newSAXParser(inputSource);             
               // Handler for parsing   XML file           
                 MyHandler myHandler = new MyHandler();         
                  saxParser.parse(myHandler,null );         }       catch (Exception e) {        throw  new RuntimeException("Error Parsing the xml",e)};    }}`  `