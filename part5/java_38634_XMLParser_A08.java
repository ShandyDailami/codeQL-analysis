import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class java_38634_XMLParser_A08 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        // Create a new parser
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(new Properties());

        // Create a new XMLReader
        XMLReader xmlReader = saxParser.getXMLReader();

        // Register the XMLHandler
        xmlReader.setContentHandler(new XMLHandler());

        // Parse the XML
        xmlReader.parse("src/main/resources/sample.xml");
    }
}

class XMLHandler implements ContentHandler {
    private Stack<Element> elementStack = new Stack<>();
    private StringBuffer buffer = new StringBuffer();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Create a new element and add it to the stack
        Element element = new Element(localName);
        elementStack.push(element);

        // Print the element
        buffer.append(element.toString());

        // Handle attributes
        for (int i = 0; i < attributes.getLength(); i++) {
            element.addAttribute(attributes.getQName(i), attributes.getValue(i));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Pop the last element from the stack
        Element element = elementStack.pop();

        // Print the element
        buffer.append(element.toString());
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Print the characters
        buffer.append(new String(ch, start, length));
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        // Do nothing
    }

    @Override
    public void setDocumentLocator(Locator locator) {
        // Do nothing
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        // Do nothing
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        // Do nothing
    }

    private static class Element {
        String name;
        Map<String, String> attributes = new HashMap<>();

        Element(String name) {
            this.name = name;
        }

        void addAttribute(String name, String value) {
            attributes.put(name, value);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(name);
            sb.append(' ');
            for (Map.Entry<String, String> entry : attributes.entrySet()) {
                sb.append(entry.getKey());
                sb.append("=\"");
                sb.append(entry.getValue());
                sb.append("\" ");
            }
            return sb.toString();
        }
    }
}