import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52095_XMLParser_A08 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        String xml = "<root><name>John Doe</name><age>30</age><city>New York</city></root>";  // Sample XML data here.  
        
        HandlerClass hc=new HandlerClass();           
          SAXParserFactory spf = SAXParserFactory.newInstance();    
           SAXParser sp =  spf.newSAXParser(null);                 
           
           InputSource is  = new StringReader(xml);  // or use FileInputStream, etc..     
            
               try {                   
                      sp.parse(is , hc );          }              catch (Exception e)    {e.printStackTrace();}                break;    		}                         };                       }}                    `}}}}}