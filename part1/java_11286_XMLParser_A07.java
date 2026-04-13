import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_11286_XMLParser_A07 extends DefaultHandler {
    private boolean isUsername = false;
    private boolean isPassword = false;
    private String username = null;
    private String password = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("Username")) {
            isUsername = true;
        } else if (qName.equals("Password")) {
            isPassword = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("Username")) {
            isUsername = false;
        } else if (qName.equals("Password")) {
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

    public void parse(String file) throws Exception {
        javax.xml.parsers.SAXParserFactory factory = SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser parser = factory.newSAXParser();
        parser.parse(file, this);

        if (username != null && password != null) {
            // perform authentication here
            // for now, just print them
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }
    }
}