import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_25027_XMLParser_A07 extends DefaultHandler {

    private boolean authFailure = false;

    public void parse(String file) throws IOException, SAXException {
        File inputFile = new File(file);
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        XMLReader xr = XMLReaderFactory.createXMLReader();
        xr.setContentHandler(this);
        xr.parse(inputFile);
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("AuthFailure")) {
            authFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("AuthFailure")) {
            if (!authFailure) {
                throw new SAXException("AuthFailure element not found.");
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        // not used
    }

    @Override
    public void endDocument() throws SAXException {
        if (!authFailure) {
            throw new SAXException("AuthFailure element not found in the document.");
        }
    }

    public static void main(String[] args) throws IOException, SAXException {
        AuthFailureXMLParser parser = new AuthFailureXMLParser();
        parser.parse("input.xml");
    }
}