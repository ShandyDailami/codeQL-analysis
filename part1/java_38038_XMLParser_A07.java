import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParserFactory;

public class java_38038_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser(true); // true for namespace support

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new InputStreamReader(new FileInputStream("test.xml")), myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {
    private boolean authFailure = false;
    private StringBuffer buffer = new StringBuffer();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        buffer.setLength(0);
        if ("AuthFailure".equals(localName)) {
            authFailure = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (authFailure && "AuthFailure".equals(localName)) {
            // Here you can add your security sensitive operation
            // For instance, you can check if the password is secure
            String password = buffer.toString();
            if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")) {
                System.out.println("Password is secure!");
            } else {
                System.out.println("Password is not secure!");
            }
            authFailure = false;
        }
    }
}