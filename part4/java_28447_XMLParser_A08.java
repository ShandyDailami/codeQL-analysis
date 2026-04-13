import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_28447_XMLParser_A08 {
    private static class XMLHandler extends DefaultHandler {
        private Stack<String> nodeStack = new Stack<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            nodeStack.push(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (localName.equals("A08_IntegrityFailure")) {
                System.out.println("Security failure detected!");
            }
            nodeStack.pop();
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String nodeName = nodeStack.peek();
            if (nodeName.equals("A08_IntegrityFailure")) {
                System.out.println("Security failure in: " + new String(ch, start, length));
            }
        }
    }

    public static void parse(String xmlFile) throws Exception {
        XMLHandler handler = new XMLHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, handler);
        parser.parse(xmlFile, handler);
    }

    public static void main(String[] args) {
        try {
            parse("src/main/resources/example.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}