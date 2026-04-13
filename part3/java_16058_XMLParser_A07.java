import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.ElementListener;

import java.io.File;
import java.io.IOException;

public class java_16058_XMLParser_A07 {
    public static void main(String[] args) {
        // Create a new instance of the handler
        DefaultHandler handler = new DefaultHandler();
        ElementListener listener = new ElementListener();

        // Set the handler for the namespaces
        handler.setContentHandler(listener);

        // Parse the XML
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new File("input.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Implement a default handler for namespaces
    static class DefaultHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            System.out.println("Start element: " + localName);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("End element: " + localName);
        }

        @Override
            public void characters(char[] ch, int start, int length)
                throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    // Implement an element listener for namespaces
    static class ElementListener extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            System.out.println("Start element: " + localName);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("End element: " + localName);
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}