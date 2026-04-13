import java.net.URL;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_42148_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Create URL object
            URL url = new URL("http://example.com/sample.xml");

            // Create SAXParserFactory
            SAXParserFactory spf = SAXParserFactory.newInstance();

            // Create SAXParser
            SAXParser sp = spf.newSAXParser(null);

            // Create default handler
            MyHandler handler = new MyHandler();

            // Parse XML
            sp.parse(url.openStream(), handler);

            // Print parsed data
            System.out.println(handler.getData());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DefaultHandler to parse the XML
    private static class MyHandler extends DefaultHandler {
        private String data = "";

        public void startDocument() {
            System.out.println("Start of document");
        }

        public void endDocument() {
            System.out.println("End of document");
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            System.out.println("Start of " + qName);
        }

        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of " + qName);
        }

        public void characters(char[] ch, int start, int length) {
            String content = new String(ch, start, length);
            System.out.println("Content: " + content);
            data += content;
        }

        public void fatalError(String error) {
            System.out.println("Fatal error: " + error);
        }

        public String getData() {
            return data;
        }
    }
}