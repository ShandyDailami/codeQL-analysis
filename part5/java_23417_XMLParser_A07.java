import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_23417_XMLParser_A07 extends DefaultHandler {
    private boolean bUserName = false;
    private boolean bPassword = false;
    private boolean bAuthFailure = false;

    public void startDocument() {
        System.out.println("Start of Document");
    }

    public void endDocument() {
        System.out.println("End of Document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("user")) {
            bUserName = true;
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = true;
        } else if (qName.equalsIgnoreCase("authFailure")) {
            bAuthFailure = true;
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("user")) {
            bUserName = false;
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = false;
        } else if (qName.equalsIgnoreCase("authFailure")) {
            bAuthFailure = false;
        }
    }

    public void characters(char[] ch, int start, int length) {
        if (bUserName) {
            System.out.println("User: " + new String(ch, start, length));
        } else if (bPassword) {
            System.out.println("Password: " + new String(ch, start, length));
        } else if (bAuthFailure) {
            System.out.println("AuthFailure: " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser saxParser = spf.newSAXParser();
            saxParser.parse("src/main/resources/authFailure.xml", new MyXMLParser());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}