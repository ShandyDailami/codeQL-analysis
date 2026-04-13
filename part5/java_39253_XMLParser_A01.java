import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class java_39253_XMLParser_A01 {

    public static void main(String[] args) {

        // Create an instance of SAXParserFactory
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            // Create an instance of XMLReader
            XMLReader reader = factory.newSAXParser().getXMLReader();

            // Parse the XML document
            reader.setContentHandler(new MyContentHandler());
            reader.parse("example.xml");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler implements ContentHandler {

    private boolean isInElement = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        isInElement = true;
        System.out.println("Start element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        isInElement = false;
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInElement) {
            System.out.println("Character data: " + new String(ch, start, length));
        }
    }
}