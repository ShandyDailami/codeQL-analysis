import java.io.File;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.SAXDriver;

public class java_16713_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("input.xml"); // replace with your xml file

        SAXDriver saxDriver = new SAXDriver() {
            public void startElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("Start Element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End Element: " + qName);
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }

            public void startPrefixMapping(String prefix, String uri) throws SAXException {
                System.out.println("Start Prefix Mapping: " + prefix + ", " + uri);
            }

            public void endPrefixMapping(String prefix) throws SAXException {
                System.out.println("End Prefix Mapping: " + prefix);
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(saxDriver);
            reader.setErrorHandler(saxDriver);
            reader.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}