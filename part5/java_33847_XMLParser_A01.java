import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_33847_XMLParser_A01 extends DefaultHandler {
    private List<String> tags;
    private List<String> attributeValues;
    private List<String> elementValues;
    private List<String> tagValues;
    private List<String> attributeNames;

    public java_33847_XMLParser_A01() {
        tags = new ArrayList<>();
        attributeValues = new ArrayList<>();
        elementValues = new ArrayList<>();
        tagValues = new ArrayList<>();
        attributeNames = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        tags.add(qName);
        attributeNames.add(attributes.getQualifiedName(0));
        for (int i = 0; i < attributes.getLength(); i++) {
            attributeValues.add(attributes.getValue(i));
        }
        elementValues.add("");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        tags.add(qName);
        attributeNames.add(localName);
        elementValues.add("");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        elementValues.add(new String(ch, start, length));
    }

    public List<String> getTags() {
        return tags;
    }

    public List<String> getAttributeValues() {
        return attributeValues;
    }

    public List<String> getElementValues() {
        return elementValues;
    }

    public List<String> getTagValues() {
        return tagValues;
    }

    public List<String> getAttributeNames() {
        return attributeNames;
    }
}