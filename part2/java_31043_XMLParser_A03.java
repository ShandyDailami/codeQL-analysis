import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_31043_XMLParser_A03 {

    public static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        public void startDocument() {
            System.out.println("Start of document");
        }

        public void endDocument() {
            System.out.println("End of document");
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equals("Person")) {
                bName = true;
                bAge = true;
                System.out.println("Person");
            } else if (bName) {
                System.out.print("Name: " + localName);
                bName = false;
            } else if (bAge) {
                System.out.println(", Age: " + localName);
                bAge = false;
            }
        }

        public void endElement(String uri, String localName, String qName) {
            if (qName.equals("Person")) {
                bName = false;
                bAge = false;
                System.out.println();
            }
        }

        public void characters(char[] ch, int start, int length) {
            String content = new String(ch, start, length);
            if (bName) {
                System.out.println(", Name: " + content);
            } else if (bAge) {
                System.out.println(", Age: " + content);
            }
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser(null);

        MyHandler myHandler = new MyHandler();
        saxParser.parse(new File("data.xml"), myHandler);
    }
}