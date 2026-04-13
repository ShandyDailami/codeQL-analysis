import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_11727_XMLParser_A08 {

    private static class MyHandler implements javax.xml.parsers.SAXHandler {

        private boolean integrityFailure = false;

        @Override
            public void startElement(String uri, String localName, String qName, javax.xml.parsers.Attributes attributes)
                throws SAXException {
            if (integrityFailure) {
                throw new SAXException("IntegrityFailure: Attribute '" + qName + "' not allowed here");
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // nothing to do here
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // nothing to do here
        }
    }

    public static void main(String[] args) {
        File xmlFile = new File("legacy.xml");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(new org.xml.sax.InputSource(java.net.URL.NULL, new java.io.StringReader("")));
            MyHandler myHandler = new MyHandler();
            saxParser.setContentHandler(myHandler);
            saxParser.parse(xmlFile, xmlHandler);
        } catch (SAXException e) {
            System.out.println("SAXException: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}