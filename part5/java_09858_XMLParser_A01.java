import java.io.FileInputStream;
import java.io.InputStream;
import java.security.AccessControlException;
import java.security.AccessControlListener;
import java.security.Guard;
import java.util.Iterator;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_09858_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Create a listener to handle access control
            AccessControlListener accessControlListener = new AccessControlListener() {
                public void grantingAccess(Guard guard) {
                    // grant access
                }

                public void refusingAccess(Guard guard) {
                    // deny access
                    throw new AccessControlException("Access Denied");
                }
            };

            // Set the access control listener for the security manager
            System.setSecurityManager(new SecurityManager() {
                @Override
                public void checkAccess(Guard guard) {
                    accessControlListener.refusingAccess(guard);
                }
            });

            // Create a SAX parser factory
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

            // Create a SAX parser
            SAXParser saxParser = saxParserFactory.newSAXParser();

            // Create a stream
            InputStream inputStream = new FileInputStream("sample.xml");

            // Parse the XML
            saxParser.parse(inputStream, new MyHandler());

            // Close the input stream
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // A handler for SAX events
    private static class MyHandler implements SAXHandler {

        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            System.out.println("Start element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            System.out.println("End element: " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}