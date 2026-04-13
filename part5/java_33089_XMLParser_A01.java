import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_33089_XMLParser_A01 {

    public static class SecureHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                String version) throws SAXException {
            // Security sensitive operation: reading elements
            System.out.println("Reading element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            // Security sensitive operation: writing elements
            System.out.println("Writing element: " + qName);
        }
    }

    public static void main(String[] args) {
        try {
            // Use secure handler for parsing
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("broken_access_control.xml"));

            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new SecureHandler());
            reader.parse(new File("broken_access_control.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}