import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_13324_XMLParser_A07 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            MyHandler myHandler = new MyHandler();
            XMLReader xmlReader = XMLReaderFactory.newInstance().createXMLReader(myHandler);

            saxParser.parse(new File("yourfile.xml"), myHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class MyHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            // Place for security-sensitive operations related to A07_AuthFailure
            // e.g. logging, checking for credentials, etc.
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // End of a tag
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Place for security-sensitive operations related to A07_AuthFailure
            // e.g. cleaning up characters, etc.
        }
    }
}