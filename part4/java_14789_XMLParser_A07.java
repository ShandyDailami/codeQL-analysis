import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLReader;
import org.xml.sax.parser.XMLLoader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_14789_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "authfailure.xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            SAXReaderHandler handler = new SAXReaderHandler();

            XMLParser xmlParser = XMLReader.newInstance().usingHandler(handler);
            xmlParser.parse(new File(xmlFile));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAXReaderHandler extends DefaultHandler {

        private boolean bName;
        private boolean bPassword;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {

            if (qName.equalsIgnoreCase("user")) {
                bName = true;
                bPassword = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bName) {
                // Handle user name
                System.out.println("User Name: " + new String(ch, start, length));
                bName = false;
            } else if (bPassword) {
                // Handle password
                System.out.println("Password: " + new String(ch, start, length));
                bPassword = false;
            }
        }
    }
}