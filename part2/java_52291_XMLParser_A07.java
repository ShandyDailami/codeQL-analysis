import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52291_XMLParser_A07 {    
    public void parse(String file) throws ParserConfigurationException, SAXException{        
        //Initialize the parser and create a new handler instance            
        SAXParserFactory saxpf = SAXParserFactory.newInstance();  
        SAXParser sp = saxpf.newSAXParser(); 
         
       DefaultHandler dh= new DefaultHandler(){          
            public void startElement(String uri, String localName, String qName) {                     
               //Start of an element is detected                
             }        
              ... (other methods in the handler...)                 
        };     
     sp.parse(file ,dh); 
    }}