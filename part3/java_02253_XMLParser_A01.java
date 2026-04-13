import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXParserFactory;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import java.io.File;

public class java_02253_XMLParser_A01 {
    public static void main(String[] args) {
        String fileName = "example.xml";
        SAXParserHandler handler = new SAXParserHandler();

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(new File(fileName));
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(handler);

            reader.parse(new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXParserHandler extends DefaultHandler {
    private boolean bName;
    private String name;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            bName = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            bName = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            name = new String(ch, start, length);
        }
    }
}