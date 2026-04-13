import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.Stack;

public class java_18023_XMLParser_A08 {
    private static class MyHandler extends DefaultHandler {
        private Stack<String> stack = new Stack<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("element")) {
                stack.push(qName);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < stack.size(); i++) {
                    sb.append(stack.get(i));
                    if (i != stack.size() - 1)
                        sb.append(" ");
                }
                System.out.println("Start element: " + sb.toString());
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("element")) {
                System.out.println("End element: " + qName);
                stack.pop();
            }
        }
    }

    public static void parse(String xml) {
        MyHandler handler = new MyHandler();
        try {
            org.xml.sax.SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            org.xml.sax.SAXParser saxParser = saxFactory.newSAXParser(null);
            saxParser.parse(xml, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String xml = "<root><element1><element2><element3></element3></element2><element2></element1></root>";
        parse(xml);
    }
}