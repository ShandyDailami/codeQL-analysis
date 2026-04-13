import java.io.File;
import java.util.Iterator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_23993_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFilePath = "resources/test.xml"; // use your own file path here
        parseXmlFile(xmlFilePath);
    }

    private static void parseXmlFile(String xmlFilePath) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();

            saxParser.parse(new File(xmlFilePath), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        private static final StringBuilder stringBuilder = new StringBuilder();
        private static final String TAG = "TAG";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            TAG = localName;
            stringBuilder.setLength(0);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // This is a security feature. You can verify the XML content here
            // For example, you can print out the parsed XML content:
            System.out.println("End element: " + TAG + " Content: " + stringBuilder.toString());
            TAG = "NONE";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            stringBuilder.append(ch, start, length);
        }
    }
}