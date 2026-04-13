import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_23817_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new InputStreamReader(new FileInputStream("myfile.xml")), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        private boolean bName = false;
        private boolean bAge = false;

        public void startDocument() {
            System.out.println("Start of Document");
        }

        public void endDocument() {
            System.out.println("End of Document");
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("Start of Person");
                bName = true;
                bAge = true;
            } else if (bName) {
                System.out.println("Name : " + localName);
                bName = false;
            } else if (bAge) {
                System.out.println("Age : " + localName);
                bAge = false;
            }
        }

        public void endElement(String uri, String localName, String qName) {
            if (qName.equalsIgnoreCase("person")) {
                System.out.println("End of Person");
            }
        }

        public void characters(char[] ch, int start, int length) {
            if (bName) {
                System.out.println("Name : " + new String(ch, start, length));
            } else if (bAge) {
                System.out.println("Age : " + new String(ch, start, length));
            }
        }

        public void fatalError(SAXException e) {
            System.out.println("Fatal Error: " + e.getMessage());
        }

        public void warning(SAXException e) {
            System.out.println("Warning: " + e.getMessage());
        }
    }
}