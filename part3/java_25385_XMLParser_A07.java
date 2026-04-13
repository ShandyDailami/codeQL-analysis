import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_25385_XMLParser_A07 extends DefaultHandler {

    private boolean isUsername;
    private boolean isPassword;
    private String currentValue;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start of XML document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End of XML document");
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
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isUsername) {
            currentValue = new String(ch, start, length);
            isUsername = false;
        } else if (isPassword) {
            currentValue += new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("username")) {
            System.out.println("Username: " + currentValue);
            isUsername = false;
        } else if (qName.equalsIgnoreCase("password")) {
            System.out.println("Password: " + currentValue);
            isPassword = false;
        }
    }

    public static void main(String[] args) {
        MyXMLParser myXMLParser = new MyXMLParser();
        myXMLParser.parse("src/main/resources/sample.xml");
    }

}