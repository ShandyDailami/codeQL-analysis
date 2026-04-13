import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class java_21624_XMLParser_A07 extends DefaultHandler {

    private boolean isUsername = false;
    private boolean isPassword = false;
    private String currentElement = "";
    private List<String> usernames = new ArrayList<>();
    private List<String> passwords = new ArrayList<>();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if (qName.equals("username")) {
            isUsername = true;
        } else if (qName.equals("password")) {
            isPassword = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
        if (qName.equals("username")) {
            isUsername = false;
        } else if (qName.equals("password")) {
            isPassword = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isUsername) {
            usernames.add(new String(ch, start, length));
        } else if (isPassword) {
            passwords.add(new String(ch, start, length));
        }
    }

    public void parse() {
        // your XML parsing code here
    }

    public static void main(String[] args) {
        MyXMLHandler handler = new MyXMLHandler();
        // your XML parsing code here
    }
}