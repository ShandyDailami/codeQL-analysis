import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_06416_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            MyHandler myHandler = new MyHandler();
            saxParser.parse(new File("resources/passwords.xml"), myHandler);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyHandler extends DefaultHandler {
        boolean bUsername = false;
        boolean bPassword = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            if (qName.equalsIgnoreCase("username")) {
                bUsername = true;
            } else if (qName.equalsIgnoreCase("password")) {
                bPassword = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bUsername) {
                // Do something with username here
                System.out.println("Username: " + new String(ch, start, length));
                bUsername = false;
            } else if (bPassword) {
                // Do something with password here
                System.out.println("Password: " + new String(ch, start, length));
                bPassword = false;
            }
        }
    }
}