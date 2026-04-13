import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import java.io.IOException;

public class java_13509_XMLParser_A01 {
    private DefaultHandler defaultHandler;

    public java_13509_XMLParser_A01() {
        this.defaultHandler = new DefaultHandler() {
            public void startDocument() throws SAXException {
                System.out.println("Start of XML Document");
            }

            public void endDocument() throws SAXException {
                System.out.println("End of XML Document");
            }

            public void startElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("Start of Element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End of Element: " + qName);
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                String content = new String(ch, start, length);
                System.out.println("Content inside element: " + content);
            }

            public void startPrefixMapping(String prefix, String uri) throws SAXException {
                System.out.println("Start of Prefix-Mapping: " + prefix + ", " + uri);
            }

            public void endPrefixMapping(String prefix) throws SAXException {
                System.out.println("End of Prefix-Mapping: " + prefix);
            }
        };
    }

    public void parseXML(String filePath) {
        try {
            File inputFile = new File(filePath);
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(defaultHandler);
            reader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SecuritySensitiveXMLParser parser = new SecuritySensitiveXMLParser();
        parser.parseXML("src/main/resources/example.xml");
    }
}