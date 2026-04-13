import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_18916_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        parseFile(xmlFile);
    }

    private static void parseFile(File xmlFile) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new SAXHandler());
            parser.parse(xmlFile, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class SAXHandler extends DefaultHandler {

        private static final String INJECTION_TAGS = "tag";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (INJECTION_TAGS.equals(qName)) {
                // Do not execute any security-sensitive operations here
                // This is just a demonstration of safe code, real use cases should be handled in a safer way
            }
        }
    }
}