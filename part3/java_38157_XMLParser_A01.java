import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_38157_XMLParser_A01 extends DefaultHandler {
    private List<String> tagStack = new ArrayList<>();
    private StringBuilder elementContent = new StringBuilder();
    private String namespaceURI;
    private String localName;
    private boolean bIsInElementContent = false;

    private List<String> invalidTags = new ArrayList<>();

    public List<String> getInvalidTags() {
        return invalidTags;
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes attributes) throws SAXException {
        this.namespaceURI = namespaceURI;
        this.localName = localName;

        // If it's a security-sensitive operation
        if (localName.equals("script") || localName.equals("style") || localName.equals("link") || localName.equals("iframe")) {
            invalidTags.add(localName);
        }

        // Push the current tag into the tag stack
        tagStack.add(localName);

        // Reset the element content
        elementContent.setLength(0);
    }

    @Override
    public void endElement(String namespaceURI, String localName) throws SAXException {
        tagStack.remove(tagStack.size() - 1);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bIsInElementContent) {
            elementContent.append(ch, start, length);
        }
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        // Ignore any whitespace in element content
    }
}