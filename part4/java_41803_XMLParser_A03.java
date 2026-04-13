import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_41803_XMLParser_A03 extends DefaultHandler {

    private List<String> tags = new ArrayList<>();
    private List<String> attributes = new ArrayList<>();

    private boolean isTag = false;
    private boolean isAttribute = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("tag")) {
            isTag = true;
        } else if (qName.equalsIgnoreCase("attribute")) {
            isAttribute = true;
        } else {
            if (isTag) {
                tags.add(qName);
            } else if (isAttribute) {
                attributes.add(qName);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("tag")) {
            isTag = false;
        } else if (qName.equalsIgnoreCase("attribute")) {
            isAttribute = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isTag || isAttribute) {
            String str = new String(ch, start, length);
            if (isTag) {
                tags.add(str);
            } else if (isAttribute) {
                attributes.add(str);
            }
        }
    }

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        // parse your XML here
    }
}