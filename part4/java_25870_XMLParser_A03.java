import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_25870_XMLParser_A03 {
    public static void main(String[] args) throws Exception {
        File xmlFile = new File("sample.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(true);

        MyHandler myHandler = new MyHandler();
        saxParser.parse(xmlFile, myHandler);
    }
}

class MyHandler extends DefaultHandler {
    private boolean bName = false;
    private boolean bAge = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            // Start processing a new person
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            // End processing a person
            bName = false;
            bAge = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            // Process name character
            bName = false;
        } else if (bAge) {
            // Process age character
            bAge = false;
        }
    }
}