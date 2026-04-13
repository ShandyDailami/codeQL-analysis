import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_19922_XMLParser_A08 extends DefaultHandler {
    private List<String> names = new ArrayList<>();
    private List<String> values = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        names.add(localName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // Do nothing as we only want to track the names
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        values.add(value);
    }

    public List<String> getNames() {
        return names;
    }

    public List<String> getValues() {
        return values;
    }

    public static void main(String[] args) {
        MyXMLHandler handler = new MyXMLHandler();

        // Parse your XML here

        List<String> names = handler.getNames();
        List<String> values = handler.getValues();

        // This is just a test. In real scenario, you would not use a SAX parser.
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + " = " + values.get(i));
        }
    }
}