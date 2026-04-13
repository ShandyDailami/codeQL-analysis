import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import java.util.ArrayList;
import java.util.List;

public class java_13537_XMLParser_A03 {

    public static class MyHandler extends DefaultHandler {

        private String currentElement;
        private List<String> names = new ArrayList<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (currentElement != null && currentElement.equalsIgnoreCase(qName)) {
                names.add(qName);
                currentElement = null;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Do nothing
        }

        public List<String> getNames() {
            return names;
        }
    }

    public static void main(String[] args) {
        String xml = "<people><person><name>John</name><occupation>Engineer</occupation></person><person><name>Jane</name><occupation>Doctor</occupation></person></people>";
        MyHandler handler = new MyHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, handler);
            saxParser.parse(new InputSource(new StringReader(xml)));

            List<String> names = handler.getNames();
            for (String name : names) {
                System.out.println("Name: " + name);
            }
        } catch (SAXParseException e) {
            System.err.println("Parsing error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }
    }
}