import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class java_05750_XMLParser_A01 {

    public static void parse(String filename, String userCredentials) throws FileNotFoundException, SAXException {
        InputStream inputStream = new FileInputStream(filename);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser(new InputSource(inputStream));

        MyHandler handler = new MyHandler(userCredentials);
        parser.parse(inputStream, handler);
    }

    static class MyHandler extends DefaultHandler {
        private final String userCredentials;
        private StringBuilder data;

        public java_05750_XMLParser_A01(String userCredentials) {
            this.userCredentials = userCredentials;
            this.data = new StringBuilder();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("credentials")) {
                // You can change this line to allow or deny access based on userCredentials
                if (userCredentials.equals("allowed")) {
                    // This will cause a SAXException to stop parsing
                    throw new SAXException("Access denied!");
                }
            }
            data = new StringBuilder();
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // You can handle elements here
            if (qName.equals("credentials")) {
                System.out.println("Credentials: " + data.toString());
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            data.append(new String(ch, start, length));
        }
    }
}