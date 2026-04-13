import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXHelper;

public class java_31863_XMLParser_A01 extends DefaultHandler {

    private String lastTag;
    private boolean foundUser;
    private boolean foundPassword;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastTag = qName;
        foundUser = qName.equals("user");
        foundPassword = qName.equals("password");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        lastTag = "";
        if (qName.equals("user")) {
            foundUser = false;
        } else if (qName.equals("password")) {
            foundPassword = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (foundUser) {
            System.out.println("User: " + new String(ch, start, length));
        } else if (foundPassword) {
            System.out.println("Password: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        String xml = "<data><user>John</user><password>1234</password></data>";
        SAXHelper saxHelper = new SAXHelper();
        XmlParser handler = new XmlParser();
        saxHelper.setContentHandler(handler);
        try {
            saxHelper.parse(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}