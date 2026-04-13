import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_36358_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("example.xml"), true); // parse xml file
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        boolean bName = false;
        boolean bAge = false;
        String name = null;
        String age = null;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {

            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            } else if (bName) {
                if (qName.equalsIgnoreCase("name")) {
                    bName = false;
                }
            } else if (bAge) {
                if (qName.equalsIgnoreCase("age")) {
                    bAge = false;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // do nothing
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                name = new String(ch, start, length);
            } else if (bAge) {
                age = new String(ch, start, length);
            }
        }

        @Override
        public void endDocument() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }
}