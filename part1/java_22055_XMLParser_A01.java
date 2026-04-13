import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class java_22055_XMLParser_A01 {
    
    public static void main(String[] args) {
        try {
            parse("sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void parse(String fileName) throws ParserConfigurationException, SAXException {
        // Step 1: Create a SAXParserFactory instance
        SAXParserFactory factory = SAXParserFactory.newInstance();

        // Step 2: Create a SAXParser instance
        SAXParser parser = factory.newSAXParser(new InputSource(new File(fileName)));

        // Step 3: Create a customHandler instance
        MyHandler handler = new MyHandler();

        // Step 4: Parse the XML file using the SAXParser
        parser.parse(new File(fileName), handler);
    }
    
    // This is a custom SAXHandler implementation
    public static class MyHandler extends DefaultHandler {
        private Stack<Element> stack = new Stack<>();

        @Override
        public void startDocument() throws SAXException {
            System.out.println("Start of the document");
        }

        @Override
        public void endDocument() throws SAXException {
            System.out.println("End of the document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start of element: " + qName);
            stack.push(new Element(qName, attributes));
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of element: " + qName);
            stack.pop();
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String content = new String(ch, start, length);
            Element current = stack.peek();
            current.addContent(content);
        }

        public static class Element {
            private String name;
            private Attributes attributes;
            private List<String> contents = new ArrayList<>();

            public java_22055_XMLParser_A01(String name, Attributes attributes) {
                this.name = name;
                this.attributes = attributes;
            }

            public void addContent(String content) {
                contents.add(content);
            }

            public void print() {
                System.out.println("Element: " + name);
                System.out.println("Attributes: " + attributes);
                System.out.println("Contents: " + contents);
            }
        }
    }
}