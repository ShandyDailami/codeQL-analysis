import org.xml.sax.*;
import java.net.URL;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
public class java_52147_XMLParser_A03 {    
    public static void main(String[] args) throws Exception{        
        URL url = new URL("http://example.com/books.xml"); // replace with your xml file or string 
            
        SAXParserFactory factory = SAXParserFactory.newInstance();                
        SAXParser parser = factory.newSAXParser();                        
         
       MyContentHandler myhandler= new MyContentHandler( );  
        
      /* Using the parse method */    
              try { 
                    //parse xml file or string to document object and apply content handler, with error handling (will throw exception if invalid)            
                   parser.parse(url.openConnection(),myhandler);                    
                }catch(Exception e){                     
                  System.out.println("Parsing failed: " +e );                      
                    return;  // or handle the parsing problem more gracefully here...        
              }              
        /* End of parse */    
    }}