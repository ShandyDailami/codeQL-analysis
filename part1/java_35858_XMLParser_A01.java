import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.File;
import java.io.IOException;

public class java_35858_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml"; // Replace with your XML file path
        File xmlFile = new File(xmlFilePath);

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setFeature("http://xml.org/sax/features/namespaces", true);
            reader.setFeature("http://xml.org/sax/features/namespace-prefixes", true);
            reader.setFeature("http://xml.org/sax/features/validation", false);
            reader.setFeature("http://xml.org/sax/features/external-parameter-entity-references", false);
            reader.setFeature("http://xml.org/sax/features/runaway-tags", false);

            SAXHandler handler = new SAXHandler();
            reader.setContentHandler(handler);

            reader.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static class SAXHandler implements org.xml.sax.helpers.DefaultHandler {

        public void startDocument() throws SAXException {
            System.out.println("Start of document");
        }

        public void endDocument() throws SAXException {
            System.out.println("End of document");
        }

        public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
            System.out.println("Start of element: " + qName);
        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End of element: " + qName);
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }
}