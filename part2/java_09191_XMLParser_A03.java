import java.security.SecureRandom;
import java.util.Base64;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_09191_XMLParser_A03 {

    public static void main(String[] args) {
        // Create a new SAXParserFactory
        SAXParserFactory spf = SAXParserFactory.newInstance();

        // Create a new SAXParser
        SAXParser saxParser = spf.newSAXParser(null);

        // Create a new SAXHandler
        MySAXHandler saxHandler = new MySAXHandler();

        // Parse the XML data
        try {
            saxParser.parse("src/test.xml", saxHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define a SAXHandler
    class MySAXHandler extends DefaultHandler {
        boolean isName = false;
        boolean isAge = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equals("name")) {
                isName = true;
            } else if (qName.equals("age")) {
                isAge = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isName) {
                // Here we are using a random Base64 encoding to prevent injection attacks
                String randomString = new String(ch, start, length);
                String encodedString = new String(Base64.getEncoder().encode(randomString.getBytes()));
                System.out.println("Name: " + encodedString);
                isName = false;
            } else if (isAge) {
                String randomString = new String(ch, start, length);
                String encodedString = new String(Base64.getEncoder().encode(randomString.getBytes()));
                System.out.println("Age: " + encodedString);
                isAge = false;
            }
        }
    }
}