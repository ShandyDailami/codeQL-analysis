import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_23975_XMLParser_A03 extends DefaultHandler {
    private List<String> injectionList = new ArrayList<>();
    private StringBuilder elementData = new StringBuilder();
    private boolean isInsideElement = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // Security-sensitive operation: prevent injection
        if (injectionList.contains(qName)) {
            System.out.println("Avoiding injection attempt in the element: " + qName);
            return;
        }
        elementData.setLength(0);
        isInsideElement = true;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isInsideElement) {
            elementData.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Security-sensitive operation: prevent injection
        if (injectionList.contains(qName)) {
            System.out.println("Avoiding injection attempt in the element: " + qName);
            return;
        }
        // Security-sensitive operation: add to list
        injectionList.add(elementData.toString());
        isInsideElement = false;
    }

    // Main method for testing
    public static void main(String[] args) {
        String xml = "<root><element1>Injection</element2><element1>Not Injection</element1><element2>Injection</element2></root>";
        SecureXMLParser parser = new SecureXMLParser();
        try {
            org.xml.sax.SAXParserFactory saxParserFactory = org.xml.sax.SAXParserFactory.newInstance();
            org.xml.sax.SAXParser saxParser = saxParserFactory.newSAXParser(parser);
            saxParser.parse(new InputSource(new StringReader(xml)), parser);
            parser.getInjectionList().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getInjectionList() {
        return injectionList;
    }
}