import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_06451_XMLParser_A07 extends DefaultHandler {

    private boolean isUsername = false;
    private boolean isPassword = false;
    private String username = null;
    private String password = null;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("username")) {
            isUsername = true;
        } else if (qName.equalsIgnoreCase("password")) {
            isPassword = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("username")) {
            isUsername = false;
        } else if (qName.equalsIgnoreCase("password")) {
            isPassword = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isUsername) {
            username = new String(ch, start, length);
        } else if (isPassword) {
            password = new String(ch, start, length);
        }
    }

    public void parse(String file) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(null, new XMLReaderImpl());
        parser.parse(file);
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parse("auth.xml");
    }
}