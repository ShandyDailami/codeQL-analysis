import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_28948_XMLParser_A03 {

    private Stack<String> elementStack;

    public java_28948_XMLParser_A03() {
        elementStack = new Stack<>();
    }

    public void parse(String xmlData) {
        try {
            SAXReader saxReader = XMLReaderFactory.createSAXReader();
            MyHandler handler = new MyHandler();
            saxReader.setContentHandler(handler);
            saxReader.parse(new StringReader(xmlData));
        } catch (Exception e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }

    private class MyHandler extends DefaultHandler {
        private static final String NAMESPACE_DECLARATION =
            "xmlns:xlink=\"http://www.w3.org/1999/xlink\" xmlns=\"http://www.w3.org/1999/xhtml\"";

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Starting XML document...");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("Ending XML document...");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            elementStack.push(qName);
            System.out.print("Start element: ");
            System.out.println(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            elementStack.pop();
            System.out.print("End element: ");
            System.out.println(qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String strChars = new String(ch, start, length);
            String elementName = elementStack.peek();
            if (elementName != null) {
                System.out.print("Character data for element ");
                System.out.print(elementName);
                System.out.println(": " + strChars);
            }
        }

        @Override
        public void warning(SAXParseException e) throws SAXException {
            System.out.println("Warning: " + e.getMessage());
        }

        @Override
        public void error(SAXParseException e) throws SAXException {
            System.out.println("Error: " + e.getMessage());
        }

        @Override
        public void fatalError(SAXParseException e) throws SAXException {
            System.out.println("Fatal Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String xmlData = "<notebook>" +
            "<to>Tove</to>" +
            "<from>Jani</from>" +
            "<heading>Reminder</heading>" +
            "<body>Don't forget me this weekend!</body>" +
            "</notebook>";
        new SecureXMLParser().parse(xmlData);
    }
}