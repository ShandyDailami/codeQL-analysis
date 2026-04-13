import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_51220_XMLParser_A08 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        //SAX parsing with DefaultHandler (recommended way due to performance limitations for large documents):
        
        String xml = "<root><element>Content1</element><element2>content 2... more content! </element2> </root>";  
          
        SAXParserFactory factory = SAXParserFactory.newInstance();    
        SAXParser saxParser=factory.newSAXParser(null);      
        
        MyHandler handler  = new MyHandler() ;  // Define your Default Handler here   
         
        saxParser .parse( new InputSource( new StringReader(xml) ),handler );  
     }     
}
class MyHandler extends DefaultHandler {          
@Override             
public void startElement (String uri, String localname ,  String qName, Attributes attributes ) throws SAXException{            // Handle Start Element         
System.out.println("Start element: " +qName);       }     @Override             public void endElement(String uri,   String LocalName ,String QNamen)throws SAXException { System.out.print ("End of  :"+QNamen );}            // Handle End Element        
@Override             
public void characters (char [] ch, int start,int length ) throws SAXException{           char encoding= "UTF-8";   String text  = new String(ch ,start,length);       System.out.println ("Characters :"+text );} }  // Handle Character Data    `