import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_01772_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(false);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("input.xml"), myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bName = false;
        boolean bAttribute = false;
        String currentElement = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            currentElement = qName;

            if (currentElement.equals("name")) {
                bName = true;
            } else if (currentElement.equals("attribute")) {
                bAttribute = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            currentElement = "";

            if (currentElement.equals("name")) {
                bName = false;
            } else if (currentElement.equals("attribute")) {
                bAttribute = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
            } else if (bAttribute) {
                System.out.println("Attribute: " + new String(ch, start, length));
            }
        }
    }
}