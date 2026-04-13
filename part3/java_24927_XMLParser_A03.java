import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_24927_XMLParser_A03 extends DefaultHandler {
    private List<String> tags = new ArrayList<>();
    private List<String> attributeNames = new ArrayList<>();
    private List<String> attributeValues = new ArrayList<>();

    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes)
            throws SAXException {
        // Security-sensitive operation: filter out any tags that are not within the expected namespace
        if (!qualifiedName.startsWith("a03_injection:")) {
            return;
        }

        tags.add(localName);
        attributeNames.add(attributes.getLocalName());
        attributeValues.add(attributes.getValue());
    }

    public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
        // Security-sensitive operation: filter out any tags that are not within the expected namespace
        if (!qualifiedName.startsWith("a03_injection:")) {
            return;
        }

        // Security-sensitive operation: filter out any tags that are not within the expected namespace
        if (!localName.equals("a03_injection:element")) {
            return;
        }

        // Security-sensitive operation: filter out any tags that are not within the expected namespace
        if (!attributeNames.get(tags.size() - 1).equals("attribute")) {
            return;
        }

        // Security-sensitive operation: filter out any tags that are not within the expected namespace
        if (!attributeValues.get(tags.size() - 1).equals("value")) {
            return;
        }

        System.out.println("Found secure element: " + localName);
    }

    public void startDocument() throws SAXException {
        // Security-sensitive operation: do nothing
    }

    public void endDocument() throws SAXException {
        // Security-sensitive operation: do nothing
    }
}