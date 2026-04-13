import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;

public class java_04852_XMLParser_A03 extends DefaultHandler {

    private String thisElement = "";
    private boolean isTitle = false;
    private boolean isLink = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        thisElement = qName;
        if ("title".equals(qName)) {
            isTitle = true;
        }
        if ("link".equals(qName)) {
            isLink = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("title".equals(qName)) {
            isTitle = false;
        }
        if ("link".equals(qName)) {
            isLink = false;
        }
        thisElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isTitle) {
            System.out.println("Title: " + new String(ch, start, length));
        }
        if (isLink) {
            System.out.println("Link: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        MyXMLParser parser = new MyXMLParser();
        try {
            SAXParserFactory.newInstance().newSAXParser().parse("data.xml", parser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}