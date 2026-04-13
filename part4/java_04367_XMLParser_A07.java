import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_04367_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try (SAXParser saxParser = saxParserFactory.newSAXParser()) {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            AuthFailureHandler authFailureHandler = new AuthFailureHandler();
            xmlReader.setContentHandler(authFailureHandler);

            xmlReader.parse(new File("authFailure.xml"));

            System.out.println("Number of Auth Failures: " + authFailureHandler.getNumAuthFailures());
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}

class AuthFailureHandler extends DefaultHandler {
    private int numAuthFailures = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("authFailure".equals(qName)) {
            numAuthFailures++;
        }
    }

    public int getNumAuthFailures() {
        return numAuthFailures;
    }
}