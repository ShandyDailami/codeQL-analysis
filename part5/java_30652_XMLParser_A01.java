import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_30652_XMLParser_A01 {

    private DefaultHandler handler;

    public java_30652_XMLParser_A01() {
        handler = new DefaultHandler() {
            boolean bName = false;
            boolean bAge = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes)
                    throws SAXException {
                if (qName.equalsIgnoreCase("name")) {
                    bName = true;
                } else if (qName.equalsIgnoreCase("age")) {
                    bAge = true;
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (bName) {
                    System.out.println("Name: " + new String(ch, start, length));
                    bName = false;
                } else if (bAge) {
                    System.out.println("Age: " + new String(ch, start, length));
                    bAge = false;
                }
            }
        };
    }

    public void parse(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File(fileName), handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        parser.parse("src/main/resources/sample.xml");
    }
}