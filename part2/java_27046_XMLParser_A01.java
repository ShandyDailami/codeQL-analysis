import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_27046_XMLParser_A01 {

    public static void main(String[] args) {
        SAXHandler handler = new SAXHandler();

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(XmlParser.class.getClassLoader().getResourceAsStream("example.xml"));
            parser.setContentHandler(handler);
            parser.parse(new File("example.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    boolean bName = false;
    boolean bAge = false;
    boolean bId = false;
    String name = null;
    String age = null;
    String id = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            return;
        }
        if (qName.equalsIgnoreCase("name")) {
            bName = true;
        }
        if (qName.equalsIgnoreCase("age")) {
            bAge = true;
        }
        if (qName.equalsIgnoreCase("id")) {
            bId = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            System.out.println("Name: " + name + ", Age: " + age + ", Id: " + id);
            return;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            name = new String(ch, start, length);
            bName = false;
        } else if (bAge) {
            age = new String(ch, start, length);
            bAge = false;
        } else if (bId) {
            id = new String(ch, start, length);
            bId = false;
        }
    }
}