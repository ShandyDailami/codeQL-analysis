import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Stack;

public class java_28595_XMLParser_A08 extends DefaultHandler {

    private Stack<String> stack = new Stack<>();

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
        System.out.println("Start of element " + qName);
        stack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End of element " + qName);
        stack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!stack.isEmpty()) {
            System.out.print("Character data: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) throws Exception {
        SimpleXMLParser parser = new SimpleXMLParser();
        javax.xml.parsers.SAXParserFactory factory = SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser saxParser = factory.newSAXParser(null);
        saxParser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.xml"), parser);
    }
}