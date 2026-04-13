import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_29087_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "src/main/resources/A07_AuthFailure.xml";
        File xmlFileObj = new File(xmlFile);

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            MyHandler handler = new MyHandler();

            parser.parse(xmlFileObj, handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {
        private boolean bUsernameFound = false;
        private boolean bPasswordFound = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("username")) {
                bUsernameFound = true;
            } else if (qName.equalsIgnoreCase("password")) {
                bPasswordFound = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (bUsernameFound) {
                System.out.println("Username found! Stop parsing!");
                bUsernameFound = false;
            } else if (bPasswordFound) {
                System.out.println("Password found! Stop parsing!");
                bPasswordFound = false;
            }
        }
    }
}