import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_26274_XMLParser_A01 {

    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;

    public java_26274_XMLParser_A01() {
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
    }

    public void parse(String file) throws SAXException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(new DefaultHandler() {
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                System.out.println("Start Element: " + qName);
            }
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End Element: " + qName);
            }
            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }
            public void fatalError(SAXParseException e) throws SAXException {
                System.out.println("Fatal Error: " + e.getMessage());
            }
            public void warning(SAXParseException e) throws SAXException {
                System.out.println("Warning: " + e.getMessage());
            }
        });
        reader.parse(file);
    }

    public static void main(String[] args) {
        SecureXMLParser parser = new SecureXMLParser();
        try {
            parser.parse("sample.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}