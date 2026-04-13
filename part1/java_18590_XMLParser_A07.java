import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_18590_XMLParser_A07 extends DefaultHandler {

    private boolean isName = false;
    private boolean isValue = false;
    private String currentElement;
    private List<String> names = new ArrayList<>();
    private List<String> values = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if (qName.equalsIgnoreCase("name")) {
            isName = true;
        } else if (qName.equalsIgnoreCase("value")) {
            isValue = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("name")) {
            isName = false;
        } else if (qName.equalsIgnoreCase("value")) {
            isValue = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            names.add(new String(ch, start, length));
        } else if (isValue) {
            values.add(new String(ch, start, length));
        }
    }

    public List<String> getNames() {
        return names;
    }

    public List<String> getValues() {
        return values;
    }
}