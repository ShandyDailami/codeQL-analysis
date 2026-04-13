import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_30418_XMLParser_A03 extends DefaultHandler {

    private boolean isTitle = false;
    private boolean isLink = false;
    private String currentElement;
    private List<String> links = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName.equals("title")) {
            isTitle = true;
        } else if (localName.equals("link")) {
            isLink = true;
        } else {
            currentElement = localName;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("title")) {
            isTitle = false;
        } else if (localName.equals("link")) {
            isLink = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isTitle) {
            // This is where you should add code that will handle the title.
            // This is a security-sensitive operation.
            System.out.println("Title: " + new String(ch, start, length));
        } else if (isLink) {
            links.add(new String(ch, start, length));
        }
    }

    public List<String> getLinks() {
        return links;
    }
}