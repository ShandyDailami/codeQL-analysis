import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_02163_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser(null);
            XMLReader reader = XMLReaderFactory.createXMLReader();

            SecurityHandler handler = new SecurityHandler();
            reader.setContentHandler(handler);

            File inputFile = new File("src/main/resources/authfailure.xml");
            reader.parse(inputFile);

            System.out.println("Found " + handler.getAuthFailureCount() + " auth failures.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SecurityHandler extends DefaultHandler {
        private int authFailureCount = 0;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("authFailure")) {
                authFailureCount++;
            }
        }

        public int getAuthFailureCount() {
            return authFailureCount;
        }
    }
}