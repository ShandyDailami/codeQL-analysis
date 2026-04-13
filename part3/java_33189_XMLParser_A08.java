import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_33189_XMLParser_A08 {
    private static class MyHandler extends DefaultHandler {
        public void startDocument() throws SAXException {
            System.out.println("Document Started");
        }

        public void endDocument() throws SAXException {
            System.out.println("Document Ended");
        }

        public void startElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("Start of element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of element: " + qName);
        }

        public void startAttribute(String uri, String localName, String qName, String value) throws SAXException {
            System.out.println("Start of attribute: " + qName + " = " + value);
        }

        public void endAttribute(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of attribute: " + qName);
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            String s = new String(ch, start, length);
            System.out.println("Characters: " + s);
        }
    }

    public static void main(String[] args) {
        try {
            MyHandler handler = new MyHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse("src/test.xml"); // Replace with your XML file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}