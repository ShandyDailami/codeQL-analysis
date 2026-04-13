import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class java_15853_XMLParser_A07 extends DefaultHandler {

    private boolean authFailure = false;

    @Override
    public void startElement(String uri, String localName, String qName,
                             javax.xml.parsers.ParserConfigurations parserConfigurations)
            throws SAXException {
        super.startElement(uri, localName, qName, parserConfigurations);

        if (localName.equals("authFailure")) {
            authFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        super.endElement(uri, localName, qName);

        if (localName.equals("authFailure")) {
            authFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        super.characters(ch, start, length);

        if (authFailure) {
            System.out.println("Authentication failed!");
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser(null);
            AuthFailureXMLParser handler = new AuthFailureXMLParser();
            sp.parse("src/main/resources/authFailure.xml", handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}