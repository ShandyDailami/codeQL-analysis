import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLValidator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class java_07646_XMLParser_A01 extends DefaultHandler {

    private Map<String, String> map = new HashMap<>();
    private StringBuilder currentValue;
    private String currentElement;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentValue = new StringBuilder();
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentElement.equalsIgnoreCase("root")) {
            System.out.println("Root element not allowed");
        } else if (currentElement.equalsIgnoreCase("name")) {
            map.put("name", currentValue.toString());
        } else if (currentElement.equalsIgnoreCase("age")) {
            map.put("age", currentValue.toString());
        } else {
            System.out.println("Unknown element: " + currentElement);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue.append(new String(ch, start, length));
    }

    public static void main(String[] args) throws Exception {
        XMLParser parser = XMLValidator.newSAXParser(new MyXMLHandler());
        parser.parse(new File("sample.xml"));

        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}