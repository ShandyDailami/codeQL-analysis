import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_19735_XMLParser_A03 extends DefaultHandler {
    private List<String> names;
    private String currentValue;

    public java_19735_XMLParser_A03() {
        names = new ArrayList<>();
    }

    public List<String> getNames() {
        return names;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentValue = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentValue = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("name")) {
            names.add(currentValue);
        }
    }
}