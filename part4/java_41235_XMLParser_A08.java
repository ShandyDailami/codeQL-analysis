import java.io.File;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_41235_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            SAXReader saxReader = SAXReaderFactory.newInstance();
            MyHandler myHandler = new MyHandler();
            XMLReader xmlReader = saxReader.getXMLReader(myHandler);
            xmlReader.parse(inputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {

        private Stack<String> elementStack = new Stack<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            elementStack.push(qName);
            System.out.println("Start Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            elementStack.pop();
            System.out.println("End Element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String contents = new String(ch, start, length).trim();
            if (!contents.isEmpty()) {
                String elementName = elementStack.peek();
                System.out.println("Element: " + elementName + ", Content: " + contents);
            }
        }

        @Override
        public void fatalError(SAXParseException e) throws SAXException {
            System.err.println("Fatal Error: " + e.getMessage());
        }

        @Override
        public void warning(SAXParseException e) throws SAXException {
            System.err.println("Warning: " + e.getMessage());
        }
    }
}