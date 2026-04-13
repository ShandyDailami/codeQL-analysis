import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.io.File;

public class java_09131_XMLParser_A01 {
    public static void parse(String filename) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        saxParser.parse(new File(filename), new MyHandler());
    }

    static class MyHandler extends DefaultHandler {
        private boolean bUser;
        private boolean bPassword;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("user")) {
                bUser = true;
            } else if (qName.equalsIgnoreCase("password")) {
                bPassword = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("user")) {
                bUser = false;
            } else if (qName.equalsIgnoreCase("password")) {
                bPassword = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bUser) {
                // Here we can put the code to securely access user credentials.
                // In a real-world scenario, you'd need to handle this in a way that
                // protects against security threats such as SQL Injection or Cross-Site Scripting (XSS).
                // This is a placeholder for your actual implementation.
                System.out.println("User: " + new String(ch, start, length));
            } else if (bPassword) {
                // Similar logic as above, but for passwords.
                System.out.println("Password: " + new String(ch, start, length));
            }
        }
    }

    public static void main(String[] args) {
        try {
            parse("sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}