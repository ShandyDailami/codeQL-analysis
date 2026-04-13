import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_13659_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true); // constructor for SAXParser

            MyHandler myHandler = new MyHandler();

            saxParser.parse(new File("src/main/resources/security.xml"), myHandler); // parse XML file
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
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (bUsername && bPassword) {
                System.out.println("UserName: " + localName + ", Password: " + "********"); // print password
            }
            bUsername = false;
            bPassword = false;
        }
    }
}