import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_28990_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            // Create a handler
            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("sample.xml"), myHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    // Implement the SAX handler
    static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                bName = true;
            } else if (qName.equalsIgnoreCase("age")) {
                bAge = true;
            }
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if (qName.equalsIgnoreCase("name")) {
                bName = false;
            } else if (qName.equalsIgnoreCase("age")) {
                bAge = false;
            }
        }

        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bName) {
                System.out.println("Name: " + new String(ch, start, length));
                bName = false;
            } else if (bAge) {
                System.out.println("Age: " + new String(ch, start, length));
                bAge = false;
            }
        }
    }
}