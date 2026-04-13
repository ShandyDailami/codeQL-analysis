import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_30787_XMLParser_A08 extends DefaultHandler {

    private List<String> names = new ArrayList<>();
    private List<Integer> ages = new ArrayList<>();
    private List<String> addresses = new ArrayList<>();

    private String lastTag = null;

    public List<String> getNames() {
        return names;
    }

    public List<Integer> getAges() {
        return ages;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    @Override
    public void startDocument() {
        System.out.println("Start of document.");
    }

    @Override
    public void endDocument() {
        System.out.println("End of document.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        lastTag = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        lastTag = null;
    }

    @Override
    public void characters(char[] chars, int start, int length) {
        String content = new String(chars, start, length).trim();
        if (lastTag == null) return;

        switch (lastTag) {
            case "name":
                names.add(content);
                break;
            case "age":
                ages.add(Integer.parseInt(content));
                break;
            case "address":
                addresses.add(content);
                break;
            default:
                break;
        }
    }

    @Override
    public void fatalError(SAXException e) {
        System.out.println("Fatal error: " + e.getMessage());
    }

    @Override
    public void warning(SAXException e) {
        System.out.println("Warning: " + e.getMessage());
    }
}