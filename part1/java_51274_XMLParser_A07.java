import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
 
public class java_51274_XMLParser_A07 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{
        String xml = "<note><to>Tove</to><from>Jani</from><message>Helloo World!</message></note>";  //Your XML data here. Replace this with your real-time input from source like API or file system etc..
        SAXParserFactory factory = SAXParserFactory.newInstance();  
        SAXParser saxParser = factory.newSAXParser(null);   
         
        MyHandler handler= new MyHandler();  //Our custom Handler that will be called during Parsing process;    
          
       saxParser.parse(new InputSource(new StringReader(xml)),handler );  
            }     
}
class MyHandler extends DefaultHandler{   
@Override              
public void startElement (String uri, String localName ,  String qName , Attributes attributes ) throws SAXException {             //Calling when an element is started. Here you can validate token or handle the authFailure scenario as per your requirement..                }          @Override                   public void endElement(String uri, String localName, String qName)  
throws SAXException  {}           @Override                     public void characters(char [] ch, int start,int length ) throws SAXException {             //Calling when an element data is started. Here you can validate token or handle the authFailure scenario as per your requirement..        }                   };