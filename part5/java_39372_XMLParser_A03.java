import java.io.File;
import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_39372_XMLParser_A03 {
    class MyHandler extends DefaultHandler {
        Stack<String> stack = new Stack<String>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            stack.push(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            stack.pop();
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (!stack.isEmpty()) {
                String elementName = stack.peek();
                if ("root".equals(elementName)) {
                    System.out.println("Inside root element: " + new String(ch, start, length));
                } else {
                    System.out.println("Inside " + elementName + " element: " + new String(ch, start, length));
                }
            }
        }
    }

    public void parse(String fileName) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        MyHandler handler = new MyHandler();
        parser.parse(new File(fileName), handler);
    }

    public static void main(String[] args) {
        try {
            new XMLParser().parse("sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}