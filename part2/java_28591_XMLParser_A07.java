import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXSource;
import org.xml.sax.XMLReader;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_28591_XMLParser_A07 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(null);
            SAXHandler handler = new SAXHandler();
            XMLReader xmlReader = saxParser.getXMLReader();

            SAXSource source = new SAXSource(xmlReader, true);
            xmlReader.setContentHandler(handler);

            xmlReader.parse(source);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXHandler extends DefaultHandler {
    private boolean authFailure = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            authFailure = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("authFailure")) {
            authFailure = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (authFailure) {
            // Here you can handle the security sensitive operation.
            System.out.println("AuthFailure Detected: " + new String(ch, start, length));
        }
    }
}