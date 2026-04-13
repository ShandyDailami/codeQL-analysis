import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_31431_XMLParser_A07 {

    private static class MyHandler extends DefaultHandler {

        private boolean isUsernameFound = false;
        private boolean isPasswordFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("username")) {
                isUsernameFound = true;
            } else if (qName.equalsIgnoreCase("password")) {
                isPasswordFound = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isUsernameFound) {
                // TODO: Implement authentication logic to secure sensitive operations.
                System.out.println(new String(ch, start, length));
                isUsernameFound = false;
            } else if (isPasswordFound) {
                // TODO: Implement authentication logic to secure sensitive operations.
                System.out.println(new String(ch, start, length));
                isPasswordFound = false;
            }
        }
    }

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        MyHandler myHandler = new MyHandler();
        saxParser.parse(new File("sample.xml"), myHandler);
    }
}