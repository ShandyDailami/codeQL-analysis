import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_21333_XMLParser_A03 extends DefaultHandler {
    private List<String> names;
    private String currentElement;

    public java_21333_XMLParser_A03() {
        names = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentElement.equalsIgnoreCase("name")) {
            names.add(localName);
        }
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentElement != null && currentElement.equalsIgnoreCase("name")) {
            String text = new String(ch, start, length);
            System.out.println("Name: " + text);
        }
    }
}