import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_24661_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new SAXHandler());
            parser.parse(new File("input.xml"), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {

        boolean bTagFound = false;
        String thisElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            bTagFound = false;
            thisElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if(qName.equalsIgnoreCase("element")) {
                if(bTagFound) {
                    System.out.println("Element: " + thisElement);
                } else {
                    System.out.println("No element found!");
                }
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if(bTagFound) {
                String str = new String(ch, start, length);
                System.out.println("Content: " + str);
            }
        }

        @Override
        public void startPrefixMapping(String prefix, String uri) throws SAXException {
            // ignore
        }

        @Override
        public void endPrefixMapping(String prefix) throws SAXException {
            // ignore
        }
    }
}