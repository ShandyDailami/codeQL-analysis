import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLStreamReader;
import org.xml.sax.parser.XMLEventReader;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class java_12497_XMLParser_A08 {
    private Stack<String> stack = new Stack<>();

    public void parse(String fileName) {
        XMLStreamReader parser = null;
        try {
            parser = XMLStreamReader.newInstance(new File(fileName));
        } catch (IOException | SAXException e) {
            e.printStackTrace();
            return;
        }
        DefaultHandler handler = new DefaultHandler() {
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
                System.out.print("Start element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                stack.pop();
                System.out.println("End element: " + qName);
            }
        };
        try {
            while (parser.hasNext()) {
                int type = parser.next();
                if (type == XMLStreamReader.START_ELEMENT) {
                    String name = parser.getLocalName();
                    handler.startElement(parser.getNamespaceURI(), name, name, null);
                } else if (type == XMLStreamReader.END_ELEMENT) {
                    handler.endElement(parser.getNamespaceURI(), parser.getLocalName(), parser.getLocalName());
                }
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            try {
                parser.close();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        }
    }
}