import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_20303_XMLParser_A08 extends DefaultHandler {
    
    private boolean isTitleElement = false;
    private boolean isLinkElement = false;
    private StringBuilder title;
    private StringBuilder link;

    public java_20303_XMLParser_A08(String title, String link) {
        this.title = new StringBuilder(title);
        this.link = new StringBuilder(link);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("title".equals(qName)) {
            isTitleElement = true;
        } else if ("link".equals(qName)) {
            isLinkElement = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("title".equals(qName)) {
            isTitleElement = false;
        } else if ("link".equals(qName)) {
            isLinkElement = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isTitleElement) {
            title.append(new String(ch, start, length));
        } else if (isLinkElement) {
            link.append(new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        MySAXParser parser = new MySAXParser("Default Title", "Default Link");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse("src/main/resources/books.xml", parser);
            System.out.println(parser.getTitle());
            System.out.println(parser.getLink());
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    public StringBuilder getTitle() {
        return title;
    }

    public StringBuilder getLink() {
        return link;
    }
}