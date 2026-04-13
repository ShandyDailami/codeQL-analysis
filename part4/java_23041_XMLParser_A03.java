import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_23041_XMLParser_A03 {
    public static class MyHandler extends DefaultHandler {
        private Stack<String> elementStack = new Stack<>();

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of Document");
        }

        @Override
        public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
            System.out.print("Start of " + qualifiedName);
            elementStack.push(qualifiedName);
        }

        @Override
        public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
            elementStack.pop();
            System.out.println("End of " + qualifiedName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (!elementStack.isEmpty()) {
                String currentElement = elementStack.peek();
                System.out.print(": " + new String(ch, start, length));
            }
        }
    }

    public static void main(String[] args) {
        MyHandler handler = new MyHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null, handler);
            parser.parse(XMLParser.class.getResourceAsStream("sample.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}