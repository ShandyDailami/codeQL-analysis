import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.net.URL;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class java_17241_XMLParser_A07 {

    private static class MyHandler extends DefaultHandler {

        private boolean bUsername = false;
        private boolean bPassword = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("username")) {
                bUsername = true;
            } else if (qName.equals("password")) {
                bPassword = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals("username")) {
                bUsername = false;
            } else if (qName.equals("password")) {
                bPassword = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bUsername) {
                // handle username
            } else if (bPassword) {
                // handle password
            }
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser(null);

        MyHandler mh = new MyHandler();

        URL url = new URL("http://www.example.com/auth.xml");
        SAXSource source = new SAXSource(new InputSource(url.openStream()));

        sp.parse(source, mh);
    }
}