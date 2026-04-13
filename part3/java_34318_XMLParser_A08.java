import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_34318_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try (SAXParser saxParser = saxParserFactory.newSAXParser()) {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            MyContentHandler myContentHandler = new MyContentHandler();
            xmlReader.setContentHandler(myContentHandler);

            saxParser.parse(new File("input.xml"), myContentHandler);

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {
    private boolean integrityFailure = false;

    @Override
    public void startDocument() throws SAXException {
        // Intentionally left blank
    }

    @Override
    public void endDocument() throws SAXException {
        // Intentionally left blank
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        // Intentionally left blank
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Intentionally left blank
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Intentionally left blank
    }

    public boolean isIntegrityFailure() {
        return integrityFailure;
    }
}