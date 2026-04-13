import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_13765_XMLParser_A01 {
    private static class MyHandler extends DefaultHandler {
        private Stack<String> stack = new Stack<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            String elementName = qName;
            if (stack.isEmpty()) {
                System.out.println(elementName);
            } else {
                String parentElement = stack.pop();
                System.out.println(parentElement + " > " + elementName);
            }
            stack.push(elementName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            stack.pop();
        }
    }

    public static void main(String[] args) throws Exception {
        String xml = "<root><a><b><c id='id1'>Content 1</c></b></a></root>";
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new MyHandler());
        parser.parse(new InputSource(new StringReader(xml)));
    }
}