import java.io.File;
import java.io.IOException;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_02171_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            DefaultHandler defaultHandler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, java.util.Properties properties) throws SAXException {
                    // Start of code
                    // Broken access control operations start here
                    // End of code
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    // End of code
                }
            };

            saxParser.parse(new File("input.xml"), defaultHandler);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    private static class BrokenAccessControl {
        public void start() {
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                @Override
                public Void run() {
                    // Broken access control operations here
                    return null;
                }
            });
        }

        public void end() {
            // Broken access control operations here
        }
    }

}