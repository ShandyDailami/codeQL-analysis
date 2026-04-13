import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_22199_XMLParser_A03 extends DefaultHandler {

    private boolean bUsername;
    private boolean bPassword;

    public java_22199_XMLParser_A03() {
        super();
        bUsername = false;
        bPassword = false;
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
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("username")) {
            bUsername = true;
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("username")) {
            bUsername = false;
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bUsername) {
            // You can use the value here for the injection attack.
            // If the value contains malicious code, it can be harmful.
            System.out.println("Username: " + new String(ch, start, length));
        }

        if (bPassword) {
            // You can use the value here for the injection attack.
            // If the value contains malicious code, it can be harmful.
            System.out.println("Password: " + new String(ch, start, length));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File("sample.xml"), new MyXMLHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}