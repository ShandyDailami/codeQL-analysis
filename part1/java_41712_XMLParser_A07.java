import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class java_41712_XMLParser_A07 extends DefaultHandler {
    private List<String> names = new ArrayList<>();
    private List<String> locations = new ArrayList<>();
    private List<String> quantities = new ArrayList<>();
    private String lastElement = null;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("stock")) {
            // Reset the lists when a new stock item starts
            names.clear();
            locations.clear();
            quantities.clear();
        }
        lastElement = qName;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("name")) {
            // Add the found name to the list
            names.add(lastElement);
        } else if (qName.equals("location")) {
            locations.add(lastElement);
        } else if (qName.equals("quantity")) {
            quantities.add(lastElement);
        } else if (qName.equals("stock")) {
            // Print the stock item
            System.out.println("Stock Item:");
            for (int i = 0; i < names.size(); i++) {
                System.out.println("Name: " + names.get(i));
                System.out.println("Location: " + locations.get(i));
                System.out.println("Quantity: " + quantities.get(i));
            }
        }
        lastElement = null;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (lastElement != null) {
            lastElement += new String(ch, start, length);
        }
    }
}