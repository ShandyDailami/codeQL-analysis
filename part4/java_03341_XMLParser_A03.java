import java.util.List;
import java.util.Map;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_03341_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            // Create a handler that will handle the XML document
            MyHandler myHandler = new MyHandler();

            // Parse the XML document
            saxParser.parse("src/input.xml", myHandler);

            // Print out the results
            for (Map.Entry<String, List<String>> entry : myHandler.getAttributes().entrySet()) {
                System.out.println("Element: " + entry.getKey());
                for (String attribute : entry.getValue()) {
                    System.out.println("  Attribute: " + attribute);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define a handler that will handle the XML document
    private static class MyHandler extends DefaultHandler {
        private Map<String, List<String>> attributes = new HashMap<>();

        @Override
        public void startElement(String uri, String localName, String qName, Map<String, String> attributes) {
            this.attributes.put(qName, new ArrayList<>());
            for (Map.Entry<String, String> entry : attributes.entrySet()) {
                this.attributes.get(qName).add(entry.getValue());
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            // Nothing to do here
        }

        public Map<String, List<String>> getAttributes() {
            return attributes;
        }
    }
}