import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_38131_XMLParser_A01 {

    private static final String XML_FILE_PATH = "path_to_your_xml_file";

    public static void main(String[] args) {
        File xmlFile = new File(XML_FILE_PATH);
        XMLReader xmlReader = null;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new MyContentHandler());
            xmlReader.parse(xmlFile);
            System.out.println("Access to XML file is secure.");
        } catch (IOException | SAXException e) {
            System.out.println("Access to XML file is not secure due to: " + e.getMessage());
       
        } finally {
            if (xmlReader != null) {
                xmlReader.close();
            }
        }
    }

    static class MyContentHandler implements org.xml.sax.ContentHandler {

        @Override
        public void startDocument() throws SAXException {
            // Empty
        }

        @Override
        public void endDocument() throws SAXException {
            // Empty
        }

        @Override
        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
            // Empty
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            // Empty
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // Empty
        }
    }
}