import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class java_41729_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserExample example = new SAXParserExample();
        example.parse("auth.xml");
    }

    private void parse(String file) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(null, new MyHandler());
            InputStream inputStream = getClass().getResourceAsStream("/" + file);

            parser.parse(inputStream, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class MyHandler extends DefaultHandler {
        private boolean bUsername = false;
        private boolean bPassword = false;
        private String strUsername = null;
        private String strPassword = null;

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

            if (bUsername && bPassword) {
                System.out.println("Username: " + strUsername + ", Password: " + strPassword);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bUsername) {
                strUsername = new String(ch, start, length);
            } else if (bPassword) {
                strPassword = new String(ch, start, length);
            }
        }
    }
}