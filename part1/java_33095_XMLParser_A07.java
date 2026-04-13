import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_33095_XMLParser_A07 extends DefaultHandler {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser();
            AuthFailureParser handler = new AuthFailureParser();
            parser.parse(xmlFile, handler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private int failures = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("failure".equals(localName)) {
            failures++;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // No action required
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // No action required
    }

    public int getFailures() {
        return failures;
    }
}