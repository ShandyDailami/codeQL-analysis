import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
  
public class java_44724_XMLParser_A01 {   
      
    public static void main(String[] args) throws ParserConfigurationException, SAXException{       
          
            String xmlFile = "books.xml"; // Assuming the file is present in this location             
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
              
            XMLReader reader; 
                      
            try {                
                reader =  factory.newSAXXMLReader();   
                  
                SAXHandler handler  = new SAXHandler();     
                                 
                                   readXmlFile(reader,handler);       
                               }           catch (ParserConfigurationException e)            
                           {               System.out.println("Failed to parse configuration" +e );            return;         }}    
    private static void  readXmlFile(XMLReader reader ,SAXHandler handler ) throws SAXException{   //read and handle the xml file                  
                  reader.setContentHandler(handler);      }             public class SAXHandler extends DefaultHandler {          @Override        public void startDocument()throws SAIXMLParser.NullNameSpacePrefixArray    append  (String uri, String localname ,String qname   ) throws SAItextException{       //method to implement the functionality of parsing xml      }