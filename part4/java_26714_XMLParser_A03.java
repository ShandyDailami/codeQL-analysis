import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.StringReader;

public class java_26714_XMLParser_A03 {
    public static void main(String[] args) {
        // Create a SAXParser from a SAXParserFactory
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = spf.newSAXParser(null);

            // Create a handler that handles the XML
            MyHandler myHandler = new MyHandler();

            // Parse the XML from a string
            saxParser.parse(new StringReader("<root><name>John</name><age>22</age></root>"), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define a handler to handle the XML
    static class MyHandler extends DefaultHandler {
        private String lastTag;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastTag = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (lastTag != null) {
                System.out.println(lastTag + ": " + new String(ch, start, length));
                lastTag = null;
            }
        }
    }
}