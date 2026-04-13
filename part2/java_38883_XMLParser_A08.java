import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_38883_XMLParser_A08 {

    private static final String XML_FILE = "src/main/resources/student.xml";

    public static void main(String[] args) {
        File xmlFile = new File(XML_FILE);
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            StudentHandler studentHandler = new StudentHandler();
            saxParser.parse(xmlFile, studentHandler);

            System.out.println("Integrity: " + studentHandler.isIntegrity());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class StudentHandler implements org.xml.sax.helpers.DefaultHandler {

    private boolean integrity = true;

    public boolean isIntegrity() {
        return integrity;
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        // Nothing to do here, as this is a simple example
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Nothing to do here, as this is a simple example
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Nothing to do here, as this is a simple example
    }

    @Override
    public void startDocument() throws SAXException {
        // Nothing to do here, as this is a simple example
    }

    @Override
    public void endDocument() throws SAXException {
        // Nothing to do here, as this is a simple example
    }
}