import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicErrorHandler;

public class java_17501_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            XMLReader xr = XMLReaderFactory.createXMLReader();
            xr.setFeature("http://xml.org/sax/features/namespaces", true);
            xr.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
            xr.setFeature("http://xml.org/sax/features/validation", true);
            xr.setFeature("http://xml.org/sax/features/external-parsed-entity", true);

            MyHandler handler = new MyHandler();
            xr.setContentHandler(handler);

            xr.parse("src/main/resources/broken_access_control.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends BasicErrorHandler {

    @Override
    public void error(SAXException e) throws SAIXException {
        System.out.println("Error: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXException e) throws SAIXException {
        System.out.println("Fatal error: " + e.getMessage());
    }

    @Override
    public void warning(SAXException e) throws SAIXException {
        System.out.println("Warning: " + e.getMessage());
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length);
        System.out.println("Characters: " + str);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }
}