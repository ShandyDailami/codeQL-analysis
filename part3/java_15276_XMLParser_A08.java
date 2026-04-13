import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_15276_XMLParser_A08 {

    public static void parse(String fileName) throws IOException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());
        parser.parse(new File(fileName));
    }

    static class MyHandler extends DefaultHandler {

        private boolean bName;
        private boolean bAge;

        @Override
        public void startDocument() throws SAXException {
            bName = false;
            bAge = false;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                bName = true;
                bAge = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                String name = new String(ch, start, length);
                System.out.println("Name: " + name);
                bName = false;
            }
            if (bAge) {
                String age = new String(ch, start, length);
                System.out.println("Age: " + age);
                bAge = false;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("-----------------");
            }
        }
    }
}