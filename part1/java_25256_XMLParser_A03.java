import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_25256_XMLParser_A03 extends DefaultHandler {

    private List<String> tags;
    private String currentTag;

    public java_25256_XMLParser_A03() {
        this.tags = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentTag = qName;
        tags.add(qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentTag = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentTag != null && currentTag.equalsIgnoreCase("tagname")) {
            // do something with the character data
        }
    }

    public List<String> getTags() {
        return this.tags;
    }
}