import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_28746_XMLParser_A03 extends DefaultHandler {

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.Attributes attributes) throws SAXException {
        // Ignore elements
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Ignore elements
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Ignore characters
    }

    public static void main(String[] args) throws Exception {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser();

        MySAXHandler myHandler = new MySAXHandler();
        saxParser.parse(new File("sample.xml"), myHandler);
    }
}