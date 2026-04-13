import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import org.xml.sax.helpers.DefaultHandler;

public class java_31948_XMLParser_A03 {

    public static void main(String[] args) {
        String fileName = "sample.xml";
        parseFile(fileName);
    }

    public static void parseFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true); // Enable validation
        DocumentBuilder builder = factory.newDocumentBuilder();

        DefaultHandler handler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName,
                    Attributes attributes) throws SAXException {
                // Handle start element
            }

            public void endElement(String uri, String localName, String qName)
                    throws SAXException {
                // Handle end element
            }
        };

        try {
            Document document = builder.parse(new File(fileName));
            document.normalize();

            // Continue with SAX parsing

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}