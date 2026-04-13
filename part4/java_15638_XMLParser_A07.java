import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParser;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_15638_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            MyHandler handler = new MyHandler();
            saxParser.parse(new File("src/main/resources/authFailure.xml"), handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXParseException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private static final String AUTH_FAILURE = "A07_AuthFailure";
        private static final String TAG_NAME = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase(AUTH_FAILURE)) {
                // Do something with the auth failure data
                System.out.println("AuthFailure event detected!");
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase(AUTH_FAILURE)) {
                // Do something with the end of auth failure data
                System.out.println("End of AuthFailure event!");
            }
        }
    }
}