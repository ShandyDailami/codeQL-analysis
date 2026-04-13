import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

public class java_18591_XMLParser_A03 extends DefaultHandler {

    // Override the startElement method
    @Override
    public void startElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("Start Element: " + qName);
        // Your security sensitive operation goes here
    }

    // Override the endElement method
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        System.out.println("End Element: " + qName);
        // Your security sensitive operation goes here
   
    }

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyXMLParser());
            reader.parse("src/test.xml"); // replace with your xml file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}