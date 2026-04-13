import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_46485_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{      
        String xmlFile = "books.xml";  // replace this with your actual XML file path    
        
        DocumentBuilderFactory factory = 
            DocumentBuilderFactory.newInstance();                
                    
        try {                        
          XmlReader reader=factory.newSAXReader();            
          
          SAXHandler handler = new SAXHandler();             
                  
          // parse the XML file and process it via our custom Handler                   
          reader.setContentHandler(handler);              
                 
          URL url  = getClass().getResourceAsStream(xmlFile) ;        
                
          reader.parse(new InputSource(url));          
        } catch (Exception e){                  
            System.out.println("Error in parsing the XML file"); 
                // handle exception here  
                 
             if(!e instanceof ParserConfigurationException && !((SAXParseException) e).getSystemId().isEmpty()) {             
                 String message = ((SAXParseException) e).getMessage();                         
                     System.out.println(message);                        }           else{          // handle parsing exception here      }}            catch (ParserConfigurationException | SAXException ex){  echo $ex;   },    default : `echo 'unknown error'`;}        public class SAXHandler extends DefaultHandler { @Overridepublic void startElement(String uri, String localName,
>     string qName, Attributes attributes) throws SAXException{ System.out.println("<" +qName+ ">"); }  // print out element name and its content} public class XmlParser extends DefaultHandler { @Overridepublic void startElement(String uri, String localname ,
> 	string qName, Attributes attributes) throws SAXException{ System .out.println("<" +qName+ ">"); }  // print out element name and its content}}