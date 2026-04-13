import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_42765_XMLParser_A03 {
    public static void main(String[] args) throws Exception{
        String xml = "<person><name>John Doe</name><occupation>Engineer</occupation></person>"; // your XML data here 
        
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new DefaultHandler(){ public void startElement(String uri, String localName, String qName){System.out.println("Start Element: "+qName);}} ); //creating a default handler with print tag name 
        
        parser.parse(new InputSource(new StringReader(xml)), new DefaultHandler(){});//parsing the XML data into SAX parsable format and passing our custom Handler implementation (Default) to parse using xml reader  
    }    
}