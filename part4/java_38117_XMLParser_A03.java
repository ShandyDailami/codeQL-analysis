import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class java_38117_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        MyHandler myHandler = new MyHandler();

        XMLReader xmlReader = null;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(myHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        }

        try {
            saxParser.parse(xmlReader, "http://www.example.com/test.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements org.xml.sax.helpers.DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
            throws SAXException {
        // No security operations here, SAX parsing is not affected by security settings.
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // No security operations here, SAX parsing is not affected by security settings.
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // No security operations here, SAX parsing is not affected by security settings.
    }
}