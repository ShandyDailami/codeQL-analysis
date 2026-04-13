import java.net.URL;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_28689_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.example.com/sample.xml"); // Replace with your XML file URL
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(url.openConnection().getClass().getModule().getModuleClassLoader());
            SAXHandler sh = new SAXHandler();
            sp.parse(url.openStream(), sh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {
        boolean bUsername = false;
        boolean bPassword = false;
        String username = null;
        String password = null;

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
                username = new String(ch, start, length);
            } else if (bPassword) {
                password = new String(ch, start, length);
                // Here you can use this password for your authentication operation.
                // For simplicity, this example only prints the password.
                System.out.println("Password: " + password);
            }
        }
    }
}