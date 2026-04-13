import java.util.List;
import java.util.Map;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;
import org.xml.sax.xmlreader.XMLReader;

public class java_27823_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            XMLReader reader = factory.newSAXParser().getXMLReader();
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);
            reader.parse("src/example.xml"); // replace with your file path
            printData(handler.getTags(), handler.getAttributes());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static void printData(List<String> tags, Map<String, String> attributes) {
        System.out.println("\nTags:");
        for (String tag : tags) {
            System.out.println(tag);
        }
        System.out.println("\nAttributes:");
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}

class MyHandler extends DefaultHandler {
    private List<String> tags = new ArrayList<>();
    private Map<String, String> attributes = new HashMap<>();
    private StringBuilder currentValue;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Map<String, String> attributes) throws SAXException {
        System.out.println("Start element: " + qName);
        this.tags.add(qName);
        this.attributes.putAll(attributes);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
        this.currentValue = new StringBuilder();
    }

    public List<String> getTags() {
        return this.tags;
    }

    public Map<String, String> getAttributes() {
        return this.attributes;
    }
}