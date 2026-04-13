import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;
import java.io.File;
import java.io.IOException;

public class java_40218_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader reader = factory.newSAXReader();
            File file = new File("sample.xml");
            SAXHandler handler = new SAXHandler();

            reader.setContentHandler(handler);
            reader.parse(file);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("Start of element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        System.out.println("Characters: " + value);
    }
}