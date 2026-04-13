import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_26416_XMLParser_A03 extends DefaultHandler {
    private List<String> names = new ArrayList<>();
    private List<String> values = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            names.clear();
        } else if (qName.equalsIgnoreCase("value")) {
            values.clear();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (names.size() == values.size()) {
            names.add(new String(ch, start, length));
        } else {
            values.add(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            System.out.println("Name: " + String.join(",", names));
        } else if (qName.equalsIgnoreCase("value")) {
            System.out.println("Value: " + String.join(",", values));
        }
    }
}