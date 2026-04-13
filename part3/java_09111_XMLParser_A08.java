import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_09111_XMLParser_A08 extends DefaultHandler {
    private boolean isTitle = false;
    private boolean isLink = false;
    private String title;
    private String link;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("item")) {
            isTitle = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("title")) {
            isTitle = false;
        } else if (qName.equalsIgnoreCase("link")) {
            isLink = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isTitle) {
            title = new String(ch, start, length);
        } else if (isLink) {
            link = new String(ch, start, length);
        }
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }
}