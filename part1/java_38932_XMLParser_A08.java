import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_38932_XMLParser_A08 extends DefaultHandler {

    private boolean isTitle = false;
    private boolean isLink = false;
    private StringBuilder content;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("post")) {
            isTitle = true;
            content = new StringBuilder();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isTitle) {
            content.append(new String(ch, start, length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("title")) {
            isTitle = false;
            System.out.println("Title: " + content.toString());
        } else if (qName.equalsIgnoreCase("link")) {
            isLink = false;
            System.out.println("Link: " + content.toString());
        }
    }
}