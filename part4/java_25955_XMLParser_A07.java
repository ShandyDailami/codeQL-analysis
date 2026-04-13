import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_25955_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_file.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            AuthFailureHandler handler = new AuthFailureHandler();
            parser.setContentHandler(handler);
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

}

class AuthFailureHandler implements org.xml.sax.helpers.DefaultHandler {

    private boolean authFailure = false;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equals("authFailure")) {
            authFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("authFailure")) {
            if (authFailure) {
                System.out.println("Auth Failure detected!");
            } else {
                System.out.println("Auth Failure not detected!");
            }
            authFailure = false;
        }
    }

}