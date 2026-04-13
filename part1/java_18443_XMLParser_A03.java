import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_18443_XMLParser_A03 {

    // Default handler
    private static class MyHandler extends DefaultHandler {

        @Override
        public void startDocument() {
            // Do nothing
        }

        @Override
        public void endDocument() {
            // Do nothing
        }

        @Override
        public void startElement(String uri, String localName, String qName) {
            // Do nothing
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            // Do nothing
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            // Do nothing
        }
    }

    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        XMLReader xmlReader = null;
        MyHandler myHandler = new MyHandler();

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(myHandler);
            xmlReader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (xmlReader != null) {
                xmlReader.getParserPool().clear();
            }
        }
    }
}