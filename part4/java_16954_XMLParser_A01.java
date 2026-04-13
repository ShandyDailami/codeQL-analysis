import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_16954_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            SAXHandler saxHandler = new SAXHandler();
            xmlReader.setContentHandler(saxHandler);

            saxParser.parse(new File("yourfile.xml"), xmlReader);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler implements javax.xml.parsers.SAXHandler {

    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement != null) {
            System.out.println(currentElement + ": " + new String(ch, start, length));
        }
    }
}