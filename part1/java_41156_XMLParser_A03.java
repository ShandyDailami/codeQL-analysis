import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_41156_XMLParser_A03 {
    private Stack<String> elementStack = new Stack<>();
    private boolean isInElement = false;

    public void parse(String xml) {
        SAXHandler handler = new SAXHandler();
        javax.xml.parsers.SAXParserFactory factory = javax.xml.parsers.SAXParserFactory.newInstance();
        try {
            javax.xml.parsers.SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(xml, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class SAXHandler extends DefaultHandler {
        private StringBuilder buffer = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            elementStack.push(qName);
            buffer.setLength(0);
            isInElement = true;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isInElement) {
                buffer.append(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals(elementStack.peek())) {
                String value = buffer.toString().trim();
                if (isValueSafe(value)) {
                    System.out.println("Safe: " + value);
                } else {
                    System.out.println("Insecure: " + value);
                }
                elementStack.pop();
                isInElement = false;
            }
        }

        private boolean isValueSafe(String value) {
            // Add your security checks here. Return true if the value is safe, false otherwise.
            // For now, we'll return true.
            return true;
        }
    }
}