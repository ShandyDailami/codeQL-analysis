import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import java.util.Stack;

public class java_16710_XMLParser_A01 extends DefaultHandler {
    private Stack<String> elementStack = new Stack<>();

    @Override
    public void startDocument() throws SAXParseException {
        System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXParseException {
        System.out.println("End document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qName);
        elementStack.push(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
        elementStack.pop();
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String content = new String(ch, start, length);
        System.out.println("Content: " + content);
    }

    public static void main(String[] args) {
        LegacyXMLSAXParser parser = new LegacyXMLSAXParser();
        // You need to provide your XML data here
        String xmlData = "<note>\n" +
                "  <to>Tove</to>\n" +
                "  <from>Jani</from>\n" +
                "  <heading>Reminder</heading>\n" +
                "  <body>Don't forget me this weekend!</body>\n" +
                "</note>";

        // Parse the XML
        org.xml.sax.XMLReader xmlReader = org.xml.sax.SAXReader.newInstance();
        xmlReader.setContentHandler(parser);
        xmlReader.parse(new InputSource(new StringReader(xmlData)));
    }
}