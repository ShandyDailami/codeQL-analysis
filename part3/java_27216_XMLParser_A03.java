import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_27216_XMLParser_A03 {

    private static class MyHandler extends DefaultHandler {
        private Stack<String> stack = new Stack<>();

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start Document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start Element: " + qName);
            stack.push(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            stack.pop();
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (!stack.isEmpty()) {
                String element = new String(ch, start, length);
                System.out.println("Element: " + element);
            }
        }
    }

    public static void main(String[] args) {
        try {
            org.xml.sax.SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            org.xml.sax.SAXParser saxParser = saxFactory.newSAXParser(null);
            MyHandler myHandler = new MyHandler();
            saxParser.parse("src/main/resources/test.xml", myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}