import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_20549_XMLParser_A08 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        elementStack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals(elementStack.peek())) {
            elementStack.pop();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length).trim();
        if (!content.isEmpty()) {
            // You can add your security-sensitive operations here
            // For example, checking the integrity of the XML content
            // If the content is not valid, throw an exception or handle it appropriately
        }
    }

    public void parse(String xmlContent) throws SAXException {
        org.xml.sax.SAXParserFactory saxParserFactory = org.xml.sax.SAXParserFactory.newInstance();
        org.xml.sax.SAXParser saxParser = saxParserFactory.newSAXParser(null);
        saxParser.parse(xmlContent, this);
    }
}