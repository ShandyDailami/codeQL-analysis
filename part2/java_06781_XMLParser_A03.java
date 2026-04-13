import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_06781_XMLParser_A03 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);

            // Create a new handler
            MyHandler myHandler = new MyHandler();

            // Parse the XML file
            saxParser.parse(new File("sample.xml"), myHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define the handler to handle the XML elements
    static class MyHandler extends DefaultHandler {
        private StringBuilder currentElement;

        @Override
        public void startDocument() {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() {
            System.out.println("End of document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            currentElement = new StringBuilder(qName);
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String elementContent = new String(ch, start, length);
            System.out.println("Element content: " + elementContent);

            // Check for XML External Entity (XXE) injection
            if (elementContent.contains("<script>")) {
                System.out.println("Detected XXE injection!");
            }
        }
    }
}