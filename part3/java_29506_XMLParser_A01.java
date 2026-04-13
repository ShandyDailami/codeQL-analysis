import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_29506_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            FileInputStream input = new FileInputStream("sample.xml");
            SAXReader reader = new SAXReader();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();

            xmlReader.setContentHandler(new ContentHandler());
            xmlReader.parse(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class ContentHandler implements ContentHandlerInterface {
        public void startDocument() throws SAXException {
            System.out.println("Start Document");
        }

        public void endDocument() throws SAXException {
            System.out.println("End Document");
        }

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start Element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + qName);
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

    interface ContentHandlerInterface {
        void startDocument() throws SAXException;
        void endDocument() throws SAXException;
        void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException;
        void endElement(String uri, String localName, String qName) throws SAXException;
        void characters(char[] ch, int start, int length) throws SAXException;
    }
}