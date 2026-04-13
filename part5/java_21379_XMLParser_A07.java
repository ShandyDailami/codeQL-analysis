import java.util.Stack;
import java.io.*;
import java.xml.parsers.*;
import org.xml.sax.*;

public class java_21379_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a new instance of SAXParser
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();

            // Create an event handler
            MyHandler myHandler = new MyHandler();

            // Create a new instance of XMLReader
            XMLReader xmlReader = saxParser.getXMLReader();

            // Set the event handler
            xmlReader.setContentHandler(myHandler);

            // Parse the XML file
            xmlReader.parse("src/input.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements ContentHandler {
    private Stack<String> stack = new Stack<String>();

    public void startDocument() throws SAXException {
    }

    public void endDocument() throws SAXException {
    }

    public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes attributes) throws SAXException {
        stack.push(qualifiedName);
    }

    public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
        stack.pop();
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
    }

    public void fatalError(String error) throws SAXException {
        System.out.println("Fatal Error: " + error);
    }

    public void warning(SAXWarning warning) throws SAXException {
        System.out.println("Warning: " + warning.getMessage());
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }

    public void endPrefixMapping(String prefix, String uri) throws SAXException {
    }
}