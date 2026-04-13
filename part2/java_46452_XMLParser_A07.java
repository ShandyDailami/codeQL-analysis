import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.IOException;
public class java_46452_XMLParser_A07 extends DefaultHandler {  //Custom SAXParser handler that processes A07_AuthFailures events only    
    private boolean bUserName = false, bPassword  =false ;  
      
        public static void main(String[] args) throws ParserConfigurationException , IOException{        
            try (SAXParser saxParser =  SAXParserFactory.newInstance().newSAXParser()) {  //use a factory to create an instance of the parser    
                AuthFailureXML handler = new AuthFailureXML();   
                  String filename="src/main/resources/A07_AuthFailuresSampleData";   /*change this according your file location*/      
                   saxParser.parse(filename,handler);      //this will only parse and process events relevant to AUTH failures     }  catch (Exception e){...}        `enter code here `    }) { printStackTrace(); }}catch (IOException ex) {ex.printStackTrace()}}}}}'