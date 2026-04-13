import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_20389_XMLParser_A08 extends DefaultHandler {

    private boolean isTitle;
    private boolean isLink;
    private StringBuilder content;
    private List<String> links;

    public java_20389_XMLParser_A08() {
        this.links = new ArrayList<>();
        this.content = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("title")) {
            this.isTitle = true;
        } else if (qName.equalsIgnoreCase("link")) {
            this.isLink = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("title")) {
            this.isTitle = false;
        } else if (qName.equalsIgnoreCase("link")) {
            this.isLink = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (this.isTitle) {
            String title = new String(ch, start, length);
            // perform security sensitive operation here with title
        } else if (this.isLink) {
            String link = new String(ch, start, length);
            this.links.add(link);
        }
    }

    public List<String> getLinks() {
        return this.links;
    }
}