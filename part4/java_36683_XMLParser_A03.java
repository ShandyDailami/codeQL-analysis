import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_36683_XMLParser_A03 extends DefaultHandler {
    private boolean isTitle = false;
    private boolean isLink = false;

    public java_36683_XMLParser_A03() {
        super();
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("title")) {
            isTitle = true;
        } else if (qName.equalsIgnoreCase("link")) {
            isLink = true;
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
            String title = new String(ch, start, length);
            System.out.println("Title: " + title);
        } else if (isLink) {
            String link = new String(ch, start, length);
            System.out.println("Link: " + link);
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String xmlFile = "src/main/resources/sample.xml";
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxFactory.newSAXParser();

        MyXMLParser handler = new MyXMLParser();
        saxParser.parse(xmlFile, handler);
    }
}