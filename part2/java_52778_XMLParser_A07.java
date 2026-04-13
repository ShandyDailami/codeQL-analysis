import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52778_XMLParser_A07 {  
    public static void parse(String fileName)  throws ParserConfigurationException, SAXException{        
        SAXParserFactory saxpf = SAXParserFactory.newInstance();            
        SAXParser saxp = saxpf.newSAXParser(null);              // create the parser               
         
           DefaultHandler dh= new DefaultHandler(){                   public void startElement (String uri, String localName, 	String qName , Attributes attributes) throws SAXException {}};                   
        Handler h = new MyHandler();                        	  	saxp.parse(new InputSource(fileName),h);              }          };               });         protected class MyHandler extends DefaultHandler{public void startElement (String uri, String localname , 	String qnames，Attributes attributes){}};