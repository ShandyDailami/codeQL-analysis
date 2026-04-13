import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_19354_XMLParser_A08 {
    private static final String SAX_PARSER_LIB = "org.xml.sax";

    public void parse(String fileName) {
        SAXParserFactory spf = (SAXParserFactory) SAXParserFactory.newInstance();
        spf.setValidating(false);
        SAXParser saxParser = spf.newSAXParser();
        saxParser.setContentHandler(new SecureContentHandler());

        File xmlFile = new File(fileName);
        try {
            saxParser.parse(xmlFile, new SecureHandler());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private class SecureContentHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // do nothing, we're just parsing, nothing serious is happening here
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // do nothing, we're just parsing, nothing serious is happening here
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // do nothing, we're just parsing, nothing serious is happening here
        }
    }

    private class SecureHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // do nothing, we're just validating
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // do nothing, we're just validating
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // do nothing, we're just validating
        }
    }
}