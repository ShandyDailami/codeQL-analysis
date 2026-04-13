import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_36178_XMLParser_A03 extends DefaultHandler {

    private List<String> names;
    private String currentElement;

    public java_36178_XMLParser_A03() {
        names = new ArrayList<>();
    }

    public List<String> getNames() {
        return names;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = localName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String name = new String(ch, start, length).trim();
        if (!name.isEmpty()) {
            names.add(currentElement + ": " + name);
        }
    }
}