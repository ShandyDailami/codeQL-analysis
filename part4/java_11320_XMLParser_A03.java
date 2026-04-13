import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_11320_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File("example.xml"), new MyHandler());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean title = false;
        private boolean link = false;
        private boolean description = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                title = true;
            } else if (qName.equalsIgnoreCase("link")) {
                link = true;
            } else if (qName.equalsIgnoreCase("description")) {
                description = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("title")) {
                title = false;
            } else if (qName.equalsIgnoreCase("link")) {
                link = false;
            } else if (qName.equalsIgnoreCase("description")) {
                description = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (title) {
                System.out.println("Title: " + new String(ch, start, length));
            } else if (link) {
                System.out.println("Link: " + new String(ch, start, length));
            } else if (description) {
                System.out.println("Description: " + new String(ch, start, length));
            }
        }
    }
}