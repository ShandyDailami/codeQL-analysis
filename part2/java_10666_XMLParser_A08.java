import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_10666_XMLParser_A08 extends DefaultHandler {

    private List<String> namespaces;
    private List<String> tags;
    private StringBuilder elementData;
    private String currentTag;
    private boolean namespace;
    private boolean nsPrefix;
    private boolean currentElement;

    public java_10666_XMLParser_A08() {
        namespaces = new ArrayList<>();
        tags = new ArrayList<>();
        elementData = new StringBuilder();
    }

    @Override
    public void startDocument() {
        namespaces.add("http://www.w3.org/2001/XMLSchema-instance");
        namespaces.add("http://www.w3.org/2001/XMLSchema");
        namespaces.add("http://www.w3.org/2001/XMLSchema-literal");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentTag = qName;

        if (currentElement) {
            elementData.setLength(0);
        } else {
            tags.add(qName);
        }

        elementData.append('<');
        elementData.append(qName);

        if (attributes.getLength() > 0) {
            elementData.append(' ');
            for (int i = 0; i < attributes.getLength(); i++) {
                elementData.append(attributes.getQName(i));
                elementData.append("=\"");
                elementData.append(attributes.getValue(i));
                elementData.append('\"');

                if (i < attributes.getLength() - 1) {
                    elementData.append(' ');
                }
            }
        }

        elementData.append('/');
        elementData.append('>');

        currentElement = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        currentTag = qName;

        elementData.append('<');
        elementData.append('/');
        elementData.append(qName);
        elementData.append('>');

        currentElement = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (currentElement) {
            elementData.append(ch, start, length);
        }
    }

    public List<String> getNamespaces() {
        return namespaces;
    }

    public List<String> getTags() {
        return tags;
    }

    public StringBuilder getElementData() {
        return elementData;
    }
}