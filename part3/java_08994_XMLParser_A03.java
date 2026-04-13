import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

import java.util.ArrayList;
import java.util.List;

public class java_08994_XMLParser_A03 extends DefaultHandler {
    private List<String> names = new ArrayList<>();
    private List<String> values = new ArrayList<>();
    private StringBuilder currentValue = new StringBuilder();
    private boolean isInElement = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("element")) {
            isInElement = true;
        } else {
            names.add(qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (isInElement) {
            currentValue.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equals("element")) {
            isInElement = false;
            values.add(currentValue.toString());
            currentValue.setLength(0);
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Names: " + names);
        System.out.println("Values: " + values);
    }

    @Override
    public void SAXParseException(SAXParseException e) {
        System.out.println("Parse error: " + e.getMessage());
    }

    public static void main(String[] args) throws Exception {
        XMLParser parser = new XMLParser();

        // Load the XML document
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser(null, parser);
        saxParser.parse("src/main/resources/example.xml", parser);
    }
}