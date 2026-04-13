import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLScanner;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class java_33711_XMLParser_A08 {
    public static void main(String[] args) {
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        MyHandler handler = new MyHandler();
        saxParser.parse(new File("input.xml"), handler);
    }

    static class MyHandler extends DefaultHandler {
        Stack<String> stack = new Stack<>();

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
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            stack.pop();
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String s = new String(ch, start, length);
            String indent = getIndent(stack);
            System.out.println(indent + s);
        }

        private String getIndent(Stack<String> stack) {
            StringBuilder builder = new StringBuilder();
            for (String name : stack) {
                builder.append("    ");
            }
            return builder.toString();
        }
    }
}