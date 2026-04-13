import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoadListener;
import org.xml.sax.parser.XMLErrorListener;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLStreamReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class java_36348_XMLParser_A03 {
    private static class MyHandler extends DefaultHandler {
        private Stack<String> elementStack = new Stack<>();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            elementStack.push(qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (!elementStack.isEmpty()) {
                String poppedElement = elementStack.pop();
                // do something with the popped element
            }
        }
    }

    public static void main(String[] args) throws IOException, SAXException {
        File inputFile = new File("input.xml");
        SAXParser.parse(inputFile, new MyHandler());
    }

    private static void parse(File inputFile, DefaultHandler handler) throws IOException, SAXException {
        XMLStreamReader parser = XMLStreamReader.newInstance(new FileReader(inputFile));
        SAXParser.parse(parser, handler);
    }

    private static void parse(XMLStreamReader parser, DefaultHandler handler) throws SAXException {
        int event = parser.getEventType();
        while (event != XMLStreamReader.END_DOCUMENT) {
            String element = parser.getLocalName();
            if (event == XMLStreamReader.START_ELEMENT) {
                handler.startElement(null, element, element);
            } else if (event == XMLStreamReader.END_ELEMENT) {
                handler.endElement(null, element, element);
            }
            event = parser.nextEvent();
        }
    }
}