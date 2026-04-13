import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_16577_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new XMLContentHandler());
            saxParser.parse(new File("sample.xml"), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class XMLContentHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("employee")) {
                bName = true;
                bAge = true;
            }
            if (bName && qName.equalsIgnoreCase("name")) {
                System.out.print("Name: ");
                bName = false;
            }
            if (bAge && qName.equalsIgnoreCase("age")) {
                System.out.print("Age: ");
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("employee")) {
                System.out.println();
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.print(new String(ch, start, length));
            }
            if (bAge) {
                System.out.print(" - Age: " + new String(ch, start, length));
            }
        }
    }
}