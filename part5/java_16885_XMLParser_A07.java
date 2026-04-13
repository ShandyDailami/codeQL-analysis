import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_16885_XMLParser_A07 extends DefaultHandler {
    private List<String> tags = new ArrayList<>();
    private List<String> attributes = new ArrayList<>();
    private StringBuilder currentValue;
    private String currentTag;
    private String currentAttribute;

    public void startDocument() {
        System.out.println("Start of XML Document");
    }

    public void endDocument() {
        System.out.println("End of XML Document");
    }

    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) {
        System.out.println("Start Element: " + qualifiedName);
        this.currentTag = qualifiedName;
        this.currentValue = new StringBuilder();
        this.tags.add(this.currentTag);
        for (int i = 0; i < attributes.getLength(); i++) {
            this.attributes.add(attributes.getQualifiedPrefix(i) + ":" + attributes.getValue(i));
        }
    }

    public void endElement(String uri, String localName, String qualifiedName) {
        System.out.println("End Element: " + qualifiedName);
        this.currentTag = qualifiedName;
        tags.remove(this.currentTag);
        this.currentValue = null;
    }

    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
        this.currentValue.append(new String(ch, start, length));
    }

    public void fatalError(SAXException e) {
        System.out.println("Fatal Error: " + e.getMessage());
    }

    public void warning(SAXException e) {
        System.out.println("Warning: " + e.getMessage());
    }

    public List<String> getTags() {
        return tags;
    }

    public List<String> getAttributes() {
        return attributes;
    }
}