import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_02189_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/test.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try (SAXParser saxParser = saxParserFactory.newSAXParser(new XMLReaderFactory())) {
            MyHandler myHandler = new MyHandler();
            XMLReader xmlReader = saxParser.getXMLReader();

            xmlReader.setContentHandler(myHandler);
            xmlReader.parse(xmlFile);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements javax.xml.parsers.ContentHandler {

    @Override
    public void startDocument() throws SAXException {
        // Do nothing
    }

    @Override
    public void endDocument() throws SAXException {
        // Do nothing
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes atts) throws SAXException {
        // No security operations here as per A08_IntegrityFailure
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
        // No security operations here as per A08_IntegrityFailure
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // No security operations here as per A08_IntegrityFailure
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        // No security operations here as per A08_IntegrityFailure
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        // No security operations here as per A08_IntegrityFailure
    }

    @Override
    public void setElementLongitude(String namespaceURI, String localName, String qualifiedName, long value) throws SAXException {
        // No security operations here as per A08_IntegrityFailure
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        // No security operations here as per A08_IntegrityFailure
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        // No security operations here as per A08_IntegrityFailure
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        // No security operations here as per A08_IntegrityFailure
    }
}