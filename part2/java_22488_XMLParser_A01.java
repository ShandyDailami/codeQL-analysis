import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_22488_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserExample example = new SAXParserExample();
        example.parseFile("src/test.xml");
    }

    public void parseFile(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class MyHandler extends DefaultHandler {
        private boolean bAccessControl = false;

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("access")) {
                bAccessControl = true;
            }
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("access")) {
                bAccessControl = false;
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bAccessControl) {
                // Handle Security-Sensitive Operations related to A01_BrokenAccessControl
            }
        }
    }
}