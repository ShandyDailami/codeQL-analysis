import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_07659_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "invalid.xml"; // the file to parse
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(new org.xml.sax.InputSource(new File(xmlFile)));
        saxParser.setProperty("http://apache.org/xml/features/nonvalidating/load-dtd", false);
        saxParser.setProperty("http://xml.apache.org/xml-features/error/strict", false);
        try {
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            SAXHandler saxHandler = new SAXHandler();
            saxParser.parse(new File(xmlFile), saxHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler implements org.xml.sax.helpers.DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
                throws SAXException {
            // do nothing
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // do nothing
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // do nothing
        }
    }
}