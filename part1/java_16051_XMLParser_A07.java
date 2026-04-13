import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_16051_XMLParser_A07 extends DefaultHandler {

    private List<String> usernames;
    private List<String> passwords;

    public java_16051_XMLParser_A07() {
        usernames = new ArrayList<>();
        passwords = new ArrayList<>();
    }

    public void parse(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyXMLHandler(this));
            saxParser.parse(fileName);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("user")) {
            usernames.add(attributes.getValue("username"));
            passwords.add(attributes.getValue("password"));
        }
    }

    public List<String> getUsernames() {
        return usernames;
    }

    public List<String> getPasswords() {
        return passwords;
    }
}

class MyXMLHandler extends DefaultHandler {

    private MyXMLParser parser;

    public java_16051_XMLParser_A07(MyXMLParser parser) {
        this.parser = parser;
    }

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
        if (qName.equals("users")) {
            parser.parse(localName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element " + localName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}