import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_34871_XMLParser_A07 {

    private class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // Handle the start element of the XML document
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Handle the end element of the XML document
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Handle characters in the XML document
        }
    }

    public void parseXML(String fileName) {
        File file = new File(fileName);
        try {
            SAXReader reader = new SAXReader();
            MyHandler handler = new MyHandler();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader(handler);
            xmlReader.setFeature("http://xml.org/sax/features/namespaces", true);
            xmlReader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
            xmlReader.setFeature("http://xml.org/sax/features/validation", false);
            xmlReader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            xmlReader.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            xmlReader.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}