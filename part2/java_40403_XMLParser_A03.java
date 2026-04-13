import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_40403_XMLParser_A03 extends DefaultHandler {
    private List<String> tags = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        tags.add(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        tags.remove(qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!tags.isEmpty()) {
            String content = new String(ch, start, length);
            System.out.println("Tag: " + tags.get(tags.size() - 1) + ", Content: " + content);
        }
    }

    public static void main(String[] args) {
        MyXMLParser myParser = new MyXMLParser();

        // Use SAX parser here.
    }
}