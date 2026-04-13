import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_06652_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlFile = "authFailure.xml";

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null, new MyHandler());
            saxParser.parse(new File(xmlFile));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    boolean bUsername = false;
    boolean bPassword = false;
    boolean bAuthFailure = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            bAuthFailure = true;
        } else if (qName.equalsIgnoreCase("username")) {
            bUsername = true;
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            bAuthFailure = false;
        } else if (qName.equalsIgnoreCase("username")) {
            bUsername = false;
        } else if (qName.equalsIgnoreCase("password")) {
            bPassword = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bAuthFailure) {
            // Handle the 'authFailure' element
            String s = new String(ch, start, length);
            System.out.println("AuthFailure: " + s);
        } else if (bUsername) {
            // Handle the 'username' element
            String s = new String(ch, start, length);
            System.out.println("Username: " + s);
        } else if (bPassword) {
            // Handle the 'password' element
            String s = new String(ch, start, length);
            System.out.println("Password: " + s);
        }
    }
}