import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_22999_XMLParser_A07 extends DefaultHandler {
    private List<String> names = new ArrayList<>();
    private List<String> values = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        names.add(localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();
        if (!value.isEmpty()) {
            values.add(value);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Handle end element here
        // You can use the collected data by names and values
    }

    public List<String> getNames() {
        return names;
    }

    public List<String> getValues() {
        return values;
    }
}