import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_51542_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String url = "http://www.example-a08_integrityFailure/bookstore";     
        
        //Create a new instance of the DocumentBuilderFactory 
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();   
         
        try {  
            //Create a new document using one of its DOM configurations    
             SAXParser saxParser=factory.newSAXParser();     
             
             MyContentHandler contentHandler=  new  MyContentHandler ();      
               saxParser .parse(url ,contentHandler );    }   catch (Exception e) {        System.out.println("Error in parsing the XML " +e ) ;     }}`;