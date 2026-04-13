import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
import java.io.*;

public class java_11566_XMLParser_A08 {
    public static class MyHandler extends DefaultHandler {
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Print the namespace URI and local name of the element.
            System.out.println("Start element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Print the namespace URI and local name of the element.
            System.out.println("End element: " + qName);
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            // Print the characters in the element.
            String str = new String(ch, start, length);
            System.out.println("Characters: " + str);
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        // Load the XML file.
        String fileName = "sample.xml";
        File file = new File(fileName);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(new InputSource(new FileInputStream(file)));

        // Create the handler and set it to the parser.
        MyHandler handler = new MyHandler();
        parser.setContentHandler(handler);

        // Start parsing.
        parser.parse(new InputSource(new FileInputStream(file)));
    }
}