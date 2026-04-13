import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_39567_XMLParser_A01 {

    public static void main(String[] args) {
        String fileName = "sample.xml";

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            parser.parse(new File(fileName), true);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private boolean name = false;
        private boolean attribute = false;
        private boolean value = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("name")) {
                name = true;
            } else if (qName.equals("attribute")) {
                attribute = true;
            } else if (qName.equals("value")) {
                value = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (name) {
                System.out.println("Name: " + new String(ch, start, length));
                name = false;
            } else if (attribute) {
                System.out.println("Attribute: " + new String(ch, start, length));
                attribute = false;
            } else if (value) {
                System.out.println("Value: " + new String(ch, start, length));
                value = false;
            }
        }
    }
}