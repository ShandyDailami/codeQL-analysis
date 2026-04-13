import java.util.Stack;
import java.util.StringTokenizer;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_05579_XMLParser_A01 {

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null);

        XmlHandler handler = new XmlHandler();
        parser.parse(XmlParser.class.getResourceAsStream("test.xml"), handler);
    }

    private static class XmlHandler extends DefaultHandler {
        private Stack<String> stack = new Stack<>();

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            stack.push(qName);
            printIndentation();
            System.out.println("Start of element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            stack.pop();
            printIndentation();
            System.out.println("End of element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (stack.peek().equals(stack.toString())) {
                System.out.print("Characters: ");
                System.out.println(new String(ch, start, length));
                printIndentation();
            }
        }

        private void printIndentation() {
            for (int i = 0; i < stack.size(); i++) {
                System.out.print("  ");
            }
        }
    }
}