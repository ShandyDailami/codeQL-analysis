import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.XMLReader;
import java.io.File;
import java.io.IOException;

public class java_06874_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "example.xml"; // Provide your XML file path here
        parseXmlFile(xmlFile);
    }

    private static void parseXmlFile(String xmlFile) {
        File xml = new File(xmlFile);
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new XMLEventHandler());
            reader.parse(xml.getAbsoluteFile());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class XMLEventHandler implements ContentHandler {
        private boolean bElement = false;
        private String elementName = "";

        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {
            bElement = true;
            elementName = localName;
        }

        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            bElement = false;
            if (bElement) {
                System.out.println(elementName);
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            // not implemented
        }
    }
}